package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public abstract class BaseUserEntity extends BaseEntity{

    @CreatedBy
    @Column(updatable = false)
    private Long createBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Long modifiedBy;


}
