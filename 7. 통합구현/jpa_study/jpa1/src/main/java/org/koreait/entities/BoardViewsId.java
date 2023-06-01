package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class BoardViewsId implements Serializable {
    private Long id;
    private String uid;
}
