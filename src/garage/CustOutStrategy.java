package garage;

/**
 *a CustOutStrategy needs to be capable of 
 * @author Zachary
 */
public interface CustOutStrategy {
    public void output(int carId, double hoursParked, double moneyCharged);
}
