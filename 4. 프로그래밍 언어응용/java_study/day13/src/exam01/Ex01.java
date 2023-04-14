package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args){
//        List<String> names = Arrays.asList("이름1","이름2","이름3","이름4","이름5");
        int[][] nums = {{1,2,3},{4,5,6}};
        int[][] nums2 = {{1,2,3},{4,5,6}};
//        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.deepToString(nums));

        boolean same = Arrays.deepEquals(nums,nums2);
        System.out.println(same);
    }
}
