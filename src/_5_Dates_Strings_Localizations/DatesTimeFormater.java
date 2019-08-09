package _5_Dates_Strings_Localizations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatesTimeFormater {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);

        System.out.println(date.getDayOfWeek()); // MONDAY
        System.out.println(date.getMonth()); // JANUARY
        System.out.println(date.getYear()); // 2020
        System.out.println(date.getDayOfYear()); // 20


        date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));          // 2020–01–20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));          //11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); //2020–01–20T11:12:34
    }

    public static void ofLocalizedDate() {

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortDateTime =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime)); // 1/20/20
        System.out.println(shortDateTime.format(date)); // 1/20/20
        System.out.println(
                shortDateTime.format(time)); // UnsupportedTemporalTypeException

        // another aprouch
        System.out.println(dateTime.format(shortDateTime));
        System.out.println(date.format(shortDateTime));
        System.out.println(time.format(shortDateTime));
    }

    public static void example() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime)); // 1/20/20 11:12 AM
        System.out.println(mediumF.format(dateTime)); // Jan 20, 2020 11:12:34 AM
    }

    public static void ofPattern() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

        f = DateTimeFormatter.ofPattern("hh:mm");
        f.format(dateTime);
        f.format(date);
        f.format(time);

        f = DateTimeFormatter.ofPattern("MM dd yyyy");
        date = LocalDate.parse("01 02 2015", f);
        time = LocalTime.parse("11:22");

        System.out.println(date); // 2015–01–02
        System.out.println(time); // 11:22

    }

    /*
      MMMM M represents the month. The more Ms you have, the more verbose the Java output. For
      example, M outputs 1, MM outputs 01, MMM outputs Jan, and MMMM outputs January.
      dd d represents the day in the month. As with month, the more ds you have, the more verbose
      the Java output.

      dd means to include the leading zero for a single-digit day., Use , if you want to output a comma
      (this also appears after the year).

      yyyy y represents the year. yy outputs a two-digit year and yyyy outputs a four-digit year.

      hh h represents the hour. Use hh to include the leading zero if you’re outputting a single-digit hour.
      : Use : if you want to output a colon.

      mm m represents the minute omitting the leading zero if present. mm is more common and
      represents the minutes using two digits.
    * */
}
