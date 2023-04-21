package exam02;

import java.time.LocalDateTime;

public class Ex02 {
    public static void main(String[] args){
        LocalDateTime date1 = LocalDateTime.now();
        System.out.println(date1);

        LocalDateTime date2 = LocalDateTime.of(2022,4,21,15,23,20);
        System.out.println(date2);

    }
}
