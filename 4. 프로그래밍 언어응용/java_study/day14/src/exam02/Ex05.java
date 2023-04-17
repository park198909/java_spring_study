package exam02;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex05 {
    public static void main(String[] args){
        String[] fruits = {"apple","orange","mango","banana","melon"};

        // Stream 중간연산 -> 반환값이 Stream이므로 메서드체인으로 이어갈수 있다.
        Stream<Integer> stm = Arrays.stream(fruits).map(s->s.length()).map(n->n*n).filter(n->n >= 30);

        // Stream 종결연산 -> 반환값이 Stream이 아니므로 메서드체인이 끝난다.
        stm.forEach(System.out::println);

    }
}
