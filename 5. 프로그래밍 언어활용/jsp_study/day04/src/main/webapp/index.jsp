<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, java.time.*" %>
<%@ page info="서블릿 JSP 연습" %>
{"key1" : "value1", "key2" : "value2"}

<%
    List<String> names = Arrays.asList("이름1","이름2","이름3");
    System.out.println(names);

    LocalDateTime date= LocalDateTime.now();
    out.write(date.toString());

    String info = getServletInfo();
    out.write("<br>");
    out.write(info);
    out.write("<br>");
%>