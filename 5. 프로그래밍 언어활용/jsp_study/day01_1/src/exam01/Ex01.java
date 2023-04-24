package exam01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex01 {
    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.now();
        System.out.println(date1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm (E)");
        String dateStr = formatter.format(date1);
        System.out.println(dateStr);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yy/MM/dd a hh:mm:ss");
        String dateStr2 = formatter2.format(date1);
        System.out.println(dateStr2);


    }
}
