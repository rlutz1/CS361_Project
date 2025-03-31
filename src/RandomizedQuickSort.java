import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Randomized quick sort: You will implement the randomized quick sort
 * algorithm. In each iteration, the pivot must be randomly chosen using a
 * random number generator.
 * todo:
 */

public class RandomizedQuickSort {

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

    public RandomizedQuickSort() {  } // end constructor

    /*
     * =============================================================
     * HELPER FUNCTIONS
     * =============================================================
     */

    /**
     * method to sort the array utilizing randomized quick sort.
     */
    public void sort(int low, int high) {
        if (high - low < 1) { return; }
        int pivot = partition(low, high);
        sort(low, pivot - 1);
        sort(pivot + 1, high);
    } // end method

    /**
     * partitioning step of the quick sort algorithm.
     * main difference is that we choose a random index between
     * low -> high inclusive, swap the high with this pivot,
     * and then partition as usual to the implementation.
     * @param start the start index
     * @param end the end index
     * @return
     */
    private int partition(int start, int end) {
        int randPivot = getRandomPivot(start, end);
        swap(randPivot, end);
//        System.out.println("Random pivot: " + randPivot);
//        print(true);
        int b = start - 1, t = start;

        while (t < end) {
            if (toSort[t] < toSort[end]) {
                swap(t, b + 1);
                b++;
            } //end if
            t++;
        } // end loop

        if (b < end) {
            swap(b + 1, end);
        } // end if

//        System.out.println("Done partioning: ");
//        print(true);

        return b + 1;

    } // end if

    /**
     * simple utility method to get a randomized index pivot choice for the
     * paritioning step.
     * @param low lowest index potential
     * @param high highest index potential
     * @return a random pivot index
     */
    private int getRandomPivot(int low, int high) {
        Random random = new Random();
        return random.nextInt(low, high + 1);
    } // end method

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

    public short[] getToSort(){
        return toSort;
    } // end getter

}
