package MathQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GCD_LCM_Test {
    public static void main(String[] args) {
        // 공약수, 공배수, 소수
        // 소수 = 1과 나로만 나누어지는 수
        int num = 0;
        List<Integer> sosu = new ArrayList<>();
        for(int i=2; i<=10; i++) {
            for(int j=1; j<=i; j++) {
                if(i%j==0) {
                    num++;
                }
            }
            if(num==2) {
                System.out.printf("%d는 소수이다.\n",i);
            }
            num=0;
        }

        // 공약수와 최대공약수
        int n1 = 18;
        int n2 = 12;
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=Math.max(n1,n2); i++){
              if((n1%i == 0) && (n2%i==0)){
                  arr.add(i);
              }
        }
        System.out.println(n1+","+n2+"의 "+"공약수 = "+arr);        // 공약수
        int result = arr.stream().mapToInt(n->n).max().orElse(0);
        System.out.println(n1+","+n2+"의 "+"최대공약수 = "+result);     // 최대공약수


        // 공배수와 최소공배수
        int num1 = 18;
        int num2 = 12;
        int num3 = Math.max(num1,num2);
        List<Integer> arr2 = new ArrayList<>();
        while(arr2.size()!=10) {
            if ((num3 % num1 == 0) && (num3 % num2 == 0)) {
                arr2.add(num3);
            }
            num3++;
        }
        System.out.println(num1+","+num2+"의 "+"공배수 = "+arr2);        // 공배수
        int result2 = arr2.stream().mapToInt(n->n).min().orElse(0);
        System.out.println(num1+","+num2+"의 "+"최소공배수 = "+result2);  // 최소공배수
    }
}
