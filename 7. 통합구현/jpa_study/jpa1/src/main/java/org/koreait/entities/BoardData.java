package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Data
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

    @ManyToOne  // 외래키 생성
    @JoinColumn(name="user_no")
    @ToString.Exclude
    private Member member;


}
