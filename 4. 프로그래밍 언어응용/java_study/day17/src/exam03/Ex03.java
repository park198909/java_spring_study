package exam03;

import java.util.Calendar;

import static java.util.Calendar.*;

public class Ex03 {
    public static void main(String[] args) {
        Calendar cal = getInstance();
        printDate(cal);

        cal.add(DAY_OF_MONTH, 7);
        printDate(cal);

        cal.add(DAY_OF_MONTH,-7);
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
