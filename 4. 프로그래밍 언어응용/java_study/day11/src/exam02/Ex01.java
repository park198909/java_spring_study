package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> aBox = new Box<>();      // 객체 생성 시 타입을 Apple로 변경
        aBox.setItem(new Apple());      // Apple item = new Apple();
//        abox.setItem(new Grape());      // Grape item = new Grape(); - 타입안정성 확보됨
        aBox.printInfo();

        Apple apple = aBox.getItem();
    }
}
