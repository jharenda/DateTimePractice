/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jennifer
 */
public class Practice2 {
    public static void main(String[] args) throws ParseException {
        
          DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG); 
         DateFormat df = DateFormat.getDateInstance(DateFormat.LONG); 
        // Create a simple date formatter
        String format = "MM/dd/yyyy"; 
        
         String format2 = "MM/dd/yyyy hh:mm:ss a"; 
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        
        //current date and time
        Calendar date1 = Calendar.getInstance(); 
        System.out.println(df.format(date1.getTime()));
        date1.add(Calendar.DATE, -30);
        System.out.println(sdf.format(date1.getTime()));
        
        
         System.out.println(sdf.format(date1.getTime()));
         // turn string into date 
         String dateString = "11/11/2016";
         // is a checked exception 
         Date date2 = sdf.parse(dateString); 
        // sdf.format(date2);
         System.out.println( sdf.format(date2));
         
          LocalDateTime date3 = LocalDateTime.now(); 
        System.out.println(date3);
    }
  
}
