package fileFormat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author zsummers
 */
public class GarageTotalsFormat implements Formatter{
    private static final String TIME = "Hours Parked";
    private static final String MONEY = "Dollars Collected";
    private static final String VEHICLES_PARKED = "Vehicles in Lot";
    private static final String VEHICLES_PAYED = "Vehicles that Exited";
    private static final String SEPARATOR = ": ";
    private static final String LINE = "\n";
    private static Formatter instance;

    @Override
    public Map<String, Object>[] decode(String data) {
        String[] in = data.split(LINE);
        Map<String, Object> back = new ConcurrentHashMap();
        back.put(TIME, in[0].substring(in[0].indexOf(SEPARATOR)
                +SEPARATOR.length()));
        back.put(MONEY, in[1].substring(in[1].indexOf(SEPARATOR)
                +SEPARATOR.length()+1));
        back.put(VEHICLES_PARKED, in[2].substring(in[2].indexOf(SEPARATOR)
                +SEPARATOR.length()));
        back.put(VEHICLES_PAYED, in[3].substring(in[3].indexOf(SEPARATOR)
                +SEPARATOR.length()));
        Map<String, Object> out[];
        out = new Map[1];
        out[0] = back;
        return out;
    }

    @Override
    public String encode(Map<String, Object>[] data) {
        StringBuilder sb = new StringBuilder(TIME);
        sb.append(SEPARATOR);
        sb.append(data[0].get(TIME));
        sb.append(LINE);
        sb.append(MONEY);
        sb.append(SEPARATOR);
        sb.append("$");
        sb.append(data[0].get(MONEY));
        sb.append(LINE);
        sb.append(VEHICLES_PARKED);
        sb.append(SEPARATOR);
        sb.append(data[0].get(VEHICLES_PARKED));
        sb.append(LINE);
        sb.append(VEHICLES_PAYED);
        sb.append(SEPARATOR);
        sb.append(data[0].get(VEHICLES_PAYED));
        sb.append(LINE);
        return sb.toString();
    }
    
//    public static void main(String[] args) {
//        Formatter fmt = new GarageTotalsFormat();
//        Map<String, Object>[] temp = fmt.decode("Hours Parked: 21.25\n" +
//            "Dollars Collected: $63.55\n" +
//            "Vehicles in lot: 3\n" +
//            "Vehicles that exited: 7\n" +
//            "");
//        System.out.println(fmt.encode(temp));
//    }
    
}
