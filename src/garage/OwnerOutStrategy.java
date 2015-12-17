package garage;

/**
 *OwnerOutputStrategies need to keep track of, and display to the owner, a record
 * of hours cars parked, as well as money collected by the system. 
 * @author Zachary
 */
public interface OwnerOutStrategy {
    public void update(double HoursParked, double MoneyCollected);
}
