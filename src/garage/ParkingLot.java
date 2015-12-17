package garage;

import java.util.ArrayList;
import java.util.Date;

/**
 * A ParkingLot is a false-database class designed to store a collection of tickets,
 * as well as return information about the collection when asked to.
 * 
 * @author Zachary
 */
public class ParkingLot implements CarDataAccess{
    private ArrayList<Ticket> tickets;

    public ParkingLot() {
        this.tickets = new ArrayList<>();
    }
    
    /**
     * This method adds a car to the database with input ID and entry time
     * @param carId - this int will be used to identify the car later
     * @param timeIn - this Date will be used to calculate hours spent in the lot, then fees for parking
     */
    @Override
    public void addCar(int carId, Date timeIn)throws IndexOutOfBoundsException{
//        if(carId <= highCarId()){//a new car's ID must be greater than all previous IDs
//            throw new IndexOutOfBoundsException();
//        }
        Ticket c = new Ticket(carId,timeIn);
        tickets.add(c);
    }
    /**
     * This method will find a carId's entry time if it exists. If the far doesn't exits, it will return null
     * @param carId - this int will be checked against the carIds of all issued tickets
     * @return a Date, of the time the car's ticket was issued, or null if no ticket with input id was issued
     */
    @Override
    public Date getTimeIn(int carId){
        //this method will simply return null if the input carId isn't valid
        Date time = null;
        for(Ticket c: this.tickets){
            if(carId == c.getCarId()){
                time = c.getTimeIn();
            }
        }
        return time;
    }
    /**
     * This method will return the int carId of the highest carId on a ticket.
     * This is to help with retrieving the last car to enter, or to make new tickets have a different ID form old ones
     * @return the highest carID on all tickets, or 9 if there are no tickets
     */
    public int highCarId(){
        int back = 9;
        for(Ticket c: this.tickets){
            if(back <= c.getCarId()){
                back = c.getCarId();
            }
        }
        return back;
    }
}
