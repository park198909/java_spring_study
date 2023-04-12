package exam02;

public class Ex03 {
    public static void main(String[] args){
        Box<Apple> aBox = new Box<>();      // 객체 생성 시 타입을 Apple로 변경
        aBox.setItem(new Apple());
        aBox.printInfo();
    }
}
