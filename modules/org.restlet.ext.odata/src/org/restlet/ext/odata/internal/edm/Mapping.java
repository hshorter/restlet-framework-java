/**
 * Copyright 2005-2010 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.odata.internal.edm;

/**
 * Defines a property mapping used in customized feeds. It maps an XML element
 * of the feed to parse and a property of entity.
 * 
 * @author Thierry Boileau
 * @see <a href="http://msdn.microsoft.com/en-us/library/ee373839.aspx">Atom
 *      Feed Customization (ADO.NET Data Services)</a>
 */
public class Mapping {

    /** Is the value taken from an attribute or not. */
    private boolean attributeValue;

    /** The namespace prefix of the feed's XML element that stores the value. */
    private String nsPrefix;

    /** The namespace URI of the feed's XML element that stores the value. */
    private String nsUri;

    /** The path of the property to update. */
    private String propertyPath;

    /** The type of the entity to update. */
    private EntityType type;

    /** The path of the XML element of the feed that stores the value to set. */
    private String valuePath;

    /**
     * Constructor.
     * 
     * @param type
     *            The type of the entity to update.
     * @param nsPrefix
     *            The namespace prefix of the feed's XML element that stores the
     *            value.
     * @param nsUri
     *            The namespace URI of the feed's XML element that stores the
     *            value.
     * @param propertyPath
     *            The type of the entity to update.
     * @param valuePath
     *            The path of the XML element of the feed that stores the value
     *            to set.
     */
    public Mapping(EntityType type, String nsPrefix, String nsUri,
            String propertyPath, String valuePath) {
        super();
        this.type = type;
        this.nsPrefix = nsPrefix;
        this.nsUri = nsUri;
        this.propertyPath = propertyPath;
        this.valuePath = valuePath;
        this.attributeValue = false;
        if (this.valuePath != null) {
            int index = valuePath.lastIndexOf("/");
            if (index != -1 && valuePath.length() > index) {
                attributeValue = ('@' == valuePath.charAt(index + 1));
            }
        }
    }

    /**
     * Returns the namespace prefix of the feed's XML element that stores the
     * value.
     * 
     * @return The namespace prefix of the feed's XML element that stores the
     *         value.
     */
    public String getNsPrefix() {
        return nsPrefix;
    }

    /**
     * Returns the namespace URI of the feed's XML element that stores the
     * value.
     * 
     * @return The namespace URI of the feed's XML element that stores the
     *         value.
     */
    public String getNsUri() {
        return nsUri;
    }

    /**
     * Returns the path of the property to update.
     * 
     * @return The path of the property to update.
     */
    public String getPropertyPath() {
        return propertyPath;
    }

    /**
     * Returns the type of the entity to update.
     * 
     * @return The type of the entity to update.
     */
    public EntityType getType() {
        return type;
    }

    /**
     * Returns the path of the XML element of the feed that stores the value to
     * set.
     * 
     * @return The path of the XML element of the feed that stores the value to
     *         set.
     */
    public String getValuePath() {
        return valuePath;
    }

    /**
     * Returns the name of the attribute that stores the value to set, if
     * pertinent, and null otherwise.
     * 
     * @return The he name of the attribute that stores the value to set.
     */
    public String getValueAttributeName() {
        String result = null;
        if (isAttributeValue()) {
            int index = valuePath.lastIndexOf("/");
            result = valuePath.substring(index + 2, valuePath.length());
        }
        return result;
    }

    /**
     * Returns the name of the attribute that stores the value to set, if
     * pertinent, and null otherwise.
     * 
     * @return The he name of the attribute that stores the value to set.
     */
    public String getValueNodePath() {
        return (isAttributeValue()) ? valuePath.substring(0, valuePath
                .lastIndexOf("/")) : valuePath;
    }

    /**
     * Returns true if the value is taken from an attribute.
     * 
     * @return True if the value is taken from an attribute.
     */
    public boolean isAttributeValue() {
        return attributeValue;
    }
}
