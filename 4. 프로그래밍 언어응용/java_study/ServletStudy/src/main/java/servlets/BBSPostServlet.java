package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bbs-post")
public class BBSPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글깨짐 방지 인코딩설정
        req.setCharacterEncoding("UTF-8");

        // 브라우저 화면에서 입력받은 값들을 name으로 찾아서 가져오기
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String[] fruits = req.getParameterValues("fruits");

        // 한글깨짐 방지 응답헤더 contentType설정
        resp.setContentType("text/html; charset=utf-8");
        // 브라우저 출력 객체 생성
        PrintWriter out = resp.getWriter();
        // 화면 출력 구현
        out.println("<html>");
        out.println("<head>");
        out.println("<title>게시판 글쓰기 - 결과화면</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("이름 : %s<br>",name);
        out.printf("제목 : %s<br>",title);
        out.println("------------------<br>");
        out.printf("<pre>%s</pre><br>",content);
        out.println("------------------<br>");
        out.printf("선택한 과일 : %s, %s, %s, %s<br>",fruits[0],fruits[1],fruits[2],fruits[3]);
        out.println("저장되었습니다.");
        out.println("</body>");
        out.println("</html>");
    }
}
