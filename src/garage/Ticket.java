package garage;

import java.util.Date;

/**
 * A ticket is a data type that will store an identifying int, and a Date. 
 * Once set, the attributes can't be changed, but can only be retrieved
 * @author Zachary
 */
public class Ticket {
    private final int carId;
    private final Date timeIn;
/**
 * Ticket constructor needs an int to identify the ticket by, and a Date to store useful data about the ticket in
 * @param carId - this will identify the ticket
 * @param timeIn - this will store a date, to be used when the ticket is identified by id
 */
    public Ticket(int carId, Date timeIn) {
        //validation can't reasonably happen here, because it's up to other classes to create a system for
        //how to use a Ticket. Tickets store data, they don't care what it is
        this.carId = carId;
        this.timeIn = timeIn;
    }
/**
 * this method returns the int given to the ticket on creation
 * @return an int given to the ticket on construction
 */
    public int getCarId() {
        return carId;
    }
/**
 * this method returns the Date given to the ticket on creation
 * @return a Date given to the ticket on construction
 */
    public Date getTimeIn() {
        return timeIn;
    }
    
    
}
