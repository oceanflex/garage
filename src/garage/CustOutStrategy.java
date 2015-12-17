package garage;

/**
 *a CustOutStrategy needs to be capable of displaying a carId, the hoursParked 
 * and moneyCharged to a customer when called
 * @author Zachary
 */
public interface CustOutStrategy {
    public void output(int carId, double hoursParked, double moneyCharged);
}
