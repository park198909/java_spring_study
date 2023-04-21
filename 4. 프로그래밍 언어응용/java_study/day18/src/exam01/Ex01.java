package exam01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

import static java.time.temporal.ChronoField.*;

public class Ex01 {
    public static void main(String[] args){
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

//        LocalDate date2 = LocalDate.of(2022,4,21);
//        System.out.println(date2);

//        int year = date1.get(YEAR);
//        int month = date1.get(MONTH_OF_YEAR);
//        int day = date1.get(DAY_OF_MONTH);

//        int yoil = date1.get(DAY_OF_WEEK);
        int year = date1.getYear();
        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();
        DayOfWeek dayOfWeek = date1.getDayOfWeek();
        int yoil = dayOfWeek.getValue();
        String yoilStr = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        System.out.printf("year= %d, month= %d, day= %d, yoil=%d%n",year,month,day,yoil);
        System.out.printf("요일=%s%n",yoilStr);
    }
}
