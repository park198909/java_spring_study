package controllers;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class JoinForm {
    @NotBlank
    @Size(min=6, max=16)
    private String userId; // 아이디

    @NotBlank
    @Size(min=8)
    private String userPw; // 비밀번호

    @NotBlank
    private String userPwRe; // 비밀번호 확인

    @NotBlank
    private String userNm; // 사용자명

    @AssertTrue
    private boolean agree; // 약관 동의

    private Address address;

    private List<String> hobby;
}
