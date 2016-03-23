/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

/**
 *
 * @author Jennifer
 */
public class Startup {
    public static void main(String[] args) {
        DateUtilities dateUtilities = new DateUtilities();
       String dateInputOne = "1986-04-08 12:30";
        try {
            System.out.println(dateUtilities.currentDateToString());
           // System.out.println(dateUtilities.dateStringOne(dateInputOne));
        }
        catch (IllegalArgumentException e ){
        System.out.println(e.getMessage()); 
    }
        System.out.println(dateUtilities.countdown());
    }
    
}
