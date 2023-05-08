package commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {
    public static void alertError(HttpServletResponse resp, Exception e) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>",e.getMessage());
    }

    public static void go(HttpServletResponse resp, String url, String target) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        target = target==null ? "self" : target;
        out.printf("<script>%s.location.replace('$s')",target,url);
    }
}
