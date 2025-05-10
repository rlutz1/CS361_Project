package DoubleSort;

import java.util.Random;


/**
 * @author Roxanne Lutz
 * Randomized quick sort: You will implement the randomized quick sort
 * algorithm. In each iteration, the pivot must be randomly chosen using a
 * random number generator.
 */

public class RandomizedQuickSortDouble {

    /*
     * =============================================================
     * GLOBALS/CONSTANTS
     * =============================================================
     */

    private float[] toSort = null;
    private Random random = new Random();

    /*
     * =============================================================
     * CONSTRUCTORS
     * =============================================================
     */

    public RandomizedQuickSortDouble() {  } // end constructor

    /*
     * =============================================================
     * HELPER FUNCTIONS
     * =============================================================
     */

    /**
     * method to sort the array utilizing randomized quick sort.
     */
    public void sort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high); // parition and return pivot
            sort(low, pivot - 1); // sort first half
            sort(pivot + 1, high); // sort second half
        } // end if
    } // end method

    /**
     * partitioning step of the quick sort algorithm.
     * main difference is that we choose a random index between
     * low -> high inclusive, swap the high with this pivot,
     * and then partition as usual to the implementation.
     * @param start the start index
     * @param end the end index
     * @return the pivot index
     */
    private int partition(int start, int end) {
        swap(getRandomPivot(start, end), end); // get a random pivot choice
        int b = start - 1, t = start; // set up bookmark and traveller

        // place all nums smaller than pivot left of b, all things bigger right of b
        while (t < end) {
            if (toSort[t] < toSort[end]) {
                b++;
                swap(t, b);
            } //end if
            t++;
        } // end loop

        // if the bookmark is not at the end of this subarray
        if (b < end) {
            swap(b + 1, end);
        } // end if

        return b + 1; // return the pivot
    } // end method

    /**
     * simple utility method to get a randomized index pivot choice for the
     * paritioning step.
     * @param low lowest index potential
     * @param high highest index potential
     * @return a random pivot index
     */
    private int getRandomPivot(int low, int high) {
        return random.nextInt(low, high + 1);
    } // end method

    /**
     * general method to swap something in our list.
     * common logic.
     * @param x item to swap
     * @param y item to swap
     */
    private void swap(int x, int y) {
        float temp = toSort[x];
        toSort[x] = toSort[y];
        toSort[y] = temp;
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

    public float[] getToSort(){
        return toSort;
    } // end getter

} // end class
