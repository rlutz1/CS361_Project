package DoubleSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * 3-way merge sort: You will be implementing a 3-way merge sort, which
 * divides the given input into 3 subsets of roughly equal size and recursively
 * sort each subsetd
 * todo:
 * -- read in text file to formulate a short[]; make this easy to maybe abstract out
 * --
 */

public class ThreeWayMergeSortDouble {

    /*
     * =============================================================
     * GLOBALS/CONSTANTS
     * =============================================================
     */

    private float[] toSort = null;


    /*
     * =============================================================
     * CONSTRUCTORS
     * =============================================================
     */

    public ThreeWayMergeSortDouble() { } // end constructor


    /*
     * =============================================================
     * HELPER METHODS
     * =============================================================
     */


    /**
     * the sort method of three way mergesort.
     * @param low start index
     * @param high end index
     */
    public void sort(int low, int high) {
        if (low >= high) { return; }
        if (high - low == 1) { swapIfNeeded(low, high); return;}

        int third = (high - low) / 3;

        sort (low, low + third);
        sort (low + third + 1, high - third);
        sort (high - third + 1, high);

        merge (low, low + third, low + third + 1, high - third);
        merge (low, high - third, high - third + 1, high);
    } // end method

    /**
     * merge method to take two starts, two ends, and merge the two
     * sorted sections into a temporary array,
     * which is then copied into the final array.
     * @param startA given first starting index
     * @param endA given first ending index
     * @param startB given second starting index
     * @param endB given second ending index
     */
    private void merge(int startA, int endA, int startB, int endB) {
        int i = startA, j = startB, k = 0;
        float[] temp = new float[endB - startA + 1];

        // merge the two sorted lists into the temporary array
        while (i <= endA && j <= endB) {
            if (toSort[i] > toSort[j]) {
                temp[k] = toSort[j]; k++; j++;
            } else {
                temp[k] = toSort[i]; k++; i++;
            } // end if
        } // end loop

        // dump the contents of array 1 if needed
        while (i <= endA) {
            temp[k] = toSort[i]; k++; i++;
        } // end while

        // dump the contents of array 2 if needed
        while (j <= endB) {
            temp[k] = toSort[j]; k++; j++;
        } // end while

        // copy the temporary array's merged contents into the global
        for (i = startA, k = 0; i <= endB; i++, k++) {
            toSort[i] = temp[k];
        } // end loop
    } // end method

    /**
     * only swap 2 values if they are not in ascending order.
     * @param low first index
     * @param high second index
     */
    private void swapIfNeeded(int low, int high) {
        if (toSort[low] > toSort[high])  {
            swap(low, high);
        } // end if
    } // end method

    /**
     * straight forward utility swap method
     * @param x first element to swap
     * @param y second element to swap
     */
    private void swap(int x, int y) {
        float temp = toSort[x];
        toSort[x] = toSort[y];
        toSort[y] = temp;
    } // end method

//    /**
//     * method common to all sort classes to read in a test case file
//     * from basic java io operations.
//     * @param path file path given, will be ultimately from the command line/from driver
//     *             note that the test cases are all given as csv format
//     */
//    public void initArray(String path, int howMany) {
//        toSort = new short[howMany]; int counter = 0;
//        try {
//            Scanner s = new Scanner(new File(path)).useDelimiter(",");
//            while (s.hasNext()) {
//                toSort[counter] = s.nextShort(); counter++;
//            } // end loop
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Oops, no file there. Love, mergesort.");
//        } // end try/catch
//
//    } // end method


    /**
     * gen a random test case
     * from basic java io operations.
     */
    public void initArray(int howMany) {
        toSort = new float[howMany];

        Random rand = new Random();
        byte flipFlop = 1;

        for (int i = 0; i < howMany; i++) {
            toSort[i] = rand.nextFloat() * 1000000 * flipFlop;
            if (i % 2 == 1) {flipFlop = -1;} else {flipFlop = 1;}
        } // end loop

    } // end method

    /**
     * simple print function for testing purposes.
     */
    public void print(boolean printNums) {
        if (printNums) {
            for (float num : toSort) {
                System.out.print(num + " ");
            } // end loop
            System.out.println("Found " + toSort.length + " numbers.");
        } // end if
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

    public float[] getToSort() {
        return toSort;
    } // end getter

}
