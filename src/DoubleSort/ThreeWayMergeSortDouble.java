package DoubleSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * 3-way merge sort for doubles: You will be implementing a 3-way merge sort, which
 * divides the given input into 3 subsets of roughly equal size and recursively
 * sort each subset
 *
 * this is the same as the other three way mergesort, but instead takes doubles.
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


    public void sort(int low, int high) {
//        System.out.println("low " + low + " high " + high);
        if (low >= high) { return; }
        if (high - low == 1) { swapIfNeeded(low, high); return;}

        int third = (high - low) / 3;

        sort (low, low + third);
        sort (low + third + 1, high - third);
        sort (high - third + 1, high);

//        merge (low, low + third, low + third + 1, high - third);
//        merge (low, high - third, high - third + 1, high);

        copyIn (
                merge (low, low + third, low + third + 1, high - third),
                low,
                high - third
        );
        copyIn (
                merge (low, high - third, high - third + 1, high),
                low,
                high
        );
//        print(true);
    }

    /**
     * todo: issue with memory on my machine with 2^30 case.
     * @param startA
     * @param endA
     * @param startB
     * @param endB
     * @return
     */
    private float[] merge(int startA, int endA, int startB, int endB) {
        int i = startA, j = startB, k = 0;
        float[] temp = new float[endB - startA + 1];


        while (i <= endA && j <= endB) {
//            System.out.println("while1");
            if (toSort[i] > toSort[j]) {
                temp[k] = toSort[j]; k++; j++;
            } else {
                temp[k] = toSort[i]; k++; i++;
            } // end if
        } // end loop

        while (i <= endA) {
//            System.out.println("while2");
            temp[k] = toSort[i]; k++; i++;
        } // end while

        while (j <= endB) {
//            System.out.println("while3");
            temp[k] = toSort[j]; k++; j++;
        } // end while

        return temp;

    } // end method


    private void copyIn(float[] temp, int start, int end) {
        for (int i = start, j = 0; i <= end; i++, j++) {
            toSort[i] = temp[j];
        } // end loop
    } // end method

    private void swapIfNeeded(int low, int high) {
        if (toSort[low] > toSort[high])  {
            swap(low, high);
        } // end if
    } // end method


    private void swap(int x, int y) {
        float temp = toSort[x];
        toSort[x] = toSort[y];
        toSort[y] = temp;
    } // end method


    /**
     * gen a random test case
     * from basic java io operations.
     */
    public void initArray(int howMany) {
        toSort = new float[howMany];

        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            toSort[i] = (float) rand.nextDouble();
        } // end loop

    } // end method

    /**
     * simple print function for testing purposes.
     */
    public void print(boolean printNums) {
        if (printNums) {
            for (double num : toSort) {
                System.out.print(num + " ");
            } // end loop
        } // end if

        System.out.println("Found " + toSort.length + " numbers.");
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
