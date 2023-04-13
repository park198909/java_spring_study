package exam02;

import java.util.HashSet;

public class Ex01 {
    public static void main(String[] args) {

        String n1 = new String("이름1");
        String n2 = "이름1";

        System.out.println(n1.equals(n2));
        System.out.println("n1.hashCode() : "+ n1.hashCode());
        System.out.println("n2.hashCode() : "+ n2.hashCode());

        HashSet<String> names = new HashSet<>();

        names.add("이름1");
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        System.out.println(names);
    }
}
