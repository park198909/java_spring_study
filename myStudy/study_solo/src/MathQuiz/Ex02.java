package MathQuiz;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(100)+1;
        int b = rand.nextInt(100)+1;
        while(a==b){ b = rand.nextInt(100)+1; }

        System.out.println(a+","+b);
        uc(a,b);

    }

    public static void uc(int a, int b){
        int c = Math.max(a,b);
        int d = Math.min(a,b);
        while(d!=0){
           int e = c%d;
           c = d;
           d = e;
        }
        System.out.println(c);
        System.out.println((a*b)/c);
    }
}
