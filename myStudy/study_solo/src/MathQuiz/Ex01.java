package MathQuiz;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(50)+1;
        int b = rand.nextInt(50)+1;
        while(a==b){
            b = rand.nextInt(50)+1;
        }

        TestSum ts = new TestSum();

        System.out.println();
        ts.isPNo(a,b);      // 소수
        System.out.println();
        ts.isGCD(a,b);      // 공약수
        System.out.println();
        ts.isLCM(a,b);      // 공배수
        System.out.println();
        ts.isTan(a,b);      // 탄젠트 함수
        System.out.println();
        ts.gugudan();       // 구구단
    }
}
