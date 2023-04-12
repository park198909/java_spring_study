package exam03;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        Box<Fruit> grapes = new Box<>();
//      Fruit f = new Grape();
        grapes.add(new Grape());
        grapes.add(new Grape());
        grapes.add(new Grape());

        Juicer.make2(grapes);        // Fruit,Apple,Object만 가능
    }
}
