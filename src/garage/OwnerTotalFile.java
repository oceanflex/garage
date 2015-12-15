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
    
    
    @Override
    public void update(double HoursParked, double MoneyCollected) {
        //needs validation
        this.addHours(HoursParked);
        this.addMoney(MoneyCollected);
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
            Logger.getLogger(OwnerTotalFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
