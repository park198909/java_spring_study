package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1","이름2","이름3","이름4");
        Collections.shuffle(names);
        System.out.println(names);
//        Collections.swap(names,0,3);
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
//        Collections.rotate(names,2);
//        System.out.println(names);
//        Collections.rotate(names,2);
//        System.out.println(names);

    }
}
