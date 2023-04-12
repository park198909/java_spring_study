package exam02;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        Transportation trans = Transportation.SUBWAY;
        System.out.println(trans.getClass().getName());
        System.out.println("name() : "+trans.name());
        System.out.println("ordinal() : "+trans.ordinal());

        String trans2 = "BUS";
        Transportation bus = Enum.valueOf(Transportation.class, trans2);

        Transportation train = Transportation.valueOf("TRAIN");
        System.out.println(train);

        Transportation[] train3 = Transportation.values();
        System.out.println(Arrays.toString(train3));
    }
}
