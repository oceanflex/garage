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
    private ParkingLot lot;
    
    public CarInTerm(ParkingLot lot){
        this.lot = lot;
    }
    
    public void newCar(){
        this.carId++;
        int newCarId = this.carId;
        Date time = new Date();
        lot.addCar(newCarId, time);
    }
}
