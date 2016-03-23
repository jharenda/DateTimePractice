/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPractice;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jennifer
 */
public class SimpleDateTime {
    public static void main(String[] args) {
        // old way (pre- JDK8)
        // not international 
        Date date1 = new Date(); 
        // every ojbject has a toString method 
        // built in standard format
             // get date/time long Integer value
        long dateTimeValue = date1.getTime();
        System.out.println( "sdfd " + dateTimeValue);
        // international
        //Calandear is an abstract class
        Calendar date3 = Calendar.getInstance(); 
        System.out.println(date3);
        
        //System.out.println(date1);
        System.out.println(date1.toString());
   
        
        // bad practice- don't do this - use of numerical value- really march and not feb 
        date3.set(2020, 2, 22);
        System.out.println("bad practice: " + date3);
        // goood 
         date3.set(2020, Calendar.MARCH, 22);
        
        
        // new way (JDK*+)
        //also international 
        LocalDateTime date2 = LocalDateTime.now(); 
        System.out.println(date2);
        // Date only (no time)
      LocalDateTime date4 = date2.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date4);
        
          Duration hoursDifference = Duration.between(date2, date4); 
        System.out.println( "Difference:  "  + hoursDifference.toHours());
        
        
    }
    
}
