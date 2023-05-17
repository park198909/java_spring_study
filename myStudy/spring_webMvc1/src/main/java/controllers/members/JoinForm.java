package controllers.members;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinForm {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private boolean agree;
}
