package garage;

import java.util.Date;

/**
 * a CarDataAess needs to be capable of storing car ticket data, and recalling
 * Date objects associated with each carId
 * @author Zachary
 */
public interface CarDataAccess {
    public void addCar(int carId, Date timeIn);
    public Date getTimeIn(int carId);
}
