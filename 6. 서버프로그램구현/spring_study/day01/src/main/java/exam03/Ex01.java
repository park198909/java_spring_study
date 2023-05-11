package exam03;

import exam03.config.*;
import exam03.models.member.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService service = ctx.getBean("joinService", JoinService.class);
        MemberInfoService infoService = ctx.getBean("memberInfoService", MemberInfoService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());
        service.join(member);

        infoService.print(member.getUserId());


        ctx.close();
    }
}
