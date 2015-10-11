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

    @Override
    public double getFee(double hoursParked) {
        double feeActual = feeHourly * hoursParked;
        double out;
        if(feeActual < feeMin){
            out = feeMin;
        }else{
            out = feeActual;
        }
        return out;
    }
    
}
