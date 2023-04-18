package MathQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ex05 {
    public static void main(String[] args) {
        // 구구단
        /*
        for(int i=2; i<10; i++){
            System.out.printf("========%d단=======\n",i);
            for(int j=1; j<10; j++){
                System.out.printf("%d X %d = %d\n",i,j,i*j);
            }
        }*/

        // 공약수, 공배수, 소수
        // 소수 = 1과 나로만 나누어지는 수
        /*
        int num = 0;
        List<Integer> sosu = new ArrayList<>();
        for(int i=2; i<=100; i++) {
            for(int j=1; j<=i; j++) {
                if(i%j==0) {
                    num++;
                }
            }
            if(num==2) {
                System.out.printf("%d는 소수이다.\n",i);
            }
            num=0;
        }*/

        // 공약수와 최대공약수
        int n1 = 18;
        int n2 = 12;
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=Math.max(n1,n2); i++){
              if((n1%i == 0) && (n2%i==0)){
                  arr.add(i);
              }
        }
        System.out.println(arr);    // 공약수
        int a = arr.stream().mapToInt(n->n).max().orElse(0);
        System.out.println(a);      // 최대공약수


        // 공배수

    }
}
