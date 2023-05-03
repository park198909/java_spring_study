package tests;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class JoinService {

    void join(Map<String, String> memberlist, HttpServletRequest request) {
        String userId = request.getParameter("userId");
        for(Map.Entry<String,String> key : memberlist.entrySet()) {
            if(userId.equals(key.getKey()) || userId == null || userId.isBlank()) {
                throw new JoinValidationExceprtion("아이디가 중복이거나 올바르지 않습니다.");
            }
        }
    }
}
