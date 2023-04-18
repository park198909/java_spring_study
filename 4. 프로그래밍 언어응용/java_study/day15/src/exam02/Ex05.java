package exam02;

import java.util.Arrays;
import java.util.Random;

public class Ex05 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = rand.ints().limit(5).toArray();
        System.out.println(Arrays.toString(nums));

        int max = Arrays.stream(nums).reduce(Integer.MIN_VALUE, (a,b)->{
            int _max = a;       // a=MIN_VALUE, 1순회 후에는 a,b중 큰 값이 저장
            if(a>b) {           // a가 b보다 크면
                _max = a;       // _max는 a
            }else {             // a가 b보다 작으면
                _max = b;       // _max는 b
            }
            return _max;
        });
        System.out.println("max="+max);
        int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (a,b)->a<b?a:b);
        System.out.println("min="+min);

    }
}
