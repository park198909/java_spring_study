package exam02;

import java.util.Random;

public class Ex06 {
    public static void main(String[] args){
        Random rand = new Random();
        rand.ints().limit(10).forEach(n->System.out.println(n));
        System.out.println("-------------------------");
        rand.ints().limit(10).forEach(System.out::println);

    }
}
