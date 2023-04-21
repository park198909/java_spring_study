package exam02;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Ex05 {
    public static void main(String[] args){
//        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.stream().filter(s->s.contains("Asia")).forEach(System.out::println);

        // Asia/Jakarta
        // Asia.Yakutsk
        // America/New_York
        ZonedDateTime zdt1 = ZonedDateTime.now();
        ZonedDateTime zdt2 = zdt1.withZoneSameInstant(ZoneId.of("Asia/Jakarta"));
        ZonedDateTime zdt3 = zdt1.withZoneSameInstant(ZoneId.of("Asia/Yakutsk"));
        ZonedDateTime zdt4 = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("Asia/Jakarta : "+zdt2);
        System.out.println("Asia/Yakutsk : "+zdt3);
        System.out.println("America/New_York : "+zdt4);
    }
}
