package exam02;

import java.util.Arrays;
import java.util.Optional;

public class Ex02 {
    public static void main(String[] args) {
        String[] fruits = {"AAA","Apple","Orange","Mango","Melon","banana"};

        boolean allMatch = Arrays.stream(fruits).allMatch(s->s.length()>=5);    // 다 맞으면 true
        System.out.println(allMatch);
        boolean anyMatch = Arrays.stream(fruits).anyMatch(s->s.length()>=6);    // 하나만 맞아도 true
        System.out.println(anyMatch);
        boolean noneMatch = Arrays.stream(fruits).noneMatch(s->s.length()>=9);    // 다 틀리면 true
        System.out.println(noneMatch);
    }
}
