/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.NumberFormat;

/**
 *
 * @author Zachary
 */
public class CustConsoleReceipt implements CustOutStrategy{
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private final NumberFormat money = NumberFormat.getCurrencyInstance();
    @Override
    public void output(int carId, double hoursParked, double moneyCharged) {
        
        System.out.println("Thank you for parking at "+GARAGE_NAME+
                ", your ID was "+carId+".\nYou parked for "+hoursParked+" hours,"+
                " and your total was to "+money.format(moneyCharged));
    }
    
}
