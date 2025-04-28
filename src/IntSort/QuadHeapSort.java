package IntSort;

import java.util.Random;

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


    private int[] toSort = null;


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

    /**
     * main sorting method utilizing a quad heap.
     * @param size size of the heap
     */
    public void sort(int size) {

        // assume array is a heap and heapify starting from last parent
        for (int i = (size - 2) / 4; i >= 0; i--) {
            maxHeapify(i, size);
        } // end loop

        // move max to the end, fix heap violations from root down to last leaf
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            maxHeapify(0, i);
        } // end loop

    } // end method


    /**
     * method to heapify the quad heap.
     * now each node will have 4 children to consider instead of
     * typical 2 of the binary heap.
     * swap the max to the top as needed, and then fix the subtree
     * as needed.
     * @param start starting point to heapify
     * @param end ending point to stop at
     */
    public void maxHeapify(int start, int end) {
        if (start < (int) Math.pow(2,29)) { // limit to note
            // grab all 4 children
            int child1 = 4 * start + 1;
            int child2 = 4 * start + 2;
            int child3 = 4 * start + 3;
            int child4 = 4 * start + 4;
            int max = start;

            // find the max of the parent and children
            if (child1 < end && toSort[child1] > toSort[max]) {
                max = child1;
            } // end if

            if (child2 < end && toSort[child2] > toSort[max]) {
                max = child2;
            } // end if

            if (child3 < end && toSort[child3] > toSort[max]) {
                max = child3;
            } // end if

            if (child4 < end && toSort[child4] > toSort[max]) {
                max = child4;
            } // end if

            // if we found a new maximum
            if (max != start) {
                swap(start, max); // ensure max is the parent node
                maxHeapify(max, end); // fix the subtree as needed
            } // end if
        } // end if
    } // end method

    /**
     * general method to swap something in our list.
     * common logic.
     * @param x item to swap
     * @param y item to swap
     */
    private void swap(int x, int y) {
        int temp = toSort[x];
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
            System.out.println("Found " + toSort.length + " numbers.");
        } // end if
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
        toSort = new int[howMany];

        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            toSort[i] = rand.nextInt();
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

    public int[] getToSort() {
        return toSort;
    } // end getter
}
