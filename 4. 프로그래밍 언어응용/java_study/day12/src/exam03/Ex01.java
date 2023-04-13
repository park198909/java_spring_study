package exam03;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {

        Comparator<Integer> comp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        Random rand = new Random();
//        Set<Integer> nums = new TreeSet<>(comp);
        Set<Integer> nums = new TreeSet<>(Comparator.naturalOrder());   // 오름차순 정렬, reverseOrder()는 내림차순
        nums.add(rand.nextInt());
        nums.add(rand.nextInt());
        nums.add(rand.nextInt());
        nums.add(rand.nextInt());
        nums.add(rand.nextInt());

        for(Integer num : nums){
            System.out.println(num);
        }
    }
}
