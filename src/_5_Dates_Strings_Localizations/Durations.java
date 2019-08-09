package _5_Dates_Strings_Localizations;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Durations {

    public static void main(String[] args) {
        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
    }

    public static void additionalExample() {
        Duration daily = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano = Duration.of(1, ChronoUnit.NANOS);
    }

    public static void inAction() {
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Duration duration = Duration.ofHours(6);
        System.out.println(dateTime.plus(duration)); // 2015–01–20T12:15
        System.out.println(time.plus(duration)); // 12:15
        System.out.println(date.plus(duration)); // UnsupportedTemporalException
    }

    public static void inAction2() {
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Duration duration = Duration.ofHours(23);
        System.out.println(dateTime.plus(duration)); // 2015–01–21T05:15
        System.out.println(time.plus(duration)); // 05:15
        System.out.println(date.plus(duration)); // UnsupportedTemporalExceptio

    }

    public static void trikcs() {
        LocalDate date = LocalDate.of(2015, 5, 25);
        Period period = Period.ofDays(1);
        Duration days = Duration.ofDays(1);
        System.out.println(date.plus(period)); // 2015–05–26
        System.out.println(date.plus(days)); // Unsupported unit: Seconds
    }

}
