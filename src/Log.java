import java.io.FileWriter;
import java.io.IOException;

public class Log {

    private FileWriter fw;

    public Log () { }

    public void log(String fileName, String data) {
        try {
            fw = new FileWriter("C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\benchmarks\\" + fileName, true);
            data += "\n";
            fw.append(data);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Test file writing issue");
        } // end try catch
    }
}
