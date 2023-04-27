package models.member;

public class JoinService {
    public void join(Member member) {
        // 필수항목 체크
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        if(userId == null || userId.isBlank()) {
            throw new JoinValidationException("아이디를 입력하세요");
        }
        if(userPw == null || userPw.isBlank()) {
            throw new JoinValidationException("비밀번호를 입력하세요");
        }
    }
}
