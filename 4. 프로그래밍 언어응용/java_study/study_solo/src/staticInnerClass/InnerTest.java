package staticInnerClass;

public class InnerTest {
    public static void main(String[] args) {
        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        System.out.println("정적 내부클래스 일반 메서드 호출");
        sInClass.inTest();
        System.out.println("정적 내부클래스 정적 메서드 호출");
        OutClass.InStaticClass.sTest();
    }
}
