package filters;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class Filter1RequestWrapper extends HttpServletRequestWrapper {

    public Filter1RequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);     // 상위 클래스의 생성자메서드와 일치시킬 필요가 있다.

        // 요청 전 공통기능
        HttpServletRequest req = (HttpServletRequest) request;
        String method = req.getMethod().toUpperCase();
        if(method.equals("POST")){
            try {
                req.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getParameter(String name) {
        String value = name;

        if(value != null) {
            value = value.toUpperCase();
        }
        return value;
    }
}
