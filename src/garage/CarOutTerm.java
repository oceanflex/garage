package garage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *This class is a central processor that will ask other classes to interact with users,
 * access and store data for program and owner use, and run calculations.
 * This terminal is the last point of contact with the system customers will have.
 * @author Zachary
 */
public class CarOutTerm {
    private final OwnerOutStrategy own;
    private final CustOutStrategy cust;
    private final FeeCalcStrategy feeCalc;
    private final CarDataAccess lot;
    private double fee;
/**
 * The constructor needs a lot of information in order to properly output,
 * collect, and calculate all of the information. This includes a pointer to the
 * ticket database, owner and customer outputs, as well as the fee calculator
 * @param lot - this is the data access strategy to lookup carIds in
 * @param own - this is the owner's output strategy
 * @param cust - this is the customers output strategy
 * @param feeCalc -this is the fee calculator to check fees with
 */
    public CarOutTerm(CarDataAccess lot, OwnerOutStrategy own, CustOutStrategy cust, FeeCalcStrategy feeCalc) {
        this.own = own;
        this.cust = cust;
        this.feeCalc = feeCalc;
        this.lot = lot;
    }
    
    private void releaseCar(double hoursParked, int carId){
        //needs validation(if public), carId needs to be >1000, hoursParked can't be >24.
        //for demos, you could change to public, because of the backdating newCar method in CarInTerm
        fee = feeCalc.getFee(hoursParked);
        own.update(hoursParked, fee);
        cust.output(carId, hoursParked, fee);
    }
    /**
     * this method will output to both the customer and owner, all details about
     * the transaction, based on the carId's ticket in the database
     * @param carId input carId to get information to display
     */
    public void releaseCar(int carId){
        //needs validation, carId needs to be >1000, and preferably exist
        double hoursParked = this.checkHoursParked(carId);
        this.releaseCar(hoursParked, carId);
    }
    
    private double checkHoursParked(int carId){
        LocalDateTime dtOut = LocalDateTime.now();
        LocalDateTime dtIn = LocalDateTime.ofInstant(lot.getTimeIn(carId).toInstant(), ZoneId.systemDefault());
        
        
//        FileDate fd = new FileDate();
//        String timeIn = fd.dayOf(lot.getTimeIn(carId)) +" "+ fd.timeOf(lot.getTimeIn(carId));
//        String timeOut = fd.todayIs() +" "+fd.timeIs();
        double hoursParked;
        //if(this.isSameDay(timeIn, timeOut)){
//        if(dtIn.getDayOfYear() == dtOut.getDayOfYear()){//if one day after in is after out, it's the same day
//            //hoursParked = this.hoursFromFileDate(timeOut) - this.hoursFromFileDate(timeIn);
//            hoursParked = this.hoursFromFileDate(this.getStringTime(dtOut)) -
//                    this.hoursFromFileDate(this.getStringTime(dtIn));
//        }else{//assuming no car parks for >24 hrs. If they park for longer, I need a daysDifFromFileDate method
//            //add a day's hours to timeOut 
//           // hoursParked = (this.hoursFromFileDate(timeOut)+24)- this.hoursFromFileDate(timeIn);
//           hoursParked = (this.hoursFromFileDate(this.getStringTime(dtOut))) -
//                    (this.hoursFromFileDate(this.getStringTime(dtIn)));
////           if(hoursParked < 0 ){
////               hoursParked += 24;
////           }
//        }
        long minutes = ChronoUnit.MINUTES.between(dtIn, dtOut);
        long hours = ChronoUnit.HOURS.between(dtIn,dtOut);
        minutes = minutes % 60;
        System.out.println(minutes);
        hoursParked = hours;
        double min = minutes / 60.0;
        System.out.println(min);
        hoursParked += min;
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
        System.out.println(in);
        double back;
        double minutes = Double.parseDouble(in.substring(12));
        NumberFormat formatter = new DecimalFormat("#0.00");     
        //System.out.println(minutes);
        minutes = (minutes / 60);
        //System.out.println(minutes);
        String mins = formatter.format(minutes);
        //System.out.println(mins);
        String temp = in.substring(9,11)+""+mins.substring(1);
        System.out.println(temp);
        back = Double.parseDouble(temp);
        
        return back;
    }
}
