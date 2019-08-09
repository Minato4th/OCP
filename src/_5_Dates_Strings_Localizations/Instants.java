package _5_Dates_Strings_Localizations;

import java.time.*;

public class Instants { // need to convert time in GMT time zone.

    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();
        Thread.sleep(100);
        Instant later = Instant.now();

        Duration duration = Duration.between(now, later);
        System.out.println(duration.toMillis());
    }


    public static void toInstant() {
        LocalDate date = LocalDate.of(2015, 5, 25);
        LocalTime time = LocalTime.of(11, 55, 00);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
        Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
        System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
        System.out.println(instant); // 2015–05–25T15:55:00Z

    }

    public static void ofEpochSecond() {
        Instant instant = Instant.ofEpochSecond(1223211);
        System.out.println(instant);
    }

}
