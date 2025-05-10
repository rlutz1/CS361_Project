import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Roxanne Lutz
 * this is for running benchmarks only.
 * the destination is hardcoded, so, obviously,
 * this will not run out the box on a different machine.
 * since this is not needed by the runner of the sorts,
 * this will be left as is upon submission.
 */
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
    } // end method
} // end class
