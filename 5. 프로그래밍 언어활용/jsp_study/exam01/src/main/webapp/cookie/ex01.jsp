<%@ page contentType="text/html; charset=utf-8" %>
<%
    Cookie cookie = new Cookie("key1", "value1");
    cookie.setPath(request.getContextPath());
    cookie.setHttpOnly(true);
    cookie.setMaxAge(60*60*24*365);
    response.addCookie(cookie);
%>