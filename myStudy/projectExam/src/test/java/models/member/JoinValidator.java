package models.member;

import validators.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinValidator implements Validator<Member> {
    @Override
    public void check(Member member) {
        if (member == null) {
            throw new BadRequestException("잘못된 접근입니다.");
        }

        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();

        // 필수항목 입력 체크
        requiredCheck(userId,  new BadRequestException("아이디를 입력하세요."));
        requiredCheck(userPw,  new BadRequestException("비밀번호를 입력하세요."));
        requiredCheck(userPwRe,  new BadRequestException("비밀번호를 확인하세요."));
        requiredCheck(userNm,  new BadRequestException("회원며을 입력하세요."));

        // userId 자리수 체크 - 6자리 이상
        strLengthCheck(userId, 6,new BadRequestException("아이디는 6자리 이상 입력하세요."));

        // userId를 알파벳으로만 한정
        Pattern p = Pattern.compile("[^a-zA-Z]");
        Matcher m = p.matcher(userId);
        if(m.find()) {
            throw new BadRequestException("아이디는 알파벳으로만 입력하세요.");
        }

        //  userPw 자리수는 8자리 이상  체크
        strLengthCheck(userPw,8,new BadRequestException("비밀번호는 8자리이상 입력하세요"));

        // userPw가 알파벳 , 숫자, 특수문자를  1개 이상 포함하는지 체크
        Pattern alphaP = Pattern.compile("[^a-zA-Z]"); // 대소문자 알파벳 포함 여부
        Pattern numP = Pattern.compile("[^0-9]"); // 숫자 포함 여부
        Pattern specialCharsP = Pattern.compile("[^_!@#\\$%\\^&\\*\\(\\)]");

        Matcher matcher1 = alphaP.matcher(userPw);
        Matcher matcher2 = numP.matcher(userPw);
        Matcher matcher3 = specialCharsP.matcher(userPw);

        if (!matcher1.find() || !matcher2.find() || !matcher3.find()) {
            throw new BadRequestException("비밀번호는 알파벳, 숫자, 특수문자가 1개 이상 포함되어야 합니다.");
        }
    }
}
