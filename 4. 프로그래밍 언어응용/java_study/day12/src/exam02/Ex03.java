package exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex03 {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        ListIterator<String> iterator = names.listIterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
        System.out.println("-------------------------------");
        while(iterator.hasPrevious()){
            String name = iterator.previous();
            System.out.println(name);
        }
    }
}
