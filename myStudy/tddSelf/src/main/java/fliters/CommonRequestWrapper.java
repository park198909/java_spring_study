package fliters;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);
        String method = ((HttpServletRequest) request).getMethod().toUpperCase();
        if (method.equals("POST")) {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
