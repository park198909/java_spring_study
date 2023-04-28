<%@ page contentType="text/html; charset=utf-8" %>
<%
    pageContext.setAttribute("num",400);
    request.setAttribute("num",100);
    session.setAttribute("num",200);
    application.setAttribute("num",300);
%>
pageScope : ${pageScope.num}<br>
requestScope : ${requestScope.num}<br>
sessionScope : ${sessionScope.num}<br>
applicationScope : ${applicationScope.num}