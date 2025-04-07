package IntSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sorting using a quad heap: You will be implementing a modified heap
 * called a quad-heap, which is a degree 4 tree that is filled on all levels
 * except the very last, that is filled from left to right
 * todo:
 *
 */

public class QuadHeapSort {

    /*
     * =============================================================
     * GLOBALS/CONSTANTS
     * =============================================================
     */


    private short[] toSort = null;


    /*
     * =============================================================
     * CONSTRUCTORS
     * =============================================================
     */

    public QuadHeapSort() { } // end constructor


    /*
     * =============================================================
     * HELPER METHODS
     * =============================================================
     */

// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -27 out of bounds for length 1073741824
    public void sort(int size) {
//        int size = toSort.length;

        for (int i = (size - 2) / 4; i >= 0; i--) {
            maxHeapify(i, size);
        } // end loop

        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            maxHeapify(0, i);
        } // end loop
    } // end method


    public void maxHeapify(int start, int end) {
        if (start < (int) Math.pow(2,28)) { // limit to note
            int child1 = 4 * start + 1;
            int child2 = 4 * start + 2;
            int child3 = 4 * start + 3;
            int child4 = 4 * start + 4;
            int max = start;

            if (child1 < end && toSort[child1] > toSort[max]) { // todo iterative loop
                max = child1;
            }

            if (child2 < end && toSort[child2] > toSort[max]) {
                max = child2;
            }

            if (child3 < end && toSort[child3] > toSort[max]) {
                max = child3;
            }

            if (child4 < end && toSort[child4] > toSort[max]) {
                max = child4;
            }

            if (max != start) {
                swap(start, max);
                maxHeapify(max, end);
            }
        }

    }

    /**
     * general method to swap something in our list.
     * common logic.
     * @param x item to swap
     * @param y item to swap
     */
    private void swap(int x, int y) {
        short temp = toSort[x];
        toSort[x] = toSort[y];
        toSort[y] = temp;
    } // end method

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


    /*
     * =============================================================
     * GETTERS/SETTERS
     * =============================================================
     */

    public short[] getToSort() {
        return toSort;
    } // end getter
}
