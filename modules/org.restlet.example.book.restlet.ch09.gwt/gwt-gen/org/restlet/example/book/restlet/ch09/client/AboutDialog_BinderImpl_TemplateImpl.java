package org.restlet.example.book.restlet.ch09.client;

public class AboutDialog_BinderImpl_TemplateImpl implements org.restlet.example.book.restlet.ch09.client.AboutDialog_BinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2,java.lang.String arg3) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<div class='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></div> <div class='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'> This sample application demonstrates the construction of a complex user interface using GWT's built-in widgets. Have a look at the code to see how easy it is to build your own apps! </div> <div class='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg3));
    sb.append("'></span> </div>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
