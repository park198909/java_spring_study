package AnonymousInnerClass;

public class AnonymousInnerTest {
    public static void main(String[] args){
        Outer outer = new Outer();
        Runnable runnable = outer.getRunnable(10);
        runnable.run();
        outer.runner.run();

    }
}
