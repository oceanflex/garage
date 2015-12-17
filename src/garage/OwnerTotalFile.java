/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import fileFormat.GarageTotalsFormat;
import fileFormat.GarageTotalsKeys;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.NumberFormat;
import fileService.FileService;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Zachary
 */
public class OwnerTotalFile implements OwnerOutStrategy{
    //rt is running total
    private static final String GARAGE_NAME = "Best Value Parking Garage";
    private static final NumberFormat money = NumberFormat.getCurrencyInstance();
    private double rtHours;
    private double rtMoney;
    private int rtPayed;
    private Map[] file;
    //private PrintWriter writer;
    private FileService service;

    private void addHours(double hours) {
        this.rtHours += hours;
    }

    private void addMoney(double money) {
        this.rtMoney += money;
    }

    private void startupReadIn() throws IOException{
        file = service.readFile();
        rtMoney = (double) file[0].get(GarageTotalsKeys.MONEY.toString());
        rtHours = (double) file[0].get(GarageTotalsKeys.TIME.toString());
        rtPayed = (int) file[0].get(GarageTotalsKeys.PAYED.toString());
    }
    
    private void writeUpdate() throws FileNotFoundException{
        file[0].put(GarageTotalsKeys.MONEY.toString(), rtMoney);
        file[0].put(GarageTotalsKeys.TIME.toString(), rtHours);
        file[0].put(GarageTotalsKeys.PAYED.toString(), ++rtPayed);
        service.writeFile(file);
    }
    /**
     * The default constructer of a OwnerTotalFile. It will create a FileService to keep a file in the src/yy mm dd Totals.txt path,
     * using the GarageTotalsFormat to access the data. It will then try to read starting data in from the FileService, in case the
     * program already processed cars today. Failing that, it will populate itself and the file with default values, found in src/fileFormat/GarToSample.txt
     * @throws IOException for any other IOException than FileNotFound, we'll let the calling class deal with.
     */
    public OwnerTotalFile() throws IOException {
        service = new FileService(new GarageTotalsFormat(),(FileDate.todayIs()+" Totals.txt"));
        try {
            startupReadIn();
        } catch (FileNotFoundException ex) {
            FileService temp = new FileService(new GarageTotalsFormat(),"src"+File.separator+"fileFormat"+File.separator+"GarTotSample.txt");
            service.writeFile(temp.readFile());//need to create a basic file to write if there is no file for FileDate.todayIs();
            startupReadIn();
        }
    }
    
    /**
     * This method is designed to update the program's internal running totals for cars processed,
     * hours they parked, and money the program collected, as well save all of that to a file.
     * Any call of this method will increase the count of cars processed by one, or decrease it by one if either parameter is 0 or less.
     * @param hoursParked - will be added to the running total hours of cars parked, then the total will be saved to file.
     * @param moneyCollected - will be added to the running total of money collected from cars parking, then the total will be saved to file.
     */
    @Override
    public void update(double hoursParked, double moneyCollected) {
        //negative numbers and any other exception I can think of should would without issue
        //and should be a tool a developer is allowed to use, for fixing sync issues, etc
        if(hoursParked<=0||moneyCollected<=0){//but I will reduce the number of exit transactions if one is negative
            file[0].put(GarageTotalsKeys.PAYED.toString(), rtPayed - 2);
        }
        this.addHours(hoursParked);
        this.addMoney(moneyCollected);
        try {
            writeUpdate();
//        try {
//            writer = new PrintWriter((FileDate.todayIs()+" Totals.txt"));
//            writer.println(GARAGE_NAME+" daily totals\n Hours Charged: "+rtHours+
//                    " Money Collected: "+money.format(rtMoney));
//            writer.close();ndException ex) {
//            Logger.getLogger(OwnerTotalFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (FileNotFoundException ex) {
            //fileNotFound shouldn't be thrown by writing here, the constructor makes the file
            Logger.getLogger(OwnerTotalFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
