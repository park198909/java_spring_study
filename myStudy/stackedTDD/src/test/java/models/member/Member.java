package models.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private String email;
    private String mobile;
    private LocalDateTime regDt;
}
