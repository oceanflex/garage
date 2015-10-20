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
public class ParkingLot {
    private Car[] cars = {};
    
    private void addCar(Car c){
        Car[] temp = new Car[cars.length+1];
        System.arraycopy(cars, 0, temp, 0, cars.length);
        temp[temp.length-1] = c;
        cars = temp;
    }
    
    public void addCar(int carId, Date timeIn){
        Car c = new Car(carId,timeIn);
        this.addCar(c);
    }
    
    public Date timeIn(int carId){
        Date time = null;
        for(Car c: this.cars){
            if(carId == c.getCarId()){
                time = c.getTimeIn();
            }
        }
        return time;
    }
}
