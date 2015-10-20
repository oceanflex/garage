/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;
import java.util.Date;

/**
 *
 * @author Zachary
 */
public class CarInTerm {
    private int carId = 1000;
    private final CarDataAccess lot;
    
    public CarInTerm(CarDataAccess lot){
        this.lot = lot;
    }
    
    public void newCar(){
        this.carId++;
        int newCarId = this.carId;
        Date time = new Date();
        lot.addCar(newCarId, time);
    }
    /**
     * this method is for testing and demo purposes only
     * @param hoursPreParked the number of hours to backdate the start time of the car parking
     */
    public void newCar(double hoursPreParked){
        this.carId++;
        int newCarId = this.carId;
        Date backDateTime = BackDate.hoursAgo(hoursPreParked);
        lot.addCar(newCarId, backDateTime);
    }
    
//    private Date backDate(double hoursPreParked){
//        Date backDate;
//        
//        NumberFormat hours = new DecimalFormat("#00");
//        NumberFormat minutes = new DecimalFormat("#0.00");
//        
//        int temp = Integer.parseInt(hours.format(hoursPreParked));
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.HOUR, -temp);
//        
//        String mins = (minutes.format(hoursPreParked)).substring(1);
//        temp = (int)(Double.parseDouble(mins)*60);
//        //System.out.println(mins);
//        //System.out.println(temp);
//        cal.add(Calendar.MINUTE, -temp);
//        
//        backDate = cal.getTime();
//        return backDate;
//    }
    
//    public static void main(String[] args) {
//        ParkingLot lot = new ParkingLot();
//        CarInTerm in = new CarInTerm(lot);
//        System.out.println(in.backDate(10.22));
//        Date date = new Date();
//        System.out.println(date);
//    }
}
