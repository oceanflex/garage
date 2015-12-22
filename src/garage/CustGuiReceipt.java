package garage;

import guiIO.Receipt;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *This CustOutStrategy will print the input information to the console,
 * as well as the garage name, all as a polite receipt
 * @author Zachary
 */
public class CustGuiReceipt implements CustOutStrategy{
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private static final NumberFormat money = NumberFormat.getCurrencyInstance();
    private static final NumberFormat hours = new DecimalFormat("#00.00");
    
    public CustGuiReceipt(){
        
    }
    
    @Override
    public void output(int carId, double hoursParked, double moneyCharged) {
        //needs validation
        
        String out = ("Thank you for parking at "+GARAGE_NAME+
                ",\nyour ID was "+carId+".\nYou parked for "
                +hours.format(hoursParked)+" hours,\nstarting at " +
                BackDate.hoursAgo(hoursParked)+",\nand your total was to "+
                money.format(moneyCharged));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt(out).setVisible(true);
            }
        });
    }
    
}
