package fileFormat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author zsummers
 */
public class GarageTotalsFormat implements Formatter{
    private static final String SEPARATOR = ": ";
    private static final String LINE = "\n";
    private static Formatter instance;

    @Override
    public Map<String, Object>[] decode(String data) {
        String[] in = data.split(LINE);
        Map<String, Object> back = new ConcurrentHashMap();
        back.put(GarageTotalsKeys.TIME.toString(), Double.parseDouble(in[0].substring(in[0].indexOf(SEPARATOR)
                +SEPARATOR.length())));
        back.put(GarageTotalsKeys.MONEY.toString(), Double.parseDouble(in[1].substring(in[1].indexOf(SEPARATOR)
                +SEPARATOR.length()+1)));
        back.put(GarageTotalsKeys.PARKED.toString(), Integer.parseInt(in[2].substring(in[2].indexOf(SEPARATOR)
                +SEPARATOR.length())));
        back.put(GarageTotalsKeys.PAYED.toString(), Integer.parseInt(in[3].substring(in[3].indexOf(SEPARATOR)
                +SEPARATOR.length())));
        Map<String, Object> out[];
        out = new Map[1];
        out[0] = back;
        return out;
    }

    @Override
    public String encode(Map<String, Object>[] data) {
        StringBuilder sb = new StringBuilder(GarageTotalsKeys.TIME.toString());
        sb.append(SEPARATOR);
        sb.append(data[0].get(GarageTotalsKeys.TIME.toString()));
        sb.append(LINE);
        sb.append(GarageTotalsKeys.MONEY.toString());
        sb.append(SEPARATOR);
        sb.append("$");
        sb.append(data[0].get(GarageTotalsKeys.MONEY.toString()));
        sb.append(LINE);
        sb.append(GarageTotalsKeys.PARKED.toString());
        sb.append(SEPARATOR);
        sb.append(data[0].get(GarageTotalsKeys.PARKED.toString()));
        sb.append(LINE);
        sb.append(GarageTotalsKeys.PAYED.toString());
        sb.append(SEPARATOR);
        sb.append(data[0].get(GarageTotalsKeys.PAYED.toString()));
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
