package fileService;

import fileFormat.Formatter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *The FileWriter is designed to take an input array of maps, ask the formatter
 * to encode the data into a string, then write the string to the spesified filePath
 * @author zsummers
 */
public class TextFileWriter {
    private Formatter fmt;
    private String filePath;
/**
 * TextFileReader allways needs to know how to encode ans where to write data to
 * @param fmt the format for encoding
 * @param filePath the path to write the data to
 */
    public TextFileWriter(Formatter fmt, String filePath) {
        this.fmt = fmt;
        this.filePath = filePath;
    }
/**
 * if the encoder format ever needs to be changed, this method can alter it
 * @param fmt the new format to be used
 */
    public void setFmt(Formatter fmt) {
        //needs validation
        this.fmt = fmt;
    }
/**
 * if the location to write the data to changes, this method will set it
 * @param filePath - the new path to write the file to
 */
    public void setFilePath(String filePath) {
        //needs validation
        this.filePath = filePath;
    }
    /**
     * this is the method that actually will write the data to the file, after
     * having the formatter encode the data
     * @param toWrite - the data, in a map of arrays, with strings as keys, formatted as spesified by the formatter
     * @throws FileNotFoundException if the filePath's directories don't exist
     */
    public void writeFile(Map<String, Object>[] toWrite) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(filePath);
        try {
            writer.print(fmt.encode(toWrite));
        }finally{
            writer.close();
        }
        
    }
}
