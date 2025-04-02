import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tim sort: Tim sort is a hybrid sorting algorithm derived from merge sort
 * and insertion sort, designed to perform well on real-world data. It is the
 * default sorting algorithm in Python, Java, and Android
 * todo:
 *
 */

public class TimSort {

    private short[] toSort = null;

    /**
     * simple print function for testing purposes.
     */
    public void print(boolean printNums) {
        if (printNums) {
            for (int num : toSort) {
                System.out.print(num + " ");
            } // end loop
        } // end if

        System.out.println("Found " + toSort.length + " numbers.");
    } // end method

    /**
     * method common to all sort classes to read in a test case file
     * from basic java io operations.
     * @param path file path given, will be ultimately from the command line/from driver
     *             note that the test cases are all given as csv format
     */
    public void initArray(String path, int howMany) {
        toSort = new short[howMany]; int counter = 0;
        try {
            Scanner s = new Scanner(new File(path)).useDelimiter(",");
            while (s.hasNext()) {
                toSort[counter] = s.nextShort(); counter++;
            } // end loop
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Oops, no file there. Love, mergesort.");
        } // end try/catch

    } // end method


    /**
     * simple ascending list checker to run for testing purposes on
     * large data sets. to make my life eaiser :)
     * @return if the list has been sorted
     */
    public boolean isSorted() {
        int i = 0, j = 1;

        while (j < toSort.length) {
            if (toSort[i] > toSort[j]) {
                return false;
            } // end if
            i++; j++;
        } // end loop

        return true;
    } // end method
}
