package org.restlet.example.book.restlet.ch09.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator implements org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenBundle {
  private static TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator _instance0 = new TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator();
  private void logoInitializer() {
    logo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "logo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 140, 75, false, false
    );
  }
  private static class logoInitializer {
    static {
      _instance0.logoInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return logo;
    }
  }
  public com.google.gwt.resources.client.ImageResource logo() {
    return logoInitializer.get();
  }
  private void logoIe6DataInitializer() {
    logoIe6Data = // file:/C:/Projets/framework/java-2.1/modules/org.restlet.example.book.restlet.ch09.gwt/src/org/restlet/example/book/restlet/ch09/client/logo_ie6.gif
    new com.google.gwt.resources.client.impl.DataResourcePrototype(
      "logoIe6Data",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString("data:image/gif;base64,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")
    );
  }
  private static class logoIe6DataInitializer {
    static {
      _instance0.logoIe6DataInitializer();
    }
    static com.google.gwt.resources.client.DataResource get() {
      return logoIe6Data;
    }
  }
  public com.google.gwt.resources.client.DataResource logoIe6Data() {
    return logoIe6DataInitializer.get();
  }
  private void styleInitializer() {
    style = new org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GL0P3EKCFJ{text-align:" + ("left")  + ";margin:" + ("1em")  + ";}.GL0P3EKCDJ{text-align:" + ("left")  + ";}.GL0P3EKCEJ{height:" + ((TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getHeight() + "px")  + ";width:" + ((TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getSafeUri().asString() + "\") -" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getLeft() + "px -" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getTop() + "px  no-repeat")  + ";position:" + ("absolute")  + ";}")) : ((".GL0P3EKCFJ{text-align:" + ("right")  + ";margin:" + ("1em")  + ";}.GL0P3EKCDJ{text-align:" + ("right")  + ";}.GL0P3EKCEJ{height:" + ((TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getHeight() + "px")  + ";width:" + ((TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getSafeUri().asString() + "\") -" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getLeft() + "px -" + (TopPanel_BinderImpl_GenBundle_ie9_default_InlineClientBundleGenerator.this.logo()).getTop() + "px  no-repeat")  + ";position:" + ("absolute")  + ";}"));
      }
      public java.lang.String linksDiv(){
        return "GL0P3EKCDJ";
      }
      public java.lang.String logo(){
        return "GL0P3EKCEJ";
      }
      public java.lang.String statusDiv(){
        return "GL0P3EKCFJ";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,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";
  private static com.google.gwt.resources.client.ImageResource logo;
  private static com.google.gwt.resources.client.DataResource logoIe6Data;
  private static org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      logo(), 
      logoIe6Data(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("logo", logo());
        resourceMap.put("logoIe6Data", logoIe6Data());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'logo': return this.@org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenBundle::logo()();
      case 'logoIe6Data': return this.@org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenBundle::logoIe6Data()();
      case 'style': return this.@org.restlet.example.book.restlet.ch09.client.TopPanel_BinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
