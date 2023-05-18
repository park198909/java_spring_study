package models.member;

import controllers.Address;
import lombok.Data;

import java.util.List;

@Data
public class JoinForm {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private boolean agree;

    private Address address;

    private List<String> hobby;
}
