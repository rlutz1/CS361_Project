import DoubleSort.QuadHeapSortDouble;
import DoubleSort.RandomizedQuickSortDouble;
import DoubleSort.TimSortDouble;
import DoubleSort.ThreeWayMergeSortDouble;
import IntSort.QuadHeapSort;
import IntSort.RandomizedQuickSort;
import IntSort.ThreeWayMergeSort;
import IntSort.TimSort;

public class Driver {

    public static final Log logger = new Log();
    public static final boolean LOG = false;


    public static final boolean PRINT_ARR = false;


    public static void main(String[] args) {
        // generating test case files for consistent testing
//        generateDoubleFiles();
//        generateIntFiles();

//        runAllIntBenchmarks(20, 30, 10);
//        runAllDoubleBenchmarks(3, 3, 1);
//        System.out.println((int) Math.pow(2, 30));
//        System.out.println((int) Math.pow(2, 30) + 1);
//        System.out.println((int) Math.pow(2, 31));
//        System.out.println((int) Math.pow(2, 31) + 1);
//        System.out.println((-1) *(int) Math.pow(2, 31) - 2);
//        testQuadHS((int) Math.pow(2, 30));
//        testQuadHSDouble((int) Math.pow(2, 30));
//        System.out.println();
//        testRandomQSDouble((int) Math.pow(2, 30));
//        System.out.println();
//        testThreeWayMSDouble((int) Math.pow(2, 30));
//        System.out.println();
//        testTimSortDouble((int) Math.pow(2, 30));
    } // end main method

