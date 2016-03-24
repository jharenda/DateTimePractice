package student.lab;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Jennifer
 */
public class DateUtilities {

    LocalDateTime dateTime;

    /**
     * converts a string into a date
     *
     * @param dateInput- a string, to be formatted as a date
     * @return- a LocalDateTime
     * @throws IllegalArgumentException
     */
    public LocalDateTime dateStringCustomPattern(String dateInput) throws IllegalArgumentException {
        if (dateInput == null || dateInput.isEmpty()) {
            throw new IllegalArgumentException("DateUtilities.dateStringOne");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dateTime = LocalDateTime.parse(dateInput, formatter);
        }

        return dateTime;
    }

    public LocalDate dateStringNotCustom(String dateInput) {
        //String dateInput = "20160112";if (dateInput == null || dateInput.isEmpty()) {
        if (dateInput == null || dateInput.isEmpty()) {
            throw new IllegalArgumentException("DateUtilities.dateStringOne");
        } else {
        
        LocalDate formattedDate = LocalDate.parse(dateInput, DateTimeFormatter.BASIC_ISO_DATE);
        return formattedDate;
}
    }

    /**
     *
     * @return the current date as a String
     * @throws IllegalArgumentException
     */

    public String currentDateToString() throws IllegalArgumentException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        // LocalDate parsedDate = LocalDate.parse(text, formatter);
        return text;
        //return parsedDate; 
    }
    /**
     * 
     * @return  a string value of a phrase that contains the number of days until the next birthday 
     */
    public String countdown() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1984, Month.JULY, 2);

        LocalDate nextBDay = birthday.withYear(today.getYear());

//If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        String output = ("There are " + p.getMonths() + " months, and "
                + p.getDays() + " days until your next birthday. ("
                + p2 + " total)");
        return output;
    }

    /**
     * Converts a LocalDate (ISO) value to a ChronoLocalDate date using the
     * provided Chronology, and then formats the ChronoLocalDate to a String
     * using a DateTimeFormatter with a SHORT pattern based on the Chronology
     * and the current Locale.
     *
     * @param localDate - the ISO date to convert and format.
     *
     */
    public String toString(LocalDate localDate) {
        ChronoLocalDate cDate;

        Chronology chrono = IsoChronology.INSTANCE;

        try {
            cDate = chrono.date(localDate);
        } catch (DateTimeException ex) {
            System.err.println(ex);

            cDate = localDate;
        }
        DateTimeFormatter dateFormatter
                = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        return dateFormatter.format(cDate);
    }

    public void birthday() {
        LocalDate customerBirthday = LocalDate.now();
        LocalDate today = LocalDate.now();
        if (customerBirthday.equals(today)) {
            LocalDate specialOfferExpiryDate = today.plusWeeks(2);
            //customer.sendBirthdaySpecialOffer(specialOfferExpiryDate);
            System.out.println(specialOfferExpiryDate);
        }

    }
}
