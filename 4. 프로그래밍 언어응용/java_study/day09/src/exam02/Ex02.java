package exam02;

public class Ex02 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(20);

        int num3 = num1+num2;   // num1.intValue() + num2.intValue(); // 언박싱 : 객체에서 기본자료형을 꺼낸다.
        System.out.println(num3);

        Integer num4 = num3;    // Integer.valueOf(num3) // 오토박싱 : 자료형을 객체로 집어넣는다.

        int num5 = num4 + 20;   // num4.intValue() + 20;
    }
}
