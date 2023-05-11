package exam02.config;

import exam02.models.member.JoinService;
import exam02.models.member.JoinValidator;
import exam02.models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppCtx2.class)
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao());
        return joinValidator;
    }

    @Bean
    public JoinService joinService() {

        return new JoinService(joinValidator(), memberDao());
    }


}
