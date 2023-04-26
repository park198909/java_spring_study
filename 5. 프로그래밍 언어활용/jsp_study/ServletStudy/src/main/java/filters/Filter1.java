package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1 - 전");

        // 요청 메서드가 post일때 body인코딩을 UTF-8로 설정
//        HttpServletRequest req = (HttpServletRequest) request;
//        String method = req.getMethod();
//        if(method.toUpperCase().equals("POST")) {
//            req.setCharacterEncoding("UTF-8");
//        }



        // 요청 전 공통 처리
        filterChain.doFilter(new Filter1RequestWrapper(request), new Filter1ResponseWrapper(response));
        // 응답 후 공통 처리
//        System.out.println("Filter1 - 후");
    }
}
