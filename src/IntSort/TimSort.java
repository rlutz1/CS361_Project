package IntSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Tim sort: Tim sort is a hybrid sorting algorithm derived from merge sort
 * and insertion sort, designed to perform well on real-world data. It is the
 * default sorting algorithm in Python, Java, and Android
 * todo:
 *
 */

public class TimSort {

    /*
     * =============================================================
     * GLOBALS/CONSTANTS
     * =============================================================
     */

    private short[] toSort = null;
    private final static byte MIN_RUN = 32; // todo: min run size default for tim sort, 32 for completion


    /*
     * =============================================================
     * CONSTRUCTORS
     * =============================================================
     */

    public TimSort() {  } // end constructor


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
     * as of 4/6/25, these will be implemented with no optimzations to begin with.
     */
    public void sort() {

        // todo: sitting to min run 16 for testing!
        // use insertion sort on smaller runs
        for (int i = 0; i < toSort.length; i += MIN_RUN) {
            insertionSort(i, Math.min(toSort.length - 1, i + MIN_RUN - 1));
        } // end loop

        for (int j = MIN_RUN; j < toSort.length; j *= 2) {

            for (int i = 0; i < toSort.length; i += 2 * j) {
//                System.out.println(i + " " + (i + j - 1) + " " + (i + j) + " " + Math.min(toSort.length - 1, i + (2 * j) - 1));
                merge(i, Math.min(toSort.length - 1, i + j - 1), i + j, Math.min(toSort.length - 1, i + (2 * j) - 1));
//                print(true);
            }
        }




    } // end method

    /**
     * todo:
     * optimize with binary search?
     * @param low
     * @param high
     */
    private void insertionSort(int low, int high) {
        int j;
        for (int i = low; i < high; i++) { // for every element of the list

            if (toSort[i + 1] < toSort[i]) {
                j = i;
                short temp = toSort[i + 1];
                while (j >= low && toSort[j] > temp) {
                    toSort[j + 1] = toSort[j];
                    j--;
                } // end loop
                toSort[j + 1] = temp;
            } // end if
//            print(true);
        } // end loop

    } // end method

    /**
     * todo: issue with memory on my machine with 2^30 case.
     * -- optimize with galloping?
     * basic merge function from merge sort.
     * @param startA
     * @param endA
     * @param startB
     * @param endB
     * @return
     */
    private void merge(int startA, int endA, int startB, int endB) {
//        System.out.println(endA + " " + endB);
        int i = startA, j = startB, k = 0;
        short[] temp = new short[endB - startA + 1];


        while (i <= endA && j <= endB) {
//            System.out.println("um");
            if (toSort[i] > toSort[j]) {
                temp[k] = toSort[j]; k++; j++;
            } else {
                temp[k] = toSort[i]; k++; i++;
//                System.out.println("?????");
            } // end if
        } // end loop

        while (i <= endA) {
            temp[k] = toSort[i]; k++; i++;
        } // end while

        while (j <= endB) {
            temp[k] = toSort[j]; k++; j++;
        } // end while

//        System.out.println("TEMP");
//
//        for (int num : temp) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        for (i = startA, k = 0; i <= endB; i++, k++) {
            toSort[i] = temp[k];

        } // end loop

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
     * gen a random test case
     * from basic java io operations.
     */
    public void initArray(int howMany) {
        toSort = new short[howMany];

        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            toSort[i] = (short)rand.nextInt(-60000, 60000 + 1);
        } // end loop

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

    public short[] getToSort(){
        return toSort;
    } // end getter

}
