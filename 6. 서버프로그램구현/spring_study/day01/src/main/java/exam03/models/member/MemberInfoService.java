package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class MemberInfoService {

    @Autowired
    private MemberDao memberDao;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

    //@Autowired(required = false) - formatter 를 호출하지 않는다.
    @Autowired
    //@Qualifier("mdao1")
    public void setFormatter(@Nullable DateTimeFormatter formatter) { // formatter 를 호출하여 null 을 입력한다.
        this.formatter = formatter;
    }

    public void print(String userId) {
        Member member = memberDao.get(userId);
        System.out.println(member);
        if (formatter != null) {
            System.out.println(formatter.format(member.getRegDt()));
        }
    }
}
