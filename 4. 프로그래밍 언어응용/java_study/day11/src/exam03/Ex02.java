package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Box<Apple> apples = new Box<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        Juicer.make(apples);        // Fruit,Apple,Grape만 가능

        Box<Grape> grapes = new Box<>();
        grapes.add(new Grape());
        grapes.add(new Grape());
        grapes.add(new Grape());

        Juicer.make(grapes);        // Fruit,Apple,Grape만 가능
/*
        Box<String> strings = new Box<>();
        strings.add("장난감1");
        strings.add("장난감2");
        strings.add("장난감3");
        Juicer.make(strings);
*/

    }
}
