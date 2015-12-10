package fileService;

import fileFormat.Formatter;
import fileFormat.GarageTotalsFormat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zsummers
 */
public class FileService {
    private Formatter fmt;
    private String filePath;
    private TextFileReader reader;
    private TextFileWriter writer;

    public FileService(Formatter fmt, String filePath) {
        this.fmt = fmt;
        this.filePath = filePath;
        reader = new TextFileReader(fmt, filePath);
        writer = new TextFileWriter(fmt, filePath);
    }

    public void setFmt(Formatter fmt) {
        //needs validation
        this.fmt = fmt;
        reader.setFmt(fmt);
        writer.setFmt(fmt);
    }

    public void setFilePath(String filePath) {
        //needs validation
        this.filePath = filePath;
        reader.setFilePath(filePath);
        writer.setFilePath(filePath);
    }
    
    public void writeFile(Map<String, Object>[] toWrite) throws FileNotFoundException{
        writer.writeFile(toWrite);
    }
    
    public Map<String, Object>[] readFile() throws IOException{
        return reader.readFile();
    }
    
    public static void main(String[] args) {
        Formatter fmt = new GarageTotalsFormat();
        String path = "U:\\zsummers\\Documents\\NetBeansProjects\\TextFileService\\src\\format\\GarTotSample.txt";
        FileService fs = new FileService(fmt,path);
        Map<String, Object>[] temp = null;
        try {
            temp = fs.readFile();
        } catch (IOException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
        path = "U:\\zsummers\\Documents\\NetBeansProjects\\TextFileService\\src\\format\\writerText.txt";
        fs.setFilePath(path);
        try {
            fs.writeFile(temp);
            temp = fs.readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(fmt.encode(temp));
    }
    
}
