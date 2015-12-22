package garage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Zachary
 */
public class Startup {
    public static void main(String[] args) {
//        FileDate now = new FileDate();
//        System.out.println(now.todayIs());
//        System.out.println(now.timeIs());
        ParkingLot lot = new ParkingLot();
        CarInTerm inTerm = new CarInTerm(lot);
        
        OwnerOutStrategy own = null;
        try {
            own = new OwnerTotalFile();
//        own.update(2, 3.5);
//        own.update(1, 2.5);
        } catch (IOException ex) {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CustOutStrategy cust = new CustConsoleReceipt();
//        cust.output(101, 2, 4.5);
        
        FeeCalcStrategy fee = new MinMaxFeeCalc();
//        System.out.println(fee.getFee(3.1));
        
        CarOutTerm outTerm = new CarOutTerm(lot,own,cust,fee);
        inTerm.newCar(); //will make a new car entry with starting time of now
//        inTerm.newCar(0.25);//will make a new entry with starting time of 15 minutes ago
//        inTerm.newCar(3.1);
//        inTerm.newCar(6);//make new entry with starting time 6 hours ago
//        inTerm.newCar(11);
        inTerm.newCar();
        inTerm.newCar();
        inTerm.newCar();
        outTerm.releaseCar(1001,true);//will release the first car
        outTerm.releaseCar(1002,true);
        outTerm.releaseCar(1003,true);
        outTerm.releaseCar(1004,true);
//        outTerm.releaseCar(1, 105);
//        System.out.println(lot.highCarId());
    }
}
