/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Zachary
 */
public class CustConsoleReceipt implements CustOutStrategy{
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private final NumberFormat money = NumberFormat.getCurrencyInstance();
    private final NumberFormat hours = new DecimalFormat("#00.00");
    private FileDate now = new FileDate();
    
    @Override
    public void output(int carId, double hoursParked, double moneyCharged) {
        //needs validation
        
        System.out.println("Thank you for parking at "+GARAGE_NAME+
                ", your ID was "+carId+".\nYou parked for "+hours.format(hoursParked)+" hours,"+
                " starting at " +now.timeIs()+" on "+now.todayIs()+
                ", and your total was to "+money.format(moneyCharged));
    }
    
}
