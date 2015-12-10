/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.Date;

/**
 *
 * @author Zachary
 */
public class ParkingLot implements CarDataAccess{
    private Ticket[] tickets = {};
    
    private void addCar(Ticket c){
        Ticket[] temp = new Ticket[tickets.length+1];
        System.arraycopy(tickets, 0, temp, 0, tickets.length);
        temp[temp.length-1] = c;
        tickets = temp;
    }
    
    @Override
    public void addCar(int carId, Date timeIn){
        Ticket c = new Ticket(carId,timeIn);
        this.addCar(c);
    }
    
    @Override
    public Date getTimeIn(int carId){
        Date time = null;
        for(Ticket c: this.tickets){
            if(carId == c.getCarId()){
                time = c.getTimeIn();
            }
        }
        return time;
    }
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
