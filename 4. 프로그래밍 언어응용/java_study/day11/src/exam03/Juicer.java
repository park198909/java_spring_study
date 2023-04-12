package exam03;

import java.util.List;

public class Juicer {

    public static void make(Box<? extends Fruit> fruits){ //와일드카드-> ?는 메서드가 호출시 결정됨, Fruit포함 하위클래스로 제한
        List<?> items = fruits.getItems();
        System.out.println(items);
    }

    public static <T extends Fruit> void make3(Box<T> fruits,Box<T> fruits2){
        // 지네릭 메서드를 이용하여 와일드카드를 짥게 표현이 가능하다.
        List<?> items = fruits.getItems();
        System.out.println(items);
    }

    public static  void make2(Box<? super Apple> fruits){ //와일드카드-> ?는 메서드가 호출시 결정됨, Apple포함 상위클래스로 제한
        List<?> items = fruits.getItems();
        System.out.println(items);
    }
    /*
    public static void make(Box<Apple> apples){
        List<Apple> items = apples.getItems();
        System.out.println(items);
    }

    public static void make(Box<Grape> grapes){
        List<Grape> items = grapes.getItems();
        System.out.println(items);
    }
    */

}
