package staticInnerClass;

public class OutClass {
    private int num = 10; // 외부 클래스 private 변수
    private static int sNum = 20; // 외부 클래스 정적 변수

    private InStaticClass inStaticClass; // 내부 클래스 자료형 변수를 먼저 선언

    static class InStaticClass { // 정적 내부 클래스
        int inNum = 100; // 정적 내부 클래스의 인스턴스 변수
        static int sInNum = 200; // 정적 내부 클래스의 정적 변수

        // 정적 내부 클래스의 일반 메서드
        void inTest() {
            //num += 10; // 외부 클래스의 인스턴스 변수는 사용할 수 없다.
            System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
        }

        // 정적 내부 클래스의 정적 메서드
        static void sTest() {
            // 외부 클래스와 내부 클래스의 인스턴스 변수는 사용할 수 없다.
            //num += 10;
            //inNum += 10
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
        }
    }
}
