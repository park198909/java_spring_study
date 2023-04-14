package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1","이름2","이름3","이름4");

        String max = Collections.max(names, Comparator.reverseOrder());
        String min = Collections.min(names, Comparator.reverseOrder());

        System.out.println("max= "+max+", min= "+min);
    }
}
