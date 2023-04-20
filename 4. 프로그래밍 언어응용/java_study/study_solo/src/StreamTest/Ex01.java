package StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(50)+1;
        int b = rand.nextInt(50)+1;
        while(a==b){
            b = rand.nextInt(50)+1;
        }
        // 공약수
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i <= Math.max(a,b); i++){
            if((a%i==0) && (b%i==0)){
                arr.add(i);
            }
        }
        System.out.println(a+" , "+b);
        System.out.println(arr);
        // 공배수
        
    }
}
