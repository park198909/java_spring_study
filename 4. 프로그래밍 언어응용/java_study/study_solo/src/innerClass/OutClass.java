package innerClass;

public class OutClass {
    private int num = 10;
    private static int sNum = 20;
    public InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    class InClass{
        int inNum = 100;

        void inTest(){
            System.out.println("OutClass num = "+num+"(외부클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = "+sNum+"(외부클래스의 정적 변수)");
        }
    }

    public void usingClass(){
        inClass.inTest();
    }
}
