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
        //hoursParked is validated in checkMin
        hoursParked = this.checkAndRound(hoursParked);
        double feeActual = feeHourly * (hoursParked - hoursBase);
        double out = feeActual + feeMin;
        if(feeActual > feeMax){
            out = feeMax;
        }
        return out;
    }
    private double checkAndRound(double hours){
        double temp = this.checkMin(hours);
        double out = this.roundUp(temp);
        return out;
    }
    
    private double checkMin(double toCheck){
        double checked = toCheck;
        if(toCheck < hoursBase){
            checked = hoursBase;
        }//this is error handling, it makes sure I don't multiply by negative
        return checked;
    }
    
    private double roundUp(double toRound){
        double rounded = toRound;
        if(toRound > ((int)toRound * 1.0)){
            rounded = (int)toRound + 1;
        }//this ensures that any part of an hour counts as an hour.
        return rounded;
    }
}
