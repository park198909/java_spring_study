package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03 {
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,1,2,3,4,5,6);
        System.out.println(nums);

//        List<Integer> checkedNums = Collections.checkedList(nums, Integer.class);
//        System.out.println(checkedNums);

        List<String> chars = Arrays.asList("1","2","3","4");

        Collections.fill(chars,"*");
        System.out.println(chars);



    }
}
