package validators;

import models.member.JoinValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PasswordFormValidator {
    default void passwordFormCheck(String userPw, JoinValidationException e) {
        Pattern alphaP = Pattern.compile("[a-zA-Z]"); // 대소문자 알파벳 포함 여부
        Pattern numP = Pattern.compile("[0-9]"); // 숫자 포함 여부
        Pattern specialCharsP = Pattern.compile("[_!@#\\$%^&\\*\\(\\)]");
        Pattern koreanP = Pattern.compile("[가-힣]"); // 한글 포함 여부

        Matcher matcher1 = alphaP.matcher(userPw);
        Matcher matcher2 = numP.matcher(userPw);
        Matcher matcher3 = specialCharsP.matcher(userPw);
        Matcher matcher4 = koreanP.matcher(userPw);

        if (!matcher1.find() || !matcher2.find() || !matcher3.find() || matcher4.find()) {
            throw e;
        }
    }
}
