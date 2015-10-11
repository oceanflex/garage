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
public class MinMaxFeeCalc implements FeeCalcStrategy{
    private double feeMin = 2;
    private double feeMax = 10;
    private double feeHourly = 0.5;
    private double hoursBase = 3;

    @Override
    public double getFee(double hoursParked) {
        if(hoursParked < hoursBase){
            hoursParked = hoursBase;
        }
        double feeActual = feeHourly * (hoursParked - hoursBase);
        double out = feeActual + feeMin;
        if(feeActual > feeMax){
            out = feeMax;
        }
        return out;
    }
    
}
