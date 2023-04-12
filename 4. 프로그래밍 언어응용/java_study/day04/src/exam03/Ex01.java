package exam03;

import exam02.A;

public class Ex01 {
    public static void main(String[] args) {
        A a = new A();
        a.num = 20;
        System.out.println(a.num);

//        a.num2 = 10;
        B b = new B();
        b.printNum4();
    }
}