    public static void runAllDoubleBenchmarks(int low, int high, int numTestCases) {
        for (int j = low; j <= high; j++) {
            int num_numbers = (int) Math.pow(2, j);

            System.out.println("Running Random QS");
            for (int i = 0; i < numTestCases; i++) {
                testRandomQSDouble(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Three Way MS");
            for (int i = 0; i < numTestCases; i++) {
                testThreeWayMSDouble(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Quad HS");
            for (int i = 0; i < numTestCases; i++) {
                testQuadHSDouble(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Tim Sort");
            for (int i = 0; i < numTestCases; i++) {
                testTimSortDouble(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop
        } // end loop
    } // end method

    public static void runAllIntBenchmarks(int low, int high, int numTestCases) {
        for (int j = low; j <= high; j++) {
            int num_numbers = (int) Math.pow(2, j);

            System.out.println("Running Random QS");
            for (int i = 0; i < numTestCases; i++) {
                testRandomQS(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Three Way MS");
            for (int i = 0; i < numTestCases; i++) {
                testThreeWayMS(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Quad HS");
            for (int i = 0; i < numTestCases; i++) {
                testQuadHS(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop

            System.out.println("Running Tim Sort");
            for (int i = 0; i < numTestCases; i++) {
                testTimSort(num_numbers);
                System.out.println("Done: " + (i + 1));
            } // end loop
        } // end loop
    } // end method

    public static void testTimSort(int numNumbers) {
        TimSort ts = new TimSort();

        ts.initArray(numNumbers);
        ts.print(PRINT_ARR);

        long startTime = System.nanoTime();
        ts.sort();
        long endTime = System.nanoTime();

        ts.print(PRINT_ARR);

        if (!ts.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " ts int " + numNumbers);

        if (LOG)
            logger.log("ts_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testTimSortDouble(int numNumbers) {
        TimSortDouble ts = new TimSortDouble();

        ts.initArray(numNumbers);
        ts.print(PRINT_ARR);

        long startTime = System.nanoTime();
        ts.sort();
        long endTime = System.nanoTime();

        ts.print(PRINT_ARR);

        if (!ts.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " ts double " + numNumbers);

        if (LOG)
            logger.log("ts_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testQuadHS(int numNumbers) {
        QuadHeapSort qhs = new QuadHeapSort();

        qhs.initArray(numNumbers);
        qhs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        qhs.sort(numNumbers);
        long endTime = System.nanoTime();

        qhs.print(PRINT_ARR);

        if (!qhs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " qhs int " + numNumbers);

        if (LOG)
            logger.log("qhs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testQuadHSDouble(int numNumbers) {
        QuadHeapSortDouble qhs = new QuadHeapSortDouble();

        qhs.initArray(numNumbers);
        qhs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        qhs.sort(numNumbers);
        long endTime = System.nanoTime();

        qhs.print(PRINT_ARR);

        if (!qhs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " qhs double " + numNumbers);

        if (LOG)
            logger.log("qhs_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testRandomQS(int numNumbers) {
        RandomizedQuickSort rqs = new RandomizedQuickSort();

        rqs.initArray(numNumbers);
        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        rqs.print(PRINT_ARR);

        if (!rqs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " rqs int " + numNumbers);

        if (LOG)
            logger.log("rqs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testRandomQSDouble(int numNumbers) {
        RandomizedQuickSortDouble rqs = new RandomizedQuickSortDouble();

        rqs.initArray(numNumbers);
        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        rqs.print(PRINT_ARR);

        if (!rqs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " rqs double " + numNumbers);

        if (LOG)
            logger.log("rqs_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testThreeWayMS(int numNumbers) {
        ThreeWayMergeSort twms = new ThreeWayMergeSort();

        twms.initArray(numNumbers);
        twms.print(PRINT_ARR);

        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        twms.print(PRINT_ARR);

        if (!twms.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " twms int " + numNumbers);

        if (LOG)
            logger.log("twms_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testThreeWayMSDouble(int numNumbers) {
        ThreeWayMergeSortDouble twms = new ThreeWayMergeSortDouble();

        twms.initArray(numNumbers);
        twms.print(PRINT_ARR);

        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        twms.print(PRINT_ARR);

        if (!twms.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " twms double " + numNumbers);

        if (LOG)
            logger.log("twms_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    /**
     * uncomment or type in whatever files you need to make.
     * creates float point test cases.
     * if the file exists, it will be overwritten with this new case.
     */
    public static void generateDoubleFiles() {
        TestCaseGenerator gtc = new TestCaseGenerator();
//        gtc.generateDoubles((int) Math.pow(2, 20), -500, 500, "Double_Unsorted_2^20");
//        gtc.generateDoubles((int) Math.pow(2, 21), -500, 500, "Double_Unsorted_2^21");
//        gtc.generateDoubles((int) Math.pow(2, 22), -500, 500, "Double_Unsorted_2^22");
//        gtc.generateDoubles((int) Math.pow(2, 23), -500, 500, "Double_Unsorted_2^23");
//        gtc.generateDoubles((int) Math.pow(2, 24), -500, 500, "Double_Unsorted_2^24");
//        gtc.generateDoubles((int) Math.pow(2, 25), -500, 500, "Double_Unsorted_2^25");
//        gtc.generateDoubles((int) Math.pow(2, 26), -500, 500, "Double_Unsorted_2^26");
//        gtc.generateDoubles((int) Math.pow(2, 27), -500, 500, "Double_Unsorted_2^27");
//        gtc.generateDoubles((int) Math.pow(2, 28), -500, 500, "Double_Unsorted_2^28")
//        gtc.generateDoubles((int) Math.pow(2, 29), -500, 500, "Double_Unsorted_2^29"); // -Xmx6g
//        gtc.generateDoubles((int) Math.pow(2, 30), -500, 500, "Double_Unsorted_2^30"); // -Xmx10g
    } // end method

    /**
     * uncomment or type in whatever files you need to make.
     * creates whole number/integer test cases.
     * if the file exists, it will be overwritten with this new case.
     */
    public static void generateIntFiles() {
        TestCaseGenerator gtc = new TestCaseGenerator();
//        gtc.generateInts((int) Math.pow(2, 20), -500, 500, false, "Integer_Unsorted_2^20");
//        gtc.generateInts((int) Math.pow(2, 21), -500, 500, false, "Integer_Unsorted_2^21");
//        gtc.generateInts((int) Math.pow(2, 22), -500, 500, false, "Integer_Unsorted_2^22");
//        gtc.generateInts((int) Math.pow(2, 23), -500, 500, false, "Integer_Unsorted_2^23");
//        gtc.generateInts((int) Math.pow(2, 24), -500, 500, false, "Integer_Unsorted_2^24");
//        gtc.generateInts((int) Math.pow(2, 25), -500, 500, false, "Integer_Unsorted_2^25");
//        gtc.generateInts((int) Math.pow(2, 26), -500, 500, false, "Integer_Unsorted_2^26");
//        gtc.generateInts((int) Math.pow(2, 27), -500, 500, false, "Integer_Unsorted_2^27");
//        gtc.generateInts((int) Math.pow(2, 28), -500, 500, false, "Integer_Unsorted_2^28");
//        gtc.generateInts((int) Math.pow(2, 29), -500, 500, false, "Integer_Unsorted_2^29");
//        gtc.generateInts((int) Math.pow(2, 29), -500, 500, false, "Integer_Unsorted_2^29");
     } // end method

} // end class
