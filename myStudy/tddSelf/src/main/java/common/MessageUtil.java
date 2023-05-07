package common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {
    public static void alertError(HttpServletResponse resp, RuntimeException e) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>",e.getMessage());
    }

    public static void go(String url, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.sendRedirect(url);
    }
}
