package controllers.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinForm {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private String[] hobby;
    private boolean agree;
    private Address address;
    private LocalDateTime regDt;
}
