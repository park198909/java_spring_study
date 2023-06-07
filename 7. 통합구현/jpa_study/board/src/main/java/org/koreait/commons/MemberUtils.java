package org.koreait.commons;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.koreait.commons.constants.MemberType;
import org.koreait.entities.Member;
import org.koreait.models.member.MemberInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/*
* 편의 기능 구현
* */
@Component
@RequiredArgsConstructor
public class MemberUtils {

    private final HttpSession session;

    public boolean isLogin() { // 로그인 여부 체크 편의기능

        return getMember() != null;
    }

    public boolean isAdmin() {  // Admin 계정 체크 편의기능

        return isLogin() && getMember().getType() == MemberType.ADMIN;
    }

    public MemberInfo getMember() { // MemberInfo 조회 편의기능
        MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");

        return memberInfo;
    }

    public Member getEntity() { // 회원 엔티티 조회 편의기능
        if (isLogin()) {
            Member member = new ModelMapper().map(getMember(), Member.class);
            return member;
        }
        return null;
    }
}
