package models.emp;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Data
public class Emp {
    private Long EMPNO;

    private String ENAME;

    //@NonNull
    private String JOB;
}
