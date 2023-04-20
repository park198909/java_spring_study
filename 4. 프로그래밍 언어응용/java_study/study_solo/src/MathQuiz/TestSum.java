package MathQuiz;

import java.util.ArrayList;
import java.util.List;

public class TestSum {
    public void isPNo(int a, int b){
        // 소수구하기
        List<Integer> arr = new ArrayList<>();
        int count =0;
        for(int i=Math.min(a,b); i<=Math.max(a,b); i++) {
            for(int j=1; j<=i; j++){
                if(i%j==0){ count++; }
            }
            if(count==2){
                arr.add(i);
            }
            count=0;
        }
        System.out.println("입력받은 수 : "+a+" , "+b);
        System.out.println("소수= "+arr);
    }


    public void isGCD(int a, int b) {
        // 공약수 구하기
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i <= Math.max(a,b); i++){
            if((a%i==0) && (b%i==0)){
                arr.add(i);
            }
        }
        System.out.println("입력받은 수 : "+a+" , "+b);
        System.out.println("공약수= "+arr);
        int result = arr.stream().mapToInt(n->n).max().orElse(0);
        System.out.printf("최대공약수= %d%n",result);
    }

    public void isLCM(int a, int b) {
        // 공배수 구하기
        List<Integer> arr = new ArrayList<>();
        int c = Math.max(a,b);
        while(arr.size()!=10){
            if((c%a==0)&&(c%b==0)) {
                arr.add(c);
            }
            c++;
        }
        System.out.println("입력받은 수 : "+a+" , "+b);
        System.out.println("공배수= "+arr);
        int result = arr.stream().mapToInt(n->n).min().orElse(0);
        System.out.printf("최소공배수= %d%n",result);
    }

    public void gugudan(){
        // 구구단 출력
        System.out.println("========구구단=======");
        for(int i=2; i<10; i++){
            System.out.printf("========%d단=======\n",i);
            for(int j=1; j<10; j++){
                System.out.printf("%d X %d = %d\n",i,j,i*j);
            }
        }
    }

    public void isTan(double deg, double dis) {
        // 삼각함수 구하기
        double hgt;
        double rad = Math.toRadians(deg);

        hgt = dis * (Math.tan(rad));
//        System.out.println(Math.tan(rad));
        System.out.printf("건물의 높이는 %.1f이다.%n",hgt);
    }
}
