<%@ tag body-content="empty" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="size" type="java.lang.Integer" required="true" %>
<%@ attribute name="color" %>
<%-- 태그에 속성을 추가하면 -> 자바 지역변수, EL식 변수 --%>
<%
    //out.write("size=" + size + ", color=" + color);
    //System.out.println(size instanceof Integer);
    //System.out.println(color instanceof String);
%>
<%-- Size = ${size}, color = ${color}<br> --%>
<%
    /*
    for(int i=0; i<size; i++) {
        out.write("-");
    }
    */
%>
<div style="color: ${color}" >
    <c:forEach begin="1" end="${size}">-</c:forEach>
</div>