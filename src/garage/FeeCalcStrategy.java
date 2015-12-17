package garage;

/**
 *A FeeCalcStrategy needs to store a value to be charged per hourParked,
 * and multiply it by an input double when getFee is called
 * @author Zachary
 */
public interface FeeCalcStrategy {
    public double getFee(double hoursParked);
}
