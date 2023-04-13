package exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex02 {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
    }

    public static void printData(List<String> names){
        System.out.println(names);
    }
}
