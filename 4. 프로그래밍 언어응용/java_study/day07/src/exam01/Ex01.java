package exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("aa.txt");
            // throw new FileNotFoundException(...);

            // 파일읽기 작업을 했다.

            System.out.println("자원해제 완료!");
            return; // 함수 종료
        } catch (IOException e) { // FileNotFoundException e = new FileNotFoundException(...);
            e.printStackTrace();
//            System.out.println("예외 처리!!");
        } finally { // 예외가 발생하든 않하든 발생하는 코드
            try {
            fis.close();  // 자원 해제
            } catch (IOException | NullPointerException e2){
                e2.printStackTrace();
            }
            System.out.println("예외가 발생하든 않하든 항상 실행되는 코드");
        }
        System.out.println("매우 중요한 코드!!!");
    }
}
