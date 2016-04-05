package student.lab;

import java.time.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Utility class to simplify managing and using dates and times, using the new
 * Java Date/Time API (JDK 8).
 *
 * @since JDK 8
 * @author Jennifer
 */
public class DateTimeUtilities {

    /**
     * Returns the current date and time as a string, in the format "dd/MM/yy
     * HH:mm a" For example, 03/04/16 15:32 PM
     *
     * @return the current date and time, in the pre-defined, custom specified
     * format.
     */
    public String getCurrentDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm a");
        String dateString = dateTime.format(formatter);
        return dateString;
    }

    /**
     * Obtains the current date-time from the system clock in the default
     * time-zone as a LocalDateTime object
     *
     * @return A LocalDateTime object containing the current date and time using
     * the system clock and default time-zone, not null
     */
    public LocalDateTime getLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime;
    }

    /**
     * Obtains the current date from the system clock in the default time-zone
     * as a LocalDate object
     *
     * @return A LocalDate object containing the current date using the system
     * clock and default time-zone, not null
     */
    public LocalDate getLocalDate() {
        LocalDate date = LocalDate.now();
        return date;
    }

    /**
     * Convert a LocalDate object to a String with a specified format.
     *
     * @param date a LocalDate object
     * @param dateFormat a String indicating the desired format pattern to be
     * applied to the LocalDateTime object. For example, "MM-dd-yyyy" Please see
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * for more information about String format patterns.
     * @return String of a LocalDate object in the specified pattern/format.
     * @throws IllegalArgumentException if the String dateFormat parameter is
     * null or empty or if the LocalDate parameter is null
     * @throws DateTimeParseException if the dateFormat pattern provided is not
     * a valid/legal pattern. (see link above)
     */
    public String dateToString(LocalDate date, String dateFormat) throws IllegalArgumentException, DateTimeParseException {
        String formattedDate = null;
        if (dateFormat == null || dateFormat.isEmpty() || date == null) {
            throw new IllegalArgumentException("Null or empty value @ dateToString");
        } else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
                formattedDate = date.format(formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage() + "input did not match a legal pattern.");
            }
        }

        return formattedDate;
    }

    /**
     * Converts a LocalDateTime object to a String with a specified format.
     *
     * @param date a LocalDateTime object
     * @param dateFormat a String indicating the desired format pattern to be
     * applied to the LocalDateTime object. For example, "MM-dd-yyyy hh:mm"
     * Please see
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * for more information about String format patterns.
     * @return String of a LocalDateTime object in the specified formated
     * pattern
     * @throws IllegalArgumentException if the String dateFormat parameter is
     * null or empty or if the LocalDateTime parameter is null.
     * @throws DateTimeParseException if the dateFormat pattern provided is not
     * a valid/legal pattern. (see link above)
     */
    public String dateTimeToString(LocalDateTime date, String dateFormat) throws IllegalArgumentException, DateTimeParseException {
        String formattedDateTime = "";

        if (dateFormat == null || dateFormat.isEmpty() || date == null) {
            throw new IllegalArgumentException("Null or empty value @ dateTimeToString");
        } else {

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
                formattedDateTime = date.format(formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage() + "input did not match a legal pattern.");
            }

            return formattedDateTime;
        }
    }

    /**
     * Converts a String input of a date and time into a LocalDateTime object
     *
     * @param dateInput- a String including date and time information.
     * IMPORTANT: Input pattern required to match: "yy-MM-dd HH:mm"
     * @return- the input string as a LocalDateTime object formatted as
     * "yy-MM-dd HH:mm"
     * @throws IllegalArgumentException if the string dateInput is null or
     * empty.
     * @throws DateTimeParseException- if the dateInput String does not match
     * "yy-MM-dd HH:mm"
     */
    public LocalDateTime toLocalDateTime(String dateInput) throws IllegalArgumentException, DateTimeParseException {
        LocalDateTime dateTime = null;
        if (dateInput == null || dateInput.isEmpty()) {
            throw new IllegalArgumentException("DateUtilities.dateStringOne recieved null or empty string");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
        try {

            dateTime = LocalDateTime.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage() + "input must match pattern:  \"yy-MM-dd HH:mm\"");
        }
        return dateTime;
    }

    /**
     * Converts a String input of a date into a LocalDateTime object.
     *
     * @param dateInput a String representation of a date. IMPORTANT: Pattern
     * required to match "yyy-MM-dd"
     * @return the value of dateInput as a LocalDate object
     * @throws IllegalArgumentException if dateInput parameter is empty or null
     * @throws DateTimeParseException if pattern of inputted String parameter
     * does not match "yyy-MM-dd"
     */
    public LocalDate toLocalDate(String dateInput) throws IllegalArgumentException, DateTimeParseException {
        LocalDate date = null;
        if (dateInput == null || dateInput.isEmpty()) {
            throw new IllegalArgumentException("DateUtilities.dateStringOne null or empty");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                date = LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage() + "input did not match a legal pattern.");
            }
        }
        return date;
    }

    /**
     * Calculates the number of months and days until the user's next birthday,
     * based on input of a year, month,and day value.
     *
     * @param year integer value representing a year
     * @param month integer value representing a month
     * @param day integer value representing a day of the month
     * @return a String message that indicates the number of months and days
     * until the next birthday based on the provided values.
     * @throws IllegalArgumentException- if an invalid day, month, or year value
     * is used
     * @throws DateTimeException - if the value of any field is out of range, or
     * if the day-of-month is invalid for the month-year
     */
    public String birthdayCalculator(int year, int month, int day) throws IllegalArgumentException, DateTimeException {
        String output;
        if (year < 1000 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("Illegal Arugument to bday countdown");
        } else {
            LocalDate today = LocalDate.now();

            LocalDate birthday = LocalDate.of(year, month, day);

            LocalDate nextBDay = birthday.withYear(today.getYear());

//If birthday already occured this year, add 1 to the year to set the next bday to nextyear.
            if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
                nextBDay = nextBDay.plusYears(1);
            }

            Period p = Period.between(today, nextBDay);
            long p2 = ChronoUnit.DAYS.between(today, nextBDay);
            output = (p.getMonths() + " months and "
                    + p.getDays() + " days until your next birthday. ("
                    + p2 + " days total)");
        }
        return output;
    }

    public static void main(String[] args) {
        DateTimeUtilities dtu = new DateTimeUtilities();
        try {
            System.out.println(dtu.dateToString(dtu.getLocalDate(), "MM-dd-yyyy"));
            System.out.println(dtu.dateTimeToString(dtu.getLocalDateTime(), "dd"));
            System.out.println("Right now: " + dtu.getCurrentDateTime());
            System.out.println(dtu.toLocalDateTime("10-12-11 12:33"));
            System.out.println(dtu.toLocalDate("2345-11-18"));
            System.out.println(dtu.birthdayCalculator(1200, 66, 31));
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
