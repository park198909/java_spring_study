package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.constants.MemberType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        indexes = { @Index(name="idx_member_usernm", columnList = "userNm") })   // 테이블명=user 로 생성
public class Member {
    @Id
//    @TableGenerator(name = "user_seq")
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNo;    // 회원번호
    @Column(length = 40 ,nullable=false ,unique=true)
    private String userId;  // 아이디
    @Column(length = 65 ,nullable=false ,name="userPass")    // 실제 테이블의 필드명 userPass
    private String userPw;  // 비밀번호
    @Column(length = 40 ,nullable=false)
    private String userNm;  // 회원명

//    @Lob    // String - CLOB
    @Transient                      // 엔티티 내부에서만 사용되는 항목 - 테이블에 반영 X
    private String introduction;    // 자기소개

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MemberType memberType;  // 고객,관리자 구분

    @CreationTimestamp              // insert 시 자동으로 현재날짜,시간 입력
    @Column(updatable = false)      // update 불가
    private LocalDateTime regDt;    // 회원가입 일시

    @UpdateTimestamp                // update 시 자동으로 현재날짜,시간 입력
    @Column(insertable = false)     // insert 불가
    private LocalDateTime modDt;    // 회원정보수정 일시
    
    @Temporal(TemporalType.DATE)   // 날짜 + 시간
    private Date birthDt;

    @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE) // 지연로딩 - global 전략, EAGER 는 필요할 때만
    private List<BoardData> boardDatas = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id")
    @ToString.Exclude
    private Address address;
}
