/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Zachary
 */
public class FileDate {
    private final DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
    private final DateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private Date date;
    private String today;
    private String now;
        
    public String nowIs(){
        date = new Date();
        now = timeFormat.format(date);
        return now;
    }
    
    public String todayIs(){
        date = new Date();
        today = dateFormat.format(date);
        return today;
    }
        
}
