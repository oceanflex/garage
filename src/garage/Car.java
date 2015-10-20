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
public class Car {
    private int carId;
    private Date timeIn;

    public Car(int carId, Date timeIn) {
        this.carId = carId;
        this.timeIn = timeIn;
    }

    public int getCarId() {
        return carId;
    }

    public Date getTimeIn() {
        return timeIn;
    }
    
    
}
