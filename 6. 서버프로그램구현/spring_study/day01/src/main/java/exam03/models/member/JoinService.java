package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoinService {

    @Autowired
    private JoinValidator validator;


    @Autowired
    private Optional<MemberDao> opt;


    public void join(Member member) {
        MemberDao memberDao = opt.get(); // Optional클래스의 get() 으로 null처리 가능한 객체로 반환됨
        validator.check(member);

        // 가입 처리
        memberDao.insert(member);

    }
}