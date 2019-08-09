package _5_Dates_Strings_Localizations;

import java.time.*;

public class Periods {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        performAnimalEnrichment(start, end);

        Period period = Period.ofMonths(1); // create a period
        performAnimalEnrichment(start, end, period);
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add a month
        }
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end,
                                                Period period) { // uses the generic period
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }
    }

    public static void functions() {
        Period annually = Period.ofYears(1);                // every 1 year
        Period quarterly = Period.ofMonths(3);              // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3);         // every 3 weeks
        Period everyOtherDay = Period.ofDays(2);            // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        Period wrong = Period.ofYears(1).ofWeeks(1);  // result only every week

        System.out.println(Period.ofMonths(3)); // P3M
        System.out.println(Period.of(0, 20, 47)); // P20M47D
    }

    public static void additional() {

        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Period period = Period.ofMonths(1);
        System.out.println(date.plus(period)); // 2015–02–20
        System.out.println(dateTime.plus(period)); // 2015–02–20T06:15
        System.out.println(time.plus(period)); // UnsupportedTemporalTypeException

    }

}
