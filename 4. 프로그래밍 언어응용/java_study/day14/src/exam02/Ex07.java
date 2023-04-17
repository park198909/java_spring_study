package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex07 {
    public static void main(String[] args){
        int[] nums = IntStream.generate(()->1).limit(10).toArray();
        System.out.println(Arrays.toString(nums));
    }
}
