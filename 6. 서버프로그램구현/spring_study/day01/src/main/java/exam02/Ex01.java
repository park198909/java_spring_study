package exam02;

import exam02.config.AppCtx;
import exam02.config.AppCtx2;
import exam02.models.member.JoinService;
import exam02.models.member.LoginService;
import exam02.models.member.Member;
import exam02.models.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 스프링 컨테이너 생성
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        // 스프링 컨테이너 내 객체 꺼내기 - getBean의 매개변수 : 메서드명.class를 통해 꺼냄
        JoinService service = ctx.getBean("joinService",JoinService.class);
        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        service.join(member);

        Member joinedMember = memberDao.get(member.getUserId());
        System.out.println(joinedMember);

        LoginService loginService = ctx.getBean("loginService", LoginService.class);
        System.out.println(loginService);

        // 스프링 컨테이너 사용종료 - 삭제
        ctx.close();
    }
}
