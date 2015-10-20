/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;



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
        
        OwnerOutStrategy own = new OwnerTotalFile();
//        own.update(2, 3.5);
//        own.update(1, 2.5);
        
        CustOutStrategy cust = new CustConsoleReceipt();
//        cust.output(101, 2, 4.5);
        
        FeeCalcStrategy fee = new MinMaxFeeCalc();
//        System.out.println(fee.getFee(3.1));
        
        CarOutTerm outTerm = new CarOutTerm(lot,own,cust,fee);
        inTerm.newCar();
        inTerm.newCar();
        inTerm.newCar();
        inTerm.newCar();
        outTerm.releaseCar(2.5, 1001);
        outTerm.releaseCar(5.18, 1002);
        outTerm.releaseCar(4.24, 1004);
        outTerm.releaseCar(3.91, 1003);
//        outTerm.releaseCar(1, 105);
//        System.out.println(lot.highCarId());
    }
}
