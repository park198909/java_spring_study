package exam09;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Ex01 {
    public static void main(String[] args) {
        IntStream
        int total = IntStream.rangeClosed(1,100).filter().sum();
        System.out.println(total);

    }
}
