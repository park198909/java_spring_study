package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex10 {
    public static void main(String[] args){
        List<String> names = Arrays.asList("이름1","이름2","이름1","이름3","이름4");
        List<String> names2 = names.stream().distinct().toList();
        System.out.println(names2);

        String[] names3 = {"이름1","이름2","이름1","이름3","이름4"};
        String[] names4 = {"이름1","이름2","이름1","이름3","이름4"};

    }
}
