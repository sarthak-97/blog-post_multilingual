<%@ page session="true" %>
<%
// your default language.
String default_language = "fr";
 
if( "eng".equals( request.getParameter( "lang" ) ) || "fr".equals( request.getParameter( "lang" ) ) ) {
    // if lang is equal to fr (french) or equal to en (english)...select the language
    // and redirect 
    session.putValue( "lang", request.getParameter( "lang" ) );
    // now we need to do a redirect
    // note: I am redirecting to project context.
    response.sendRedirect( request.getContextPath() );
} else {
    // use the default language in this case.
    session.putValue( "lang", default_language );
} //-- ends else block
%>