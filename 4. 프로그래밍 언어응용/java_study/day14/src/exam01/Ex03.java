package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Ex03 {
    public static void main(String[] args) {
        //IntFunction<Int, R>

//        IntFunction<int[]> func1 = n -> new int[n];
        IntFunction<int[]> func1 = int[]::new;
        int[] nums = func1.apply(10);
        System.out.println(Arrays.toString(nums));

//        Supplier<ArrayList<String>> func2 = new ArrayList<String>();
        Supplier<ArrayList<String>> func2 = ()-> new ArrayList<>();
        Supplier<ArrayList<String>> func3 = ArrayList::new;

        ArrayList<String> list = func3.get();

    }
}
