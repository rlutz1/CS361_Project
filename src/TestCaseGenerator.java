import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Roxanne Lutz
 * class to facilitate the randomized generation of
 * large test case files.
 */

public class TestCaseGenerator {

    private String testFolder = "tests\\";
    private short[] testData;

    public TestCaseGenerator() {}

    /**
     * main method to generate a new test case.
     * this is for use by roxanne lutz to whip up test
     * cases as the need arises.
     * @param howMany
     * @param lowerBound
     * @param upperBound
     * @param sorted
     * @param fileName
     */
    public void generate(int howMany,
                         int lowerBound,
                         int upperBound,
                         boolean sorted,
                         String fileName) {

//        int pow2 = howMany / ((int) Math.pow(2, 10)) % ((int) Math.pow(2, 10));
//        System.out.println(pow2);


        if (sorted) {
            testData = sortedData(howMany, (short)lowerBound);
        } else {
            testData = unsortedData(howMany, lowerBound, upperBound);
        } // end if

        File testFile = new File(testFolder + fileName);
        try {
            if (testFile.exists()) {
                testFile.delete();
            }
            testFile.createNewFile();
            writeDataToFile(testFile);
        } catch (IOException e) {
            throw new RuntimeException("Test file creation issue");
        } // end try/catch

    } // end method

    /**
     * generate a CSV list of numbers as a txt file to use as input for
     * sorting testing.
     * @param newFile
     */
    private void writeDataToFile(File newFile) {
        try {
            FileWriter fw = new FileWriter(newFile);

            String toAdd;
            for (int i = 0; i < testData.length; i++) {
                toAdd = (i == testData.length - 1) ? testData[i] + "" : testData[i] + ",";
                fw.append(toAdd);
            } // end loop
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Test file writing issue");
        } // end try catch

    }

    /**
     * generate random data to be sorted.
     * @param howMany how many total numbers
     * @param lowerBound the lowest number i want
     * @param upperBound the highest number i want
     * @return a list of unsorted ints
     */
    private short[] unsortedData (int howMany, int lowerBound, int upperBound) {
        Random rand = new Random();

        short[] data = new short[howMany];

        for (int i = 0; i < howMany; i++) {
            data[i] = (short)rand.nextInt(lowerBound, upperBound + 1);
        } // end loop

        return data;
    } // end method

    /**
     * generate a sorted list for testing purposes.
     * @param howMany how many total numbers
     * @param start the lowest number i want, will add to list until limit reached.
     *              upper bound given to generate is ignored.
     * @return list of sorted ints
     */
    private short[] sortedData (int howMany, short start) {
        short[] data = new short[howMany];
        short counter = start;

        for (int i = 0; i < howMany; i++) {
            data[i] = counter; counter++;
        } // end loop

        return data;
    } // end method

    /**
     * simple print function for testing purposes.
     */
    public void print() {
        for (int num : testData) {
            System.out.print(num + " ");
        } // end loop
    } // end method

} // end class
