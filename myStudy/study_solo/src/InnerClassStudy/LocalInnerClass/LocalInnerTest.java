package InnerClassStudy.LocalInnerClass;

public class LocalInnerTest {
    public static void main(String[] args){
        Outer outer = new Outer();
//        outer.getRunnable(10).run();
        Runnable runner = outer.getRunnable(10);
        runner.run();
    }
}
