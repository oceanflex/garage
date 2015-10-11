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
public class MinNoMaxFeeCalc implements FeeCalcStrategy{
    private double feeMin = 1.5;
    private double feeHourly = 0.75;
    private double hoursBase = 2;

    @Override
    public double getFee(double hoursParked) {
        if(hoursParked < hoursBase){
            hoursParked = hoursBase;
        }//this is error handling, it makes sure I don't multiply by negative
        if(hoursParked > ((int)hoursParked * 1.0)){
            hoursParked = (int)hoursParked + 1;
        }//this ensures that any part of an hour counts as an hour.
        double feeActual = feeHourly * (hoursParked - hoursBase);
        //if hoursParked are less than hoursBase, feeActual will be 0
        double out = feeActual + feeMin;
        //feeMin = 0+feeMin, or feeMin = feeActual + feeMin
        return out;
    }
    
}
