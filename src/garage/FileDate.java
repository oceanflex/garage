package garage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *This is a utility class that will supply Dates for the program to use
 * @author Zachary
 */
public class FileDate {
    private static final DateFormat dateFormat = new SimpleDateFormat("yy.MM.dd");
    private static final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private static Date date;
    private static String day;
    private static String time;
/**
 * This will return a useful string representation of the time when the method is called
 * @return a string representation of the call time, in format HH:mm
 */
    public static String timeIs(){
        date = new Date();
        time = timeFormat.format(date);
        return time;
    }
    /**
     * like timeIs, this will return a useful string representation of the time,
     * but this method transforms an input time
     * @param date the time to be transformed into a string
     * @return returns a string in the format of HH:mm
     */
    public static String timeOf(Date date){
        time = timeFormat.format(date);
        return time;
    }
    /**
     * Will return a useful representation of input date
     * @param date - the date to be transformed into a string
     * @return a string representation of the input date, in the format yy.mm.dd
     */
    public static String dayOf(Date date){
        day = dateFormat.format(date);
        return day;
    }
    /**
     * will find the date(that the method is called on), and return a useful string representation
     * @return a string representation of the date, in the format yy.mm.dd
     */
    public static String todayIs(){
        date = new Date();
        day = dateFormat.format(date);
        return day;
    }
        
}
