package fileService;

import fileFormat.Formatter;
//import format.GarageTotalsFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author zsummers
 */
public class TextFileReader {
    private Formatter fmt;
    private String filePath;

    public TextFileReader(Formatter fmt, String filePath) {
        this.fmt = fmt;
        this.filePath = filePath;
    }

    public void setFmt(Formatter fmt) {
        //needs validation
        this.fmt = fmt;
    }

    public void setFilePath(String filePath) {
        //needs validation
        this.filePath = filePath;
    }
    
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
