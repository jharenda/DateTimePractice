package student.lab;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Utility class to simplify managing and using dates and times, using the new
 * Java Date/Time API (JDK 8).
 *
 * @author Jennifer
 */
public class DateTimeUtilities {

    /**
     * gets the current date and time as a LocalDateTime and returns a string
     * value representation of the current value in the format of "dd/MM/yy
     * HH:mm a")
     *
     * @return the current date and time, in the pre-defined, custom specified
     * format. // do I need to add any ex. handling? ask
     */
    public String standardCurrentDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm a");
        String dateString = dateTime.format(formatter);
        return dateString;
    }

    /**
     * Returns a String of a LocalDateTime object. This is for LocalDateTime,
     * and will return the date and the time. It will not work for LocalDate.
     * Uses the format parameter passed to the DateTimeFormatter to format the
     * date parameter.
     *
     * @param date LocalDateTime Object to be converted to a string.
     * @param format String value indicating the string format the LocalDateTime
     * object will be converted to. ex: "MM-dd-YYYY hh:mm Refer to API for
     * String options:
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return formatted date time string.
     * @throws IllegalArgumentException if date/time input is null or empty, or
     * if format is null, empty, or if the format parameter is null, empty, or a
     * bad format.
     */
    public String toString(LocalDateTime dateTime, String format) throws IllegalArgumentException {
        String formattedDate = null;
        if (dateTime == null) {
            throw new IllegalArgumentException();
        } else if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter formatter = null;
        try {
            formatter = DateTimeFormatter.ofPattern(format);

            formattedDate = dateTime.format(formatter);
        } catch (IllegalArgumentException ex) {
            System.out.println("input pattern not valid. " + ex.getMessage());
        }

        return formattedDate;
    }

    /**
     * converts a String parameter into a LocalDateTime object with a
     * pre-defined, custom format. Uses the format parameter passed to the
     * DateTimeFormatter to format the date parameter. Refer to API for String
     * options:
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     *
     * @param dateInput- a string, to be formatted as a date.
     * @return- the input string as a formatted LocalDateTime object
     * @throws IllegalArgumentException if the string dateInput is null or
     * empty.
     * @throws DateTimeParseException- if the dateString input does not match
     * the specified format
     */
    public LocalDateTime dateTimeStringtoDateTime(String dateInput) throws IllegalArgumentException, DateTimeParseException {
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
     *
     * @param dateInput
     * @return A LocalDate object
     * @throws IllegalArgumentException if dateInput parameter is empty or null
     * @throws DateTimeParseException if pattern of inputted String parameter is
     * not a valid pattern
     */
    public LocalDate dateStringToDate(String dateInput) throws IllegalArgumentException, DateTimeParseException {
        LocalDate date = null;
        if (dateInput == null || dateInput.isEmpty()) {
            throw new IllegalArgumentException("DateUtilities.dateStringOne");
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
     * based on input of a year, month, and date value.
     *
     * @param year int input of a year
     * @param month int input of a month
     * @param day int input of a day of the month
     * @return a string value of a phrase that contains the number of months and
     * days until the next birthday
     * @throws IllegalArgumentException- if and invalid day, month, or year
     * value is used
     * @throws DateTimeException - if the value of any field is out of range, or
     * if the day-of-month is invalid for the month-year
     */
    public String birthdayCountdown(int year, int month, int day) throws IllegalArgumentException, DateTimeException {
        String output;

        if (year < 1900 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("Illegal Arugument to bday countdown");
        } else {
            LocalDate today = LocalDate.now();

            LocalDate birthday = LocalDate.of(year, month, day);

            LocalDate nextBDay = birthday.withYear(today.getYear());

//If your birthday already occured this year, add 1 to the year to set the next bday to nextyear.
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
        System.out.println(dtu.standardCurrentDateTime());
        System.out.println(dtu.dateTimeStringtoDateTime("10-12-11 12:33"));
        System.out.println(dtu.dateStringToDate("2345-11-18"));
        System.out.println(dtu.toString(LocalDateTime.now(), "11-12-3456 03:33 a"));
            
            System.out.println(dtu.birthdayCountdown(1990, 2, 12));
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
