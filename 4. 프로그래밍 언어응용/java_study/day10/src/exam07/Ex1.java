package exam07;

public class Ex1 {
    public static void main(String[] args) {
        Box<Apple> aBox = new Box<Apple>();
        aBox.setItem(new Apple());
//        aBox.setItem(new Grape());

        Apple apple = aBox.getItem();
        apple.info();
//        Grape grape = aBox.getItem();
//        grape.info();

    }
}
