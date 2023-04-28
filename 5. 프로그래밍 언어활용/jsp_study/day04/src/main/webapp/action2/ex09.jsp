<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="user" class="models.users.User" />

<%-- <jsp:setProperty name="user" property="*" /> --%>

<jsp:setProperty name="user" property="userId" param="memId" />
<jsp:setProperty name="user" property="userPw" />

userId : <jsp:getProperty name="user" property="userId" /><br>
userPw : <jsp:getProperty name="user" property="userPw" />
