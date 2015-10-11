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
public interface CustOutStrategy {
    public void output(int carId, double hoursParked, double moneyCharged);
}
