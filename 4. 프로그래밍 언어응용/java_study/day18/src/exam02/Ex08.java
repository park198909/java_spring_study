package exam02;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Ex08 {
    public static void main(String[] args){
        LocalDateTime date1 = LocalDateTime.now();
        ZoneOffset seoul = ZoneOffset.of("+9");
        OffsetDateTime odt = date1.atOffset(seoul);
        System.out.println(odt);
    }
}
