package exam03.config;

import exam03.models.member.JoinService;
import exam03.models.member.MemberDao;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "exam03")
//@ComponentScan(basePackages = "exam03.models", excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes=ManualBean.class))
//@ComponentScan(basePackages = "exam03.models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class, JoinService.class}))
//@ComponentScan(basePackages = "exam03.models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern="exam03.models..*Dao"))
public class AppCtx2 {


}
