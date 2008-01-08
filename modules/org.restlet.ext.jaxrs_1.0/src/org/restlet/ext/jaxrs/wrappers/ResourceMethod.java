/*
 * Copyright 2005-2007 Noelios Consulting.
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the "License"). You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL HEADER in each file and
 * include the License file at http://www.opensource.org/licenses/cddl1.txt If
 * applicable, add the following below this CDDL HEADER, with the fields
 * enclosed by brackets "[]" replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package org.restlet.ext.jaxrs.wrappers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;

import org.restlet.data.MediaType;
import org.restlet.ext.jaxrs.JaxRsRouter;
import org.restlet.ext.jaxrs.util.Util;

/**
 * A method of a resource class annotated with a request method designator that
 * is used to handle requests on the corresponding resource, see section 2.2.
 * 
 * @author Stephan Koops
 * 
 */
public class ResourceMethod extends AbstractMethodWrapper {

    private List<MediaType> producedMimes;

    private List<MediaType> consumedMimes;

    private org.restlet.data.Method httpMethod;

    /**
     * Creates a wrapper for a resource method.
     * 
     * @param javaMethod
     *                the Java method to wrap.
     * @param path
     *                the path of the method.
     * @param resourceClass
     *                the wrapped class of the method.
     * @param httpMethod
     *                the HTTP method of the Java method. It will be checked be
     *                the {@link JaxRsRouter}, so avoiding double work. It will
     *                be requested from the javaMethod.
     */
    public ResourceMethod(Method javaMethod, Path path,
            ResourceClass resourceClass, org.restlet.data.Method httpMethod) {
        super(javaMethod, path, resourceClass);
        this.httpMethod = httpMethod;
    }

    /**
     * Determine the media type if a produced entity. see JSR-311-Spec, Section
     * 2.6 "Determining the MediaType of Responses" <br />
     * Is not ready implemented, yet.
     * 
     * @param result
     * @return Returns the media type of the produced Entity.
     */
    @SuppressWarnings("all")
    public MediaType getProducedMediaType(Object entity) {
        // LATER getProducedMediaType(.): see JSR-311-Spec, Section 2.6
        // "Determining the MediaType of Responses"
        List<MediaType> producedMimes = this.getProducedMimes();
        Iterator<MediaType> prodMimeIter = producedMimes.iterator();
        while (prodMimeIter.hasNext()) {
            MediaType producedMime = prodMimeIter.next();
            if (producedMime.getSubType().equals("*"))
                prodMimeIter.remove();
        }
        if (producedMimes.isEmpty())
            return MediaType.APPLICATION_OCTET_STREAM;
        if (producedMimes.size() == 1)
            return producedMimes.get(0);
        return MediaType.APPLICATION_OCTET_STREAM;
    }

    /**
     * @return Returns an unmodifiable List of MediaTypes the given Resource
     *         Method or Resource Class produces. If no MediaType was given, a
     *         empty List will returned. Will never return null.
     */
    public List<MediaType> getProducedMimes() {
        if (producedMimes == null) {
            ProduceMime produceMime = this.javaMethod
                    .getAnnotation(ProduceMime.class);
            if (produceMime == null)
                produceMime = this.javaMethod.getAnnotation(ProduceMime.class);
            if (produceMime == null)
                this.producedMimes = Collections.emptyList();
            else
                this.producedMimes = convertToMediaTypes(produceMime.value());
        }
        return producedMimes;
    }

    /**
     * @return Returns an unmodifiable List with the MediaTypes the given
     *         resourceMethod consumes. If no consumeMime is given, this method
     *         returns a List with MediaType.ALL. Will never return null.
     */
    public List<MediaType> getConsumedMimes() {
        if (this.consumedMimes == null) {
            ConsumeMime consumeMime = this.javaMethod
                    .getAnnotation(ConsumeMime.class);
            if (consumeMime == null)
                consumeMime = this.javaMethod.getAnnotation(ConsumeMime.class);
            if (consumeMime == null)
                return Collections.singletonList(MediaType.ALL);
            this.consumedMimes = convertToMediaTypes(consumeMime.value());
        }
        return consumedMimes;
    }

    /**
     * Check if this method supports the media type to produce for a request.
     * 
     * @param accMediaTypess
     *                The Media Types the client would accept, ordered by
     *                quality. See {@link Util#sortMetadataList(Collection)}
     * @return Returns true, if the give MediaType is supported by the method,
     *         or no MediaType is given for the method, otherweise false.
     */
    public boolean isAcceptedMediaTypeSupported(
            List<Collection<MediaType>> accMediaTypess) {
        if (accMediaTypess == null || accMediaTypess.isEmpty())
            return true;
        List<MediaType> prodMimes = getProducedMimes();
        if (prodMimes.isEmpty())
            return true;
        for (MediaType producedMediaType : prodMimes) {
            for (Collection<MediaType> accMediaTypes : accMediaTypess)
                for (MediaType accMediaType : accMediaTypes)
                    if (accMediaType.includes(producedMediaType))
                        return true;
        }
        return false;
    }

    /**
     * 
     * @param resourceMethod
     * @param requestedMethod
     * @return true, if the gien java method is annotated with a runtime
     *         designator for the given requested Method. If the requested
     *         method is null, than the method returns true, when the method is
     *         annotated with any runtime desginator.
     * @see #annotatedWithMethodDesignator(Method)
     */
    public boolean isHttpMethodSupported(org.restlet.data.Method requestedMethod) {
        if (requestedMethod == null)
            throw new IllegalArgumentException(
                    "null is not a valid HTTP method");
        if (this.httpMethod == null)
            this.httpMethod = getHttpMethod(this.javaMethod);
        return this.httpMethod.equals(requestedMethod);
    }

    static org.restlet.data.Method getHttpMethod(Method javaMethod) {
        for (Annotation annotation : javaMethod.getAnnotations()) {
            Class<? extends Annotation> annoType = annotation.annotationType();
            HttpMethod httpMethodAnnot = annoType
                    .getAnnotation(HttpMethod.class);
            if (httpMethodAnnot != null) { // Annotation der Annotation der
                // Methode ist HTTP-Methode
                String httpMethodName = httpMethodAnnot.value();
                return org.restlet.data.Method.valueOf(httpMethodName);
            }
        }
        return null;
    }

    /**
     * @param resourceMethod
     *                the resource method to check
     * @param givenMediaType
     *                the MediaType of the request entity
     * @return Returns true, if the given MediaType is supported by the method,
     *         or no MediaType is given for the method, otherweise false;
     */
    public boolean isGivenMediaTypeSupported(MediaType givenMediaType) {
        if (givenMediaType == null)
            return true;
        for (MediaType consumedMime : this.getConsumedMimes()) {
            if (consumedMime.includes(givenMediaType))
                return true;
        }
        return false;
    }

    /**
     * Converts the given mimes to a List of MediaTypes. Will never returns
     * null.
     * 
     * @param mimes
     * @return Returns an unmodifiable List of MediaTypes
     */
    private static List<MediaType> convertToMediaTypes(String[] mimes) {
        List<MediaType> mediaTypes = new ArrayList<MediaType>(mimes.length);
        for (String mime : mimes) {
            if (mime == null)
                mediaTypes.add(MediaType.ALL);
            else
                mediaTypes.add(MediaType.valueOf(mime));
        }
        return Collections.unmodifiableList(mediaTypes);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + javaMethod.toString()
                + ", " + this.httpMethod + "]";
    }
}