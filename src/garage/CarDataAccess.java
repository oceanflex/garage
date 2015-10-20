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
public interface CarDataAccess {
    public void addCar(int carId, Date timeIn);
    public Date getTimeIn(int carId);
}
