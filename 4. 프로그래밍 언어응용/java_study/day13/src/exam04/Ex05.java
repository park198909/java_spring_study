package exam04;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Ex05 {
    public static void main(String[] args){
        // 숫자, 10이상, 100이하 인지 체크
        int num =20;

        IntPredicate func1 = n -> n>=10;
        IntPredicate func2 = n -> n<=100;

        IntPredicate func3 = func1.and(func2);
        boolean result = func3.test(num);
        System.out.println("result : "+result);
        boolean result2 = func3.test(101);
        System.out.println("result2 : "+result2);

        IntPredicate func4 = func1.negate();
        boolean result3 = func4.test(num);
        System.out.println("result3 : "+result3);

    }
}
