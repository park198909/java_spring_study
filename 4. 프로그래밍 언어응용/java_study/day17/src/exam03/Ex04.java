package exam03;

import java.util.Calendar;

import static java.util.Calendar.*;
import static java.util.Calendar.SECOND;

public class Ex04 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        printDate(cal);

//        cal.set(MONTH, 11); // 11 == 12
//        printDate(cal);

//        cal.add(DAY_OF_MONTH, 100);
//        printDate(cal);

        cal.roll(DAY_OF_MONTH, 100);
        printDate(cal);

    }

    public static void printDate(Calendar cal) {
        int year = cal.get(YEAR);
        int month = cal.get(MONTH)+1;
        int day = cal.get(DAY_OF_MONTH);

        int hour = cal.get(HOUR_OF_DAY);
        int min = cal.get(MINUTE);
        int sec = cal.get(SECOND);

        System.out.printf("%d-%d-%d %d:%d:%d%n",year,month,day,hour,min,sec);
    }
}
