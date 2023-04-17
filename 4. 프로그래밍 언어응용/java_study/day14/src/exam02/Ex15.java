package exam02;

import java.util.Arrays;

public class Ex15 {
    public static void main(String[] args){
        String[] strs = {"aa","bb","cc","dd"};
        String[] strs2 = (String[])Arrays.stream(strs).map(String::toUpperCase).toArray();

        System.out.println(Arrays.toString(strs2));
    }
}
