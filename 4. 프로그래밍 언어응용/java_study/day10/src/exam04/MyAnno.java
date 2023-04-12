package exam04;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({TYPE, FIELD,METHOD,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String[] value() default {"값1","값2","값3"};

    int min() default 10;   // 항목설정이 없으면 default값 적용
    int max() default 100;  // 항목설정이 없으면 default값 적용
}
