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

    public static boolean PRINT_ARR = false;
    public static boolean PRINT_TIME = false;
    public static boolean SEED = false;
    public static byte DEFAULT_SEED = 42;

//-pa true // print array
//-p2 _ // power of 2
//-n _ // size of array (literal, not power of 2)
//-pt true
//-r _ // number of test cases to run
// -s true seed num
    public static void main(String[] args) {
        int numNumbers = 0; int numTestCases = 1;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-pa":
                    if (args[++i].equals("true"))
                        PRINT_ARR = true;
                    break;
                case "-p2":
                    numNumbers = (int) Math.pow(2, Integer.parseInt(args[++i]));
                    break;
                case "-n":
                    numNumbers = Integer.parseInt(args[++i]);
                    break;
                case "-pt":
                    if (args[++i].equals("true"))
                        PRINT_TIME = true;
                    break;
                case "-r":
                    numTestCases = Integer.parseInt(args[++i]);
                    break;
                case "-s":
                    if (args[++i].equals("true"))
                        SEED = true;
                    break;
                default:
                    break; // do nothing if no arg match.
            } // end switch case
        } // end arg parser loop

        // run all sorts, int first, then floating point
        System.out.println("========RUNNING WITH INT========");
        runAllIntBenchmarks(numNumbers, numTestCases);
        System.out.println("========RUNNING WITH DOUBLE========");
        runAllDoubleBenchmarks(numNumbers, numTestCases);
    } // end main method

    public static void runAllDoubleBenchmarks(int numNumbers, int numTestCases) {
        System.out.println("Running Random QS with " + numNumbers);
        for (int i = 0; i < numTestCases; i++) {
            testRandomQSDouble(numNumbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Three Way MS with " + numNumbers);
        for (int i = 0; i < numTestCases; i++) {
            testThreeWayMSDouble(numNumbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Quad HS with " + numNumbers);
        for (int i = 0; i < numTestCases; i++) {
            testQuadHSDouble(numNumbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Tim Sort with " + numNumbers);
        for (int i = 0; i < numTestCases; i++) {
            testTimSortDouble(numNumbers);
            System.out.println("Done: " + (i + 1));
        } // end loop
    } // end method

    public static void runAllIntBenchmarks(int num_numbers, int numTestCases) {
        System.out.println("Running Random QS: with " + num_numbers);
        for (int i = 0; i < numTestCases; i++) {
            testRandomQS(num_numbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Three Way MS with " + num_numbers);
        for (int i = 0; i < numTestCases; i++) {
            testThreeWayMS(num_numbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Quad HS with " + num_numbers);
        for (int i = 0; i < numTestCases; i++) {
            testQuadHS(num_numbers);
            System.out.println("Done: " + (i + 1));
        } // end loop

        System.out.println("Running Tim Sort with " + num_numbers);
        for (int i = 0; i < numTestCases; i++) {
            testTimSort(num_numbers);
            System.out.println("Done: " + (i + 1));
        } // end loop
    } // end method

    public static void testTimSort(int numNumbers) {
        TimSort ts = new TimSort();

        if (SEED) {
            ts.initArray(numNumbers, DEFAULT_SEED);
        } else {
            ts.initArray(numNumbers);
        } // end if

        ts.print(PRINT_ARR);

        long startTime = System.nanoTime();
        ts.sort();
        long endTime = System.nanoTime();

        ts.print(PRINT_ARR);

        if (!ts.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " ts int " + numNumbers);

        if (PRINT_TIME)
            System.out.println("TS Int took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("ts_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testTimSortDouble(int numNumbers) {
        TimSortDouble ts = new TimSortDouble();

        if (SEED) {
            ts.initArray(numNumbers, DEFAULT_SEED);
        } else {
            ts.initArray(numNumbers);
        } // end if

        ts.print(PRINT_ARR);

        long startTime = System.nanoTime();
        ts.sort();
        long endTime = System.nanoTime();

        ts.print(PRINT_ARR);

        if (!ts.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " ts double " + numNumbers);

        if (PRINT_TIME)
            System.out.println("TS Double took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("ts_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testQuadHS(int numNumbers) {
        QuadHeapSort qhs = new QuadHeapSort();

        if (SEED) {
            qhs.initArray(numNumbers, DEFAULT_SEED);
        } else {
            qhs.initArray(numNumbers);
        } // end if

        qhs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        qhs.sort(numNumbers);
        long endTime = System.nanoTime();

        qhs.print(PRINT_ARR);

        if (!qhs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " qhs int " + numNumbers);

        if (PRINT_TIME)
            System.out.println("QHS Int took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("qhs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testQuadHSDouble(int numNumbers) {
        QuadHeapSortDouble qhs = new QuadHeapSortDouble();

        if (SEED) {
            qhs.initArray(numNumbers, DEFAULT_SEED);
        } else {
            qhs.initArray(numNumbers);
        } // end if

        qhs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        qhs.sort(numNumbers);
        long endTime = System.nanoTime();

        qhs.print(PRINT_ARR);

        if (!qhs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " qhs double " + numNumbers);

        if (PRINT_TIME)
            System.out.println("QHS Double took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("qhs_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testRandomQS(int numNumbers) {
        RandomizedQuickSort rqs = new RandomizedQuickSort();

        if (SEED) {
            rqs.initArray(numNumbers, DEFAULT_SEED);
        } else {
            rqs.initArray(numNumbers);
        } // end if

        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        rqs.print(PRINT_ARR);

        if (!rqs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " rqs int " + numNumbers);

        if (PRINT_TIME)
            System.out.println("RQS Int took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("rqs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testRandomQSDouble(int numNumbers) {
        RandomizedQuickSortDouble rqs = new RandomizedQuickSortDouble();

        if (SEED) {
            rqs.initArray(numNumbers, DEFAULT_SEED);
        } else {
            rqs.initArray(numNumbers);
        } // end if

        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        rqs.print(PRINT_ARR);

        if (!rqs.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " rqs double " + numNumbers);

        if (PRINT_TIME)
            System.out.println("RQS Double took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("rqs_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

    } // end method

    public static void testThreeWayMS(int numNumbers) {
        ThreeWayMergeSort twms = new ThreeWayMergeSort();

        if (SEED) {
            twms.initArray(numNumbers, DEFAULT_SEED);
        } else {
            twms.initArray(numNumbers);
        } // end if

        twms.print(PRINT_ARR);

        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        twms.print(PRINT_ARR);

        if (!twms.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " twms int " + numNumbers);

        if (PRINT_TIME)
            System.out.println("TWMS Int took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("twms_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

    public static void testThreeWayMSDouble(int numNumbers) {
        ThreeWayMergeSortDouble twms = new ThreeWayMergeSortDouble();

        if (SEED) {
            twms.initArray(numNumbers, DEFAULT_SEED);
        } else {
            twms.initArray(numNumbers);
        } // end if

        twms.print(PRINT_ARR);

        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();

        twms.print(PRINT_ARR);

        if (!twms.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " twms double " + numNumbers);

        if (PRINT_TIME)
            System.out.println("TWMS Double took " + (endTime - startTime) / 1000000 + " ms.");

        if (LOG)
            logger.log("twms_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    } // end method

} // end class
