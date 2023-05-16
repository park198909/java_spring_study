package validators;

import models.member.Member;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface DataFormValidator {
    default void dataFormCheck(String str, Member member, RuntimeException e) {

        // 이메일 형식 체크
        if (str.equals(member.getEmail())) {
            String email = str;
            Pattern emallP = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$");
            Matcher matcherE = emallP.matcher(email);
            if (!matcherE.find()) throw e;
        }

        // 전화번호 형식 체크
        if (str.equals(member.getMobile())) {
            String mobile = str;
            Pattern mobileP = Pattern.compile("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$");
            Matcher matcherM = mobileP.matcher(mobile);
            if (!matcherM.find()) throw e;
        }

        if (str.equals(member.getUserPw())) {
            // 비밀번호 형식 체크
            String userPw = str;
            Pattern alphaP = Pattern.compile("[a-zA-z]");
            Pattern numberP = Pattern.compile("[0-9]");
            Pattern spCharP = Pattern.compile("[_!@#$%^&*\\(\\)]");
            Matcher matcher1 = alphaP.matcher(userPw);
            Matcher matcher2 = numberP.matcher(userPw);
            Matcher matcher3 = spCharP.matcher(userPw);
            System.out.println("영문자="+matcher1.find());
            System.out.println("숫자="+matcher2.find());
            System.out.println("특수문자="+matcher3.find());
            if (!matcher1.find() || !matcher2.find() || !matcher3.find() ) {
                throw e;
            }
        }
    }
}
