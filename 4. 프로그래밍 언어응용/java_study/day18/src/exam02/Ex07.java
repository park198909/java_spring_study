package exam02;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Ex07 {
    public static void main(String[] args){
        OffsetDateTime odt1 = OffsetDateTime.now();
        System.out.println(odt1);

        ZoneOffset jakarta = ZoneOffset.of("+7");
        OffsetDateTime odt2 = odt1.withOffsetSameInstant(jakarta);
        System.out.println(odt2);
    }
}
