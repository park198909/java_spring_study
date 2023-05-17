package models.member;

import validators.Validator;

import java.time.LocalDateTime;

public class JoinValidator implements Validator<Member> {
    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();
        String email = member.getEmail();
        String mobile = member.getMobile();
        
        // 필수항목 체크(userId, userPw, userPwRe, userNm, email, mobile,) - null 이면 예외 발생
        requiredFieldCheck(userId,new BadRequestException("아이디를 입력하세요."));
        requiredFieldCheck(userPw,new BadRequestException("비밀번호를 입력하세요."));
        requiredFieldCheck(userPwRe,new BadRequestException("비밀빈호를 확인하세요."));
        requiredFieldCheck(userNm,new BadRequestException("회원명을 입력하세요."));
        requiredFieldCheck(email,new BadRequestException("이메일을 입력하세요."));
        requiredFieldCheck(mobile,new BadRequestException("전화번호를 입력하세요."));

        // 비밀번호 일치 확인 - 비밀번호 다르면 예외 발생, 비밀번호 다르면 예외 발생, 비밀번호가 일치하지 않습니다
        if (!userPw.equals(userPwRe)) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다");
        }

        // 자릿수 일치 테스트 - 아이디(6~16자리), 비밀번호(8자리 이상), 전화번호(11자리) : 자릿수 안맞으면 예외발생
        strLengthCheck(userId, 6, 16, new BadRequestException("아이디는 6~16자리 이내로 작성하세요."));
        strLengthCheck(userPw, 8,  new BadRequestException("비밀번호는 8자리 이상 입력하세요."));
        strLengthCheck(mobile, 11, 11, new BadRequestException("전화번호는 11자리 모두 입력하세요."));

    }
}
