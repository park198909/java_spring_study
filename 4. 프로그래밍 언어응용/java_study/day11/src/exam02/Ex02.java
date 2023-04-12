package exam02;

public class Ex02 {
    public static void main(String[] args){
        Box<Grape> gBox = new Box<Grape>();     // 객체 생성 시 타입을 Grape로 변경
        gBox.setItem(new Grape());
        gBox.printInfo();

        Grape grape = gBox.getItem();
    }
}
