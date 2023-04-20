package exam04;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex02 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate after7 = today.plus(7, ChronoUnit.DAYS);

        System.out.println(today);
        System.out.println(after7);
    }
}
