/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author Zachary
 */
public class CarOutTerm {
    private OwnerOutStrategy own;
    private CustOutStrategy cust;
    private FeeCalcStrategy feeCalc;
    private ParkingLot lot;
    private double fee;

    public CarOutTerm(ParkingLot lot, OwnerOutStrategy own, CustOutStrategy cust, FeeCalcStrategy feeCalc) {
        this.own = own;
        this.cust = cust;
        this.feeCalc = feeCalc;
        this.lot = lot;
    }
    
    public void releaseCar(double hoursParked, int carId){
        //needs validation, carId needs to be >1000, hoursParked can't be >24
        fee = feeCalc.getFee(hoursParked);
        own.update(hoursParked, fee);
        cust.output(carId, hoursParked, fee);
    }
    
    public void releaseCar(int carId){
        //needs validation, carId needs to be >1000, and preferably exist
        double hoursParked = this.checkHoursParked(carId);
        fee = feeCalc.getFee(hoursParked);
        own.update(hoursParked, fee);
        cust.output(carId, hoursParked, fee);
    }
    
    public double checkHoursParked(int carId){
        //needs validation, carId needs to be >1000, and preferably exist
        FileDate fd = new FileDate();
        String timeIn = fd.dayOf(lot.timeIn(carId)) +" "+ fd.timeOf(lot.timeIn(carId));
        String timeOut = fd.todayIs() +" "+fd.timeIs();
        double hoursParked;
        if(this.isSameDay(timeIn, timeOut)){
            hoursParked = this.hoursFromFileDate(timeOut) - this.hoursFromFileDate(timeIn);
        }else{//assuming no car parks for >24 hrs. If they park for longer, I need a daysDifFromFileDate method
            //add a day's hours to timeOut 
            hoursParked = (this.hoursFromFileDate(timeOut)+24)- this.hoursFromFileDate(timeIn);
        }
        return hoursParked;
    }
    /**
     * takes two strings and compares them. I'm comparing two dates in identical string format
     * @param one
     * @param two
     * @return 
     */
    private boolean isSameDay(String one, String two){
        boolean back = false;
        if(one.substring(0,8).equals(two.substring(0,8))){
            back = true;
        }
        
        return back;
    }
    /**
     * takes one date in the format that checkHoursParked makes, and gets the hours back in a double
     * @param in
     * @return 
     */
    private double hoursFromFileDate(String in){
        double back;
        double minutes = Double.parseDouble(in.substring(12));
        NumberFormat formatter = new DecimalFormat("#0.00");     
        //System.out.println(minutes);
        minutes = (minutes / 60);
        //System.out.println(minutes);
        String mins = formatter.format(minutes);
        //System.out.println(mins);
        String temp = in.substring(9,11)+""+mins.substring(1);
        back = Double.parseDouble(temp);
        
        return back;
    }
}
