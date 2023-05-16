package models.member;

import validators.Validator;

public class JoinValidator implements Validator<Member> {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(Member member) {
        // 가입 정보 저장
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();
        String email = member.getEmail();
        String mobile = member.getMobile();

        // 필수항목(userId,userPw,userPwRe,userNm,email,mobile) 체크 - null or 빈칸이면 예외 발생
        requiredCheck(userId, new BadRequestException("아이디를 입력하세요."));
        requiredCheck(userPw, new BadRequestException("비밀번호를 입력하세요."));
        requiredCheck(userPwRe, new BadRequestException("비밀번호를 확인하세요."));
        requiredCheck(userNm, new BadRequestException("회원명을 입력하세요."));
        requiredCheck(email, new BadRequestException("이메일 주소를 입력하세요."));
        requiredCheck(mobile, new BadRequestException("전화번호를 입력하세요."));

        // 비밀번호 일치 체크 - 일치하지 않으면 에러 발생, 비밀번호가 일치하지 않습니다.
        if (!userPw.equals(userPwRe)) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }

        // 아이디(6~16자리), 비밀번호(8자리 이상), 전화번호 자릿수(11자리) 체크 - 자릿수 벗어나면 예외 발생
        dataLengthCheck(userId, 6, 16, new BadRequestException("아이디는 6~16자리 사이로 입력하세요."));
        dataLengthCheck(userPw, 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요."));
        dataLengthCheck(mobile, 11, 11, new BadRequestException("전화번호는 11자리 모두 입력하세요."));

        // 이메일(user01@org.com),전화번호(010********),비밀번호 형식(영문자,숫자,특수문자 1개씩 포함) 체크 - 형식을 벗어나면 예외 발생
        dataFormCheck(email, member, new BadRequestException("이메일 형식을 확인하세요."));
        dataFormCheck(mobile, member, new BadRequestException("-를 제외한 전화번호 11자리를 입력하세요."));
        dataFormCheck(userPw, member, new BadRequestException("비밀번호는 영어 대소문자,숫자,특수문자가 각각 1개 이상 포함되야 합니다."));


    }
}
