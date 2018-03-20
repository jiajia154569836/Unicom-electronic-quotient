package learn.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class date {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        Date date = new Date();
        // Thread thread = Thread.currentThread();
        Instant instant1 = date.toInstant();
        System.out.println(date);
        System.out.println(instant);
        System.out.println(instant1);


        ZoneOffset zoneOffset1  = ZoneOffset.ofHours(11);
        System.out.println(zoneOffset1);
        ZoneOffset zoneOffset2  = ZoneOffset.ofHoursMinutes(6, 30);
        System.out.println(zoneOffset2);
        ZoneOffset zoneOffset3  = ZoneOffset.ofHoursMinutesSeconds(9, 30,  45);
        System.out.println(zoneOffset3);

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        LocalDateTime delayTime = LocalDateTime.ofInstant(instant, zone);
        System.out.println(delayTime);
    }
}
