/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author Jennifer
 */
public class LabChallenges {
   public static void main(String[] args) {    
       LabChallenges lc = new LabChallenges();
        System.out.println(lc.hoursDifference());    
     
       
       
 
}

/**
 * calculates the difference in hours between the current date and  the first day of the current month
 * @return a Long- A Duration object converted to the hours of the difference. 
 */
   public  Long hoursDifference(){
           LocalDateTime date1 = LocalDateTime.now(); 
      
        // Date only (no time)
      LocalDateTime date2 = date1.with(TemporalAdjusters.firstDayOfMonth());
    
        
          Duration hoursDifference = Duration.between(date1, date2); 
        //System.out.println( "Difference:  "  + hoursDifference.toHours());
      return hoursDifference.toHours(); 
   
   
}
}
