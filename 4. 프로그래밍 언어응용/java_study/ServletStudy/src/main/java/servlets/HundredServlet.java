package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class HundredServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int total = 0;
        for(int i=0; i<101; i++)  total += i;
        // 브라우저에 한글을 띄우기 위한 응답헤더의 contentType설정
        resp.setContentType("text/html; charset=utf-8");
        // 브라우저에 결과를 띄우는 객체생성
        PrintWriter out = resp.getWriter();
        // 화면에 결과 출력
        out.println("<html>");
        out.println("<body>");
        out.printf("1부터 100까지의 합은 %d%n",total);
        out.println("</body>");
        out.println("</html>");
    }
}
