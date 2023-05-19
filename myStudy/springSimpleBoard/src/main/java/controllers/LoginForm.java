package controllers;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {
    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    private String saveId;
}
