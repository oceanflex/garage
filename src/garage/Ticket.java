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
public class Ticket {
    private final int carId;
    private final Date timeIn;

    public Ticket(int carId, Date timeIn) {
        //needs validation
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
