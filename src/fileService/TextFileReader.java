package fileService;

import fileFormat.Formatter;
//import format.GarageTotalsFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *The FileReader is designed to read a file, ask the formatter to decode it,
 * then return an array of maps to the service
 * @author zsummers
 */
public class TextFileReader {
    private Formatter fmt;
    private String filePath;
/**
 * the TextFileReader allways needs a format and a filePath
 * @param fmt the format for decoding files
 * @param filePath the path for reading the file from
 */
    public TextFileReader(Formatter fmt, String filePath) {
        this.fmt = fmt;
        this.filePath = filePath;
    }
/**
 * if the format needed to decode file data changes, this can be used to adjust it
 * @param fmt the new format for reading files
 */
    public void setFmt(Formatter fmt) {
        //needs validation
        this.fmt = fmt;
    }
/**
 * If the file that needs reading changes, this method can adjust it
 * @param filePath the path to find the new file
 */
    public void setFilePath(String filePath) {
        //needs validation
        this.filePath = filePath;
    }
    /**
     * this method actually reads the file in, and decodes it
     * @return a Map[] with strings as keys, as defined by the formatter
     * @throws IOException if the file isn't found
     */
    public Map<String, Object>[] readFile() throws IOException{
        File data = new File(filePath);
        BufferedReader in;
        StringBuilder sb = new StringBuilder("");
        try{
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            sb = new StringBuilder(line);
            while(line != null){
                sb.append("\n");
                line = in.readLine();
                sb.append(line);
            }
        }catch(IOException ie){
            throw ie;
        }
        Map<String, Object>[] back = fmt.decode(sb.toString());
        return back;
    }
    
//    public static void main(String[] args) throws IOException {
//        GarageTotalsFormat fmt = new GarageTotalsFormat();
//        TextFileReader read = new TextFileReader(fmt,"C:\\Users\\Zachary\\Documents\\NetBeansProjects\\FileService\\src\\format\\GarTotSample.txt");
//        Map<String, Object>[] temp = read.readFile();
//        System.out.println(fmt.encode(temp));
//    }
    
}
