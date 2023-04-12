package exam02;

public class C extends B{
    int numC=30;

    public C(){
        super();    // B(); 컴파일러가 추가해줌
        System.out.println("C 생성자!");
    }
}
