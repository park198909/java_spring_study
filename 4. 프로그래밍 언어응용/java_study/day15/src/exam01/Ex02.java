package exam01;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args){
        String[] fruits = {"Apple","Orange","Mango","Melon","banana"};

        String[] fruits2 = Arrays.stream(fruits).peek(System.out::println)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(fruits2));
    }
}
