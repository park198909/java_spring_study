package models.member;

import validators.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinValidator implements Validator<Member>  {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();
        String email = member.getEmail();
        String mobile = member.getMobile();

        // 필수 입력 사항(userId,userPw,userPwRe,userNm,email,mobile)체크 - null 또는 빈칸이면 JoinValidationException 발생
        requiredDataCheck(userId, new JoinValidationException("아이디를 입력하세요."));
        requiredDataCheck(userPw, new JoinValidationException("비밀번호를 입력하세요."));
        requiredDataCheck(userPwRe, new JoinValidationException("비밀번호를 확인하세요."));
        requiredDataCheck(userNm, new JoinValidationException("회원명을 입력하세요."));
        requiredDataCheck(email, new JoinValidationException("이메일을 입력하세요."));
        requiredDataCheck(mobile, new JoinValidationException("전화번호를 입력하세요."));

        // 비밀번호 일치 체크 - 비밀번호와 비밀번호 확인이 일치하지 않으면 JoinValidationException 발생
        if (!userPw.equals(userPwRe)) {
            throw new JoinValidationException("비밀번호가 일치하지 않습니다.");
        }

        // 가입 정보 자릿수 체크 - 아이디는 6~16자리, 전화번호는 11자리, 비밀번호는 8자리 이상 : 자릿수 벗어날시 JoinValidationException 발생
        lengthDataCheck(userId, 6, 16, new JoinValidationException("아이디는 6~16자리 이내로 입력하세요."));
        lengthDataCheck(userPw, 8, new JoinValidationException("비밀번호는 8자리 이상 입력하세요."));
        lengthDataCheck(mobile, 11, 11, new JoinValidationException("전화번호는 11자리 모두 입력하세요."));


        // 비밀번호가 영문자,숫자,특수문자를 각 1개 이상 포함하지 않거나 한글을 포함하면 JoinValidationException 발생,
        // 비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야 하면 한글은 불가합니다.
        passwordFormCheck(userPw, new JoinValidationException("비밀번호는  알파벳, 숫자, 특수문자가 1개 이상 포함되어야 하며 한글은 불가합니다."));

        // 이메일형식 체크 - 이메일 형식에 맞지 않으면  JoinValidationException 발생, 이메일 형식에 맞춰 입력해주세요(sample@sample.com)
        Pattern emailP = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$"); // 이메일 형식 맞춤 여부
        Matcher matcher = emailP.matcher(email);
        if (!matcher.find()) {
            throw new JoinValidationException("이메일 형식에 맞춰 입력해주세요(sample@sample.com)");
        }

        // 가입 아이디 중복 체크 - 가입하려는 아이디가 존재하면 JoinValidationException 발생, 이미 존재하는 아이디입니다.
        if (memberDao.get(userId) != null) {
            throw  new JoinValidationException("이미 존재하는 아이디입니다.");
        }

    }
}
