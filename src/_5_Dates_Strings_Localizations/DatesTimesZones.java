package _5_Dates_Strings_Localizations;

import java.time.*;

public class DatesTimesZones {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

//        LocalDate d = new LocalDate(); // DOES NOT COMPILE
//        LocalDate.of(2015, Month.JANUARY, 32) // throws DateTimeException
    }

    public static void creatingDate() {
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);
    }

    public static void month() {
        Month month = Month.JANUARY;
//        boolean b1 = month == 1; // DOES NOT COMPILE
        boolean b2 = month == Month.APRIL; // false
    }

    public static void creatingTime() {
        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
    }

    public static void creatingDateTime() {
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalTime time1 = LocalTime.of(6, 15);

        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

    }

    public static void creatingZone() {
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalTime time1 = LocalTime.of(6, 15);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20,
                6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);

        //not needed
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("US") || z.contains("America"))
                .sorted().forEach(System.out::println);
    }

    public static void dateTimeFunctions() {
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date); // 2014–01–20
        date = date.plusDays(2);
        System.out.println(date); // 2014–01–22
        date = date.plusWeeks(1);
        System.out.println(date); // 2014–01–29
        date = date.plusMonths(1);
        System.out.println(date); // 2014–02–28
        date = date.plusYears(5);
        System.out.println(date); // 2019–02–28

        date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime); // 2020–01–20T05:15
        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime); // 2020–01–19T05:15
        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime); // 2020–01–18T19:15
        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime); // 2020–01–18T19:14:30

        dateTime = LocalDateTime.of(date, time)
                .minusDays(1)
                .minusHours(10)
                .minusSeconds(30);

    }

    public static void tricks() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        date.plusDays(10);
        System.out.println(date);       //January 20, 2020

        date = LocalDate.of(2020, Month.JANUARY, 20);
//        date = date.plusMinutes(1); // DOES NOT COMPILE

    }


    public static void convertingForDaylight() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]


        date = LocalDate.of(2016, Month.NOVEMBER, 6);
        time = LocalTime.of(1, 30);
        zone = ZoneId.of("US/Eastern");
        dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]
    }

}
