package garage;
import java.util.Date;

/**
 *The CarInTerm is a first point of contact with the system. It will define the
 * carIds that the program will use, and assign them to tickets per request.
 * It will also call on the CarDataAccess to record all transactions it preforms
 * for use by the other classes in the system.
 * @author Zachary
 */
public class CarInTerm {
    private int carId = 1000;
    private final CarDataAccess lot;
    /**
     * The CarInTerm constructor needs access to a data structure to communicate
     * with the other classes.
     * @param lot - this is the CarDataAccess that the program should refer to
     */
    public CarInTerm(CarDataAccess lot){
        this.lot = lot;
    }
    /**
     * This is the default use method of the class. When prompted, it will generate
     * a ticket for the database to store.
     */
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
