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
        ts.isPNo(a,b);
        System.out.println();
        ts.isGCD(a,b);
        System.out.println();
        ts.isLCM(a,b);
        System.out.println();
        ts.isTan(a,b);
        System.out.println();
        ts.gugudan();
    }
}
