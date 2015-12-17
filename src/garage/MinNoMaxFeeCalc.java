package garage;

/**
 *This FeeCalcStrategy will charge for at least two hours, with no limit of hours
 * at $0.75 each hour
 * @author Zachary
 */
public class MinNoMaxFeeCalc implements FeeCalcStrategy{
    private double feeMin = 1.5;
    private double feeHourly = 0.75;
    private double hoursBase = 2;
/**
 * This method will calculate the fee for a that spent input hours in the lot
 * @param hoursParked - used to determine total feel, based on fee per hour. If this is lower than the min, the min is used instead
 * @return - returns the fee to be paid as a double
 */
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
