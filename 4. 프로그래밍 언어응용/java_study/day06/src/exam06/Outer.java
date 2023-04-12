package exam06;

public class Outer {
    private int num =10;
    class Inner{
        private int num = 20;
        private static int num2 = 30;
        public void innerMthod(){

            System.out.println(Outer.this.num);
            System.out.println("인스턴스 내부 클래스 Inner");
        }

        public static void staticMethod(){
            System.out.println("정적 메서드!");
        }
    }
}
