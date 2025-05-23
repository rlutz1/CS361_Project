package DoubleSort;

import java.util.Random;

/**
 * @author Roxanne Lutz
 * Tim sort: Tim sort is a hybrid sorting algorithm derived from merge sort
 * and insertion sort, designed to perform well on real-world data. It is the
 * default sorting algorithm in Python, Java, and Android
 */
public class TimSortDouble {

    /*
     * =============================================================
     * GLOBALS/CONSTANTS
     * =============================================================
     */

    private float[] toSort = null;
    private final static byte MIN_RUN = 32;


    /*
     * =============================================================
     * CONSTRUCTORS
     * =============================================================
     */

    public TimSortDouble() {  } // end constructor


    /*
     * =============================================================
     * HELPER FUNCTIONS
     * =============================================================
     */

    /**
     * method to sort the array a la tim sort.
     * general approach is:
     * (1) use insertion sort on sub arrays of no more than 32 in length
     * (2) use merge from mergesort to merge the sorted arrays.
     */
    public void sort() {

        // use insertion sort on smaller runs
        for (int i = 0; i < toSort.length; i += MIN_RUN) {
            insertionSort(i, min(toSort.length - 1, i + MIN_RUN - 1));
        } // end loop

        // merge the sub runs, increasing the sub run length with each iteration
        for (int j = MIN_RUN; j < toSort.length; j *= 2) {
            for (int i = 0; i < toSort.length; i += 2 * j) {
                merge(
                        i, min(toSort.length - 1, i + j - 1),
                        i + j, min(toSort.length - 1, i + (2 * j) - 1));
            } // end loop
        } // end loop

    } // end method

    /**
     * unaltered insertion sort implementation.
     * @param low index of start of subarray
     * @param high index end of subarray
     */
    private void insertionSort(int low, int high) {
        int j; float temp;
        for (int i = low; i < high; i++) { // for every element of the list

            if (toSort[i + 1] < toSort[i]) { // if we find a smaller element ahead
                j = i; // bookmark
                temp = toSort[i + 1]; // grab the element to "insert"
                while (j >= low && toSort[j] > temp) { // until we hit end or something smaller
                    toSort[j + 1] = toSort[j]; // make space
                    j--;
                } // end loop
                toSort[j + 1] = temp; // insert element in correct spot
            } // end if
        } // end loop

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


        while (i <= endA && j <= endB) {
            if (toSort[i] > toSort[j]) {
                temp[k] = toSort[j]; k++; j++;
            } else {
                temp[k] = toSort[i]; k++; i++;
            } // end if
        } // end loop

        while (i <= endA) {
            temp[k] = toSort[i]; k++; i++;
        } // end while

        while (j <= endB) {
            temp[k] = toSort[j]; k++; j++;
        } // end while

        for (i = startA, k = 0; i <= endB; i++, k++) {
            toSort[i] = temp[k];
        } // end loop

    } // end method

    /**
     * simple return the minimum of two values utility.
     * @param x int 1
     * @param y int 2
     * @return the smaller (or first if equal) of 2
     */
    private int min(int x, int y) {
        if (x <= y) {
            return x;
        } // end if
        return y;
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
     * gen a random test case
     * from basic java io operations.
     */
    public void initArray(int howMany, int seed) {
        toSort = new float[howMany];

        Random rand = new Random(seed);
        byte flipFlop = 1;

        for (int i = 0; i < howMany; i++) {
            toSort[i] = rand.nextFloat() * 1000000 * flipFlop;
            if (i % 2 == 1) {flipFlop = -1;} else {flipFlop = 1;}
        } // end loop

    } // end method

    /**
     * simple ascending list checker to run for testing purposes on
     * large data sets. to make my life easier :)
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

    public float[] getToSort(){
        return toSort;
    } // end getter

} // end class
