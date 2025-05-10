import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Roxanne Lutz
 * class to facilitate the randomized generation of
 * large test case files.
 * This ended up being very clunky when running
 * actual large benchmarks, so was not used for the actual
 * numbers provided.
 * left for reference of dev only.
 */

public class TestCaseGenerator {

    private String testFolder = "tests\\";
    private short[] testDataInt;
    private double[] testDataDouble;

    public TestCaseGenerator() {}

    /**
     * main method to generate a new test case.
     * this is for use by roxanne lutz to whip up test
     * cases as the need arises.
     * @param howMany
     * @param lowerBound
     * @param upperBound
     * @param fileName
     */
    public void generateDoubles(int howMany,
                             int lowerBound,
                             int upperBound,
                             String fileName) {
        unsortedDataDouble(howMany, lowerBound, upperBound);
        File testFile = new File(testFolder + fileName);
        try {
            if (testFile.exists()) {
                testFile.delete();
            }
            testFile.createNewFile();
            writeDoubleDataToFile(testFile);
        } catch (IOException e) {
            throw new RuntimeException("Test file creation issue");
        } // end try/catch
    } // end method

    /**
     * main method to generate a new test case.
     * this is for use by roxanne lutz to whip up test
     * cases as the need arises.
     */
    public void generateInts(int howMany,
                         int lowerBound,
                         int upperBound,
                         boolean sorted,
                         String fileName) {
        if (sorted) {
            testDataInt = sortedDataInt(howMany, (short)lowerBound);
        } else {
            testDataInt = unsortedDataInt(howMany, lowerBound, upperBound);
        } // end if

        File testFile = new File(testFolder + fileName);
        try {
            if (testFile.exists()) {
                testFile.delete();
            }
            testFile.createNewFile();
            writeIntDataToFile(testFile);
        } catch (IOException e) {
            throw new RuntimeException("Test file creation issue");
        } // end try/catch
    } // end method


    /**
     * generate a CSV list of numbers as a txt file to use as input for
     * sorting testing.
     * @param newFile
     */
    private void writeDoubleDataToFile(File newFile) {
        try {
            FileWriter fw = new FileWriter(newFile);

            String toAdd;
            for (int i = 0; i < testDataDouble.length; i++) {
                toAdd = (i == testDataDouble.length - 1) ? testDataDouble[i] + "" : testDataDouble[i] + ",";
                fw.append(toAdd);
            } // end loop
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Test file writing issue");
        } // end try catch

    } // end method

    /**
     * generate a CSV list of numbers as a txt file to use as input for
     * sorting testing.
     * @param newFile
     */
    private void writeIntDataToFile(File newFile) {
        try {
            FileWriter fw = new FileWriter(newFile);

            String toAdd;
            for (int i = 0; i < testDataInt.length; i++) {
                toAdd = (i == testDataInt.length - 1) ? testDataInt[i] + "" : testDataInt[i] + ",";
                fw.append(toAdd);
            } // end loop
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Test file writing issue");
        } // end try catch

    } // end method


    /**
     * generate random data to be sorted.
     * @param howMany how many total numbers
     * @param lowerBound the lowest number i want
     * @param upperBound the highest number i want
     * @return a list of unsorted ints
     */
    private void unsortedDataDouble (int howMany, int lowerBound, int upperBound) {
        Random rand = new Random();

        testDataDouble = new double[howMany];

        double next;

        for (int i = 0; i < howMany; i++) {
            next = rand.nextDouble(lowerBound, upperBound + 1);
            testDataDouble[i] = Math.round((next * 100.0)) / 100.0; // 2 decimal places
        } // end loop
    } // end method




    /**
     * generate random data to be sorted.
     * @param howMany how many total numbers
     * @param lowerBound the lowest number i want
     * @param upperBound the highest number i want
     * @return a list of unsorted ints
     */
    private short[] unsortedDataInt (int howMany, int lowerBound, int upperBound) {
        Random rand = new Random();

        short[] data = new short[howMany]; // todo, separate this out, stupid java

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
    private short[] sortedDataInt (int howMany, short start) {
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
    public void print(boolean doubles) {
        if (doubles) {
            for (double num : testDataDouble) {
                System.out.print(num + " ");
            } // end loop
        } else {
            for (int num : testDataInt) {
                System.out.print(num + " ");
            } // end loop
        } // end if else

    } // end method

} // end class
