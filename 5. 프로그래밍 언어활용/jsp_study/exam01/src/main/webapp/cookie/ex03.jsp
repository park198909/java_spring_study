<%@ page contentType="text/html; charset=utf-8" %>
<%
    Cookie cookie = new Cookie("key1", "value1");
    cookie.setPath(request.getContextPath());
    cookie.setMaxAge(0);
    response.addCookie(cookie);
%>