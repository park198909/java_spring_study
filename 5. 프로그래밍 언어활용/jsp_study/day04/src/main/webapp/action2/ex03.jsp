<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.*"%>
<h1>ex01.jsp - 전</h1>

<%
    String param1 = URLEncoder.encode("값1","UTF-8");
    String param2 = URLEncoder.encode("값2","UTF-8");
%>

<jsp:include page="include.jsp" >
    <jsp:param name="key1" value="<%=param1%>" />
    <jsp:param name="key2" value="<%=param1%>" />
</jsp:include>
<h1>ex01.jsp - 후</h1>