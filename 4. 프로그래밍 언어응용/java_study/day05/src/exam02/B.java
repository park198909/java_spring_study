package exam02;

public class B extends A{
    int numB = 20;

    public B(){
        super();    // A() 컴파일러가 추가해줌
        System.out.println("B 생성자!");
    }
}
