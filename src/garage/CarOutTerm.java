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
        fee = feeCalc.getFee(hoursParked);
        own.update(hoursParked, fee);
        cust.output(carId, hoursParked, fee);
    }
}
