package models.member;

public class JoinService {
    public void join(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String userPwRe = member.getUserPwRe();
        String userNm = member.getUserNm();
        
        // 필수항목 체크 - userId,userPw가 null 또는 빈칸 체크
        if (userId==null || userId.isBlank()) {
            throw new BadRequestException("아이디를 입력하세요");
        }
        if (userPw==null || userPw.isBlank()) {
            throw new BadRequestException("비밀번호를 입력하세요");
        }
    }
}
