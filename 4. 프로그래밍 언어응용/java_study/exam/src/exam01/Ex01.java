package exam01;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        // 1000 이하의 소수를 나열하는 프로그램을 작성하시오.
        int cnt=0;
        for(int i=1; i<=1000; i++){
            for(int j=2; j<=i; j++){
                if(i%j==0) cnt++;
            }
            if(cnt==1) System.out.printf("%d, ",i);
            cnt=0;
        }
    }
}
