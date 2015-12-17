package garage;

/**
 *This FeeCalcStrategy will insure that any fee calculated will be at least 2, and and most 10
 * @author Zachary
 */
public class MinMaxFeeCalc implements FeeCalcStrategy{
    private double feeMin = 2;
    private double feeMax = 10;
    private double feeHourly = 0.5;
    private double hoursBase = 3;
/**
 * This will return the fee for a car parking input hours
 * @param hoursParked this will be used to calculate hours for fee to be multiplied against, unless it is too low or high
 * @return a double that represents the fee due
 */
    @Override
    public double getFee(double hoursParked) {
        //hoursParked is validated in checkMin
        hoursParked = FeeCalcUtil.checkAndRound(hoursParked,hoursBase);
        double feeActual = feeHourly * (hoursParked - hoursBase);
        double out = feeActual + feeMin;
        if(feeActual > feeMax){
            out = feeMax;
        }
        return out;
    }
    private double checkAndRound(double hours){
        double temp = FeeCalcUtil.checkMin(hours,hoursBase);
        double out = FeeCalcUtil.roundUp(temp);
        return out;
    }
}
