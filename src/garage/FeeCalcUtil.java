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
public class FeeCalcUtil {
    
    public static double checkAndRound(double hours, double hoursBase){
        double temp = FeeCalcUtil.checkMin(hours,hoursBase);
        double out = FeeCalcUtil.roundUp(temp);
        return out;
    }
    
    public static double checkMin(double hours, double hoursBase){
        double checked = hours;
        if(hours < hoursBase){
            checked = hoursBase;
        }//this is error handling, it makes sure I don't multiply by negative
        return checked;
    }
    
    public static double roundUp(double toRound){
        double rounded = toRound;
        if(toRound > ((int)toRound * 1.0)){
            rounded = (int)toRound + 1;
        }//this ensures that any part of an hour counts as an hour.
        return rounded;
    }
}
