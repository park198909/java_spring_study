package controllers;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");                // content-type설정
        PrintWriter out = resp.getWriter();                             // resp에 정보전달객체 생성
        out.print("<form method='post' action='board'>");               // 정보전달
        out.print("제목 : <input type='text' name='subject'><br>");      // 정보전달
        out.print("내용 : <textarea name='content'></textarea><br>");    // 정보전달
        out.print("<button type='submit'>작성하기</button>");             // 정보전달
        out.print("</form>");
        System.out.println("doGet() - board");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");                          // req에 언어종류 설정

        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        System.out.printf("제목 : %s, 내용 : %s%n",subject,content);
    }
}
