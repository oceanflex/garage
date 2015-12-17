package fileService;

import fileFormat.Formatter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
/**
 *The FileService class is designed to give flexable access to text files of any format.
 * It will report back with an array of maps, in a format spesified by the fileFormat given.
 * @author zsummers
 */
public class FileService {
    private Formatter fmt;
    private String filePath;
    private TextFileReader reader;
    private TextFileWriter writer;
/**
 * The FileService needs to know what file to access, and how to translate the data
 * @param fmt - this is a format for data translation form a read file
 * @param filePath - this is the path where the file can be accessed
 */
    public FileService(Formatter fmt, String filePath) {
        this.fmt = fmt;
        this.filePath = filePath;
        reader = new TextFileReader(fmt, filePath);
        writer = new TextFileWriter(fmt, filePath);
    }
/**
 * If the service needs to translate a different format, the format can be changed
 * @param fmt - this is the format the the service will use
 */
    public void setFmt(Formatter fmt) {
        //needs validation
        this.fmt = fmt;
        reader.setFmt(fmt);
        writer.setFmt(fmt);
    }
/**
 * If the service ever needs to access a different file, the location can be changed with this method.
 * @param filePath - this string is the filePath that the service should use
 */
    public void setFilePath(String filePath) {
        //needs validation
        this.filePath = filePath;
        reader.setFilePath(filePath);
        writer.setFilePath(filePath);
    }
    /**
     * This will write the data that is formatted properly to the file
     * @param toWrite if the data is in a array of maps, and formatted in the same was as it was read in, it will be written to the file
     * @throws FileNotFoundException if the file directory is not set up.
     */
    public void writeFile(Map<String, Object>[] toWrite) throws FileNotFoundException{
        writer.writeFile(toWrite);
    }
    /**
     * This will read in the file, returning an array of maps according to the
     * decoding instructions of the formatter, from the defined filePath.
     * @return this will return a Map[] according to the instructions of the formatter
     * @throws IOException if the file is not found
     */
    public Map<String, Object>[] readFile() throws IOException{
        return reader.readFile();
    }
    
//    public static void main(String[] args) {
//        Formatter fmt = new GarageTotalsFormat();
//        String path = "U:\\zsummers\\Documents\\NetBeansProjects\\TextFileService\\src\\format\\GarTotSample.txt";
//        FileService fs = new FileService(fmt,path);
//        Map<String, Object>[] temp = null;
//        try {
//            temp = fs.readFile();
//        } catch (IOException ex) {
//            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        path = "U:\\zsummers\\Documents\\NetBeansProjects\\TextFileService\\src\\format\\writerText.txt";
//        fs.setFilePath(path);
//        try {
//            fs.writeFile(temp);
//            temp = fs.readFile();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(fmt.encode(temp));
//    }
//    
}
