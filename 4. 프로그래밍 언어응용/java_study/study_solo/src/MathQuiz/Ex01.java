package MathQuiz;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        int n = 256;

        for(int i=1; i<=n; i++) {
            if((n%i)==0) {
                arr.add(i);
            }
        }
        System.out.println(arr);
    }
}
