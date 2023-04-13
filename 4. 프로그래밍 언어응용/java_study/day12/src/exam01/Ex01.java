package exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedMap;

public class Ex01 {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> names2 = new LinkedList<>(names);
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
        System.out.println(names);
        /*
        for(int i=names.size()-1; i>=0; i--){
            names.remove(i);
        }
         */
        /*
        for(int i=0; i < names.size(); i++){
            String name = names.get(i);
            System.out.println(name);
        }
         */

        for(String name : names){
            System.out.println(name);
        }

        names.stream().forEach(System.out::println);
    }
}
