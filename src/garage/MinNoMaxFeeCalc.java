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
        //horusParked is validated in checkMin
        hoursParked = FeeCalcUtil.checkAndRound(hoursParked,hoursBase);
        double feeActual = feeHourly * (hoursParked - hoursBase);
        //if hoursParked are less than hoursBase, feeActual will be 0
        double out = feeActual + feeMin;
        //feeMin = 0+feeMin, or feeMin = feeActual + feeMin
        return out;
    }
    
    private double checkAndRound(double hours){
        double temp = FeeCalcUtil.checkMin(hours,hoursBase);
        double out = FeeCalcUtil.roundUp(temp);
        return out;
    }
    
}
