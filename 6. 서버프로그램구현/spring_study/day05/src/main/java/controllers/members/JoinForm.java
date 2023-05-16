package controllers.members;

import lombok.Data;

import java.util.List;

@Data
public class JoinForm {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private List<String> hobby;
    private boolean agree;
}
