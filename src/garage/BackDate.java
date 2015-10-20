/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *Utility class to set generate a date of input hours ago
 * @author Zachary
 */
public class BackDate {
    private static final int MINUTES_PER_HOUR = 60;
    
    /**
     * This is the only method in this utility class
     * @param hoursPreParked input the number of hours previous to now you want the date to be
     * @return 
     */
    public static Date hoursAgo(double hoursPreParked){
        Date backDate;
        
        NumberFormat hours = new DecimalFormat("#00");
        NumberFormat minutes = new DecimalFormat("#0.00");
        
        int temp = Integer.parseInt(hours.format(hoursPreParked));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -temp);
        
        String mins = (minutes.format(hoursPreParked)).substring(1);
        temp = (int)(Double.parseDouble(mins)*MINUTES_PER_HOUR);
        //System.out.println(mins);
        //System.out.println(temp);
        cal.add(Calendar.MINUTE, -temp);
        
        backDate = cal.getTime();
        return backDate;
    }
}
