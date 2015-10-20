/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.NumberFormat;

/**
 *
 * @author Zachary
 */
public class OwnerTotalFile implements OwnerOutStrategy{
    //rt is running total
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private final NumberFormat money = NumberFormat.getCurrencyInstance();
    private double rtHours;
    private double rtMoney;
    private PrintWriter writer;

    private void addHours(double hours) {
        this.rtHours += hours;
    }

    private void addMoney(double money) {
        this.rtMoney += money;
    }
    
    

    @Override
    public void update(double HoursParked, double MoneyCollected) {
        //needs validation
        this.addHours(HoursParked);
        this.addMoney(MoneyCollected);
        try {
            writer = new PrintWriter((FileDate.todayIs()+" Totals.txt"));
            writer.println(GARAGE_NAME+" daily totals\n Hours Charged: "+rtHours+
                    " Money Collected: "+money.format(rtMoney));
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OwnerTotalFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
