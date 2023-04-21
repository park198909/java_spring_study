package exam01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex02 {
    public static void main(String[] args){
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

//        LocalDate date2 = date1.minus(7, ChronoUnit.DAYS);
        LocalDate date2 = date1.minusDays(7);
        System.out.println(date2);

//        LocalDate date3 = date2.plus(7,ChronoUnit.DAYS);
        LocalDate date3 = date2.plusDays(7);
        System.out.println(date3);
    }
}
