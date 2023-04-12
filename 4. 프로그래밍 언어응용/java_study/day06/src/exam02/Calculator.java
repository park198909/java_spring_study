package exam02;

public interface Calculator {
    int num = 10;                   // public static final을 컴파일러가 붙임
    int add(int num1,int num2);     // public abstract를 컴파일러가 붙임
    int minus(int num1,int num2);

    public static void staticMethod(){

    }
}
