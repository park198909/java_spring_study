package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "member")
    private List<BoardData> boardDatas = new ArrayList<>();
}
