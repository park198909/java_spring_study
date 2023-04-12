package AnonymousInnerClass;

public class Outer {
    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i) {
        int num = 100; // 지역변수

        return new Runnable(){ // 익명 내부 클래스
            @Override
            public void run() {
                // 지역변수는 상수화 되므로 변경 불가
                //num = 200;
                //i = 10;

                System.out.println(i);
                System.out.println(num);
            }
        };
    }
    Runnable runner = new Runnable() { // 익명 내부 클래스를 변수에 대입
        @Override
        public void run() {
            System.out.println("Runnable의 구현된 익명 클래스 변수");
        }
    }; // 클래스 끝에 ;를 씀
}
