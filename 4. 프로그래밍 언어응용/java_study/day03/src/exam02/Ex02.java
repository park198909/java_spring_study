package exam02;

public class Ex02 {
    public static void main(String[] args) {
       int re =  add(10,20);                // 함수가 호출되면 공간이 할당되고 연산 종료 시 공간이 사라진다.
       System.out.println(re);
    }

    static int add(int num1, int num2){     // 함수를 정의한 코드 -> num1=10, num2=20;
        int result = num1 + num2;
        return result;
    }
    static int add(int num1, int num2,int num3){     // 함수를 정의한 코드 -> num1=10, num2=20;
        int result = num1 + num2;
        return result;
    }
}
