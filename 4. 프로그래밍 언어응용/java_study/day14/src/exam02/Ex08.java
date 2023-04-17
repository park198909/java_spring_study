package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex08 {
    public static void main(String[] args){
        int[] nums1 = IntStream.iterate(0, n->n+2).limit(10).toArray();
        List<Integer> nums2 = IntStream.iterate(0, n->n+2).limit(10).boxed().toList();
        System.out.println(nums1);
        System.out.println(nums2);
    }
}
