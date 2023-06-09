package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.koreait.commons.constants.MemberType;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue
    private Long userNo;

    @Column(nullable = false, length = 40, unique = true)
    private String userId;

    @Column(nullable = false, length = 65)
    private String userPw;

    @Column(nullable = false, length = 40)
    private String userNm;

    @Column(length = 100)
    private String email;

    @Column(length = 11)
    private String mobile;

    @Column(length = 10)
    private String zipcode;
    @Column(length = 100)
    private String address;
    @Column(length = 100)
    private String addressSub;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MemberType type;    // USER : 사용자 , ADMIN : 관리자

    @OneToMany(mappedBy = "member")
    private List<BoardData> boardDatas = new ArrayList<>();

}
