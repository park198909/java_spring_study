package exam04;

import java.util.*;

public class Ex01 {
    public static void main(String[] args){
        /*
        Comparator<String> comp = new Comparator<>() { // 예전에 쓰던 기능
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
         */

//        HashMap<String, String> members = new HashMap<>();
        TreeMap<String , String > members = new TreeMap<>(Comparator.reverseOrder()); // 요줌 쓰는 방식
        members.put("user04","이름4");
        members.put("user02","이름2");
        members.put("user01","이름1");
        members.put("user03","이름3");

//        members.put("user02","이름1(수정)");    // V 를 수정

        /*
        String user02 = members.get("user02");
        System.out.println(user02);
         */

        for(Map.Entry<String, String> entry : members.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key="+key+", value="+value);
        }
    }
}
