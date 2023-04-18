package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args){
        String[] fruits = {"Apple","Orange","Mango","Melon","banana"};

        Arrays.stream(fruits).skip(3).forEach(System.out::println);
        System.out.println("--------------");

        String[] fruits2 = Arrays.stream(fruits).filter(s -> s.length()>5).toArray(String[]::new);
        System.out.println(Arrays.toString(fruits2));
        System.out.println("--------------");

        String[] fruits3 = Arrays.stream(fruits).map(String::toUpperCase)
                .sorted()
                .filter(s -> s.length()>5)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(fruits3));
        System.out.println("--------------");
    }
}
