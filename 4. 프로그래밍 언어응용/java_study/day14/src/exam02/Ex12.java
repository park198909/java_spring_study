package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex12 {
    public static void main(String[] args){
        String[] names = {"이름2","이름3","이름1","이름4","이름5"};
        Arrays.stream(names).sorted().forEach(System.out::println);
        System.out.println("==================");
        Arrays.stream(names).sorted(String::compareTo).forEach(System.out::println);
        System.out.println("==================");
        Arrays.stream(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("==================");
        Arrays.stream(names).sorted((s1,s2)->s2.compareTo(s1)).forEach(System.out::println);

    }
}

