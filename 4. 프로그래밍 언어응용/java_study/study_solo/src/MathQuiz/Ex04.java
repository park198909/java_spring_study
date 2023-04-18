package MathQuiz;

import java.util.ArrayList;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 6;
        int num2 = 9;

        List<Integer> result = new ArrayList<>();

        for(int i=1; i<=100; i++){
            if((i%num1==0)&&(i%num2==0)){
                result.add(i);
            }
        }
        System.out.println(result);
    }
}
