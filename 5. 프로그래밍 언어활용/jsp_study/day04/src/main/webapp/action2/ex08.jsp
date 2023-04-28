<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="user" class="models.users.User" scope="page" />
<%
    User user2 = (User)pageContext.getAttribute("user");
%>