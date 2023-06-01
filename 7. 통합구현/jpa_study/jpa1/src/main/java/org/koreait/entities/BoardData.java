package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class BoardData extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length=40)
    private String poster;

    @ManyToOne(fetch=FetchType.LAZY)  // 외래키 생성 : One 쪽 엔티티명_기본키명, 지연로딩 - global 전략, EAGER 는 필요할 때만
    @JoinColumn(name="user_no")
    @ToString.Exclude
    private Member member;
}
