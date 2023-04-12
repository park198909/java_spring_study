package exam05;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE,METHOD,TYPE_USE,FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value() default "값";
    int max() default 100;
    int main() default 10;
    int[] nums() default {10,20,30};
}
