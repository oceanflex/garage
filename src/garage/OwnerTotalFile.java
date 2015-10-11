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

/**
 *
 * @author Zachary
 */
public class OwnerTotalFile implements OwnerOutStrategy{
    //rt is running total
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private double rtHours;
    private double rtMoney;
    private FileDate now = new FileDate();
    private PrintWriter writer;

    public void addHours(double Hours) {
        this.rtHours += Hours;
    }

    public void addMoney(double Money) {
        this.rtMoney += Money;
    }
    
    

    @Override
    public void update(double HoursParked, double MoneyCollected) {
        this.addHours(HoursParked);
        this.addMoney(MoneyCollected);
        try {
            writer = new PrintWriter((now.todayIs()+" Totals.txt"));
            writer.println(GARAGE_NAME+" Hours Charged: "+rtHours+" Money Collected: "+rtMoney);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OwnerTotalFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
