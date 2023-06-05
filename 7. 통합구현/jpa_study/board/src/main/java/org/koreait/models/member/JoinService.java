package org.koreait.models.member;

import lombok.RequiredArgsConstructor;
import org.koreait.commons.constants.MemberType;
import org.koreait.controllers.member.JoinForm;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinForm joinForm) {
        // 동일 게터를 매칭하여 member 자동 입력, 회원가입은 모두 USER 로 설정
        Member member = new ModelMapper().map(joinForm, Member.class);
        member.setType(MemberType.USER);
        // BCrypt
        String hash = passwordEncoder.encode(joinForm.getUserPw());
        member.setUserPw(hash);

        repository.saveAndFlush(member);
    }
}
