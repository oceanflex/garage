package fileFormat;

import java.util.Map;

/**
 *
 * @author zsummers
 */
public interface Formatter {
    public Map<String, Object>[] decode(String data);
    
    public String encode(Map<String, Object>[] data);
}
