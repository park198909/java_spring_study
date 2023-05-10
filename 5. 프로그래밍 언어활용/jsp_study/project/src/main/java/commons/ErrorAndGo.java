package commons;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorAndGo {
    public static void go(String url, String target, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        target = target==null ? "self" : target;

        out.printf("<script>%s.location.replace('%s')</script>",target,url);
    }

    public static void errorMsg(HttpServletResponse resp, Exception e) throws IOException {

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s')</script>",e.getMessage());
    }

}
