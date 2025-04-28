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

    public static final int NUM_NUMBERS = (int) Math.pow(2, 25);//(int) Math.pow(2, 3); // 16
    public static final short NUM_TEST_CASES = 10;
    public static final boolean LOG = false;


    public static final boolean PRINT_ARR = false;
    public static final String FILE_NAME = "Integer_Unsorted_2^24"; // "Integer_Unsorted_2^30"; // playground


    public static void main(String[] args) {
        // generating test case files for consistent testing
//        testThreeWayMS(22);
//        System.out.println();
        testTimSort((int) Math.pow(2, 30));
//        System.out.println();
//        testQuadHS(11);
//        System.out.println();
//        testRandomQS(11);

//        generateDoubleFiles();
//        generateIntFiles();
//        System.out.println("Running " + NUM_TEST_CASES + " test cases with " + NUM_NUMBERS + " random unsorted numbers in array.");
//        testThreeWayMS(50);
//        testQuadHS((int) Math.pow(2, 29));
//        System.out.println((int) Math.pow(2, 31) +1);

//        testThreeWayMSDouble((int) Math.pow(2, 30));

//        for (int j = 30; j < 31; j++) {
//            int num_numbers = (int) Math.pow(2, j);
//
////            System.out.println("Running Random QS");
////            for (int i = 0; i < NUM_TEST_CASES; i++) {
////                testRandomQS(num_numbers);
////                System.out.println("Done: " + (i + 1));
////            }
////
////            System.out.println("Running Three Way MS");
////            for (int i = 0; i < NUM_TEST_CASES; i++) {
////                testThreeWayMS(num_numbers);
////                System.out.println("Done: " + (i + 1));
////            }
//
//            System.out.println("Running Quad HS");
//            for (int i = 0; i < NUM_TEST_CASES; i++) {
//                testQuadHS(num_numbers);
//                System.out.println("Done: " + (i + 1));
//            }
//
//            System.out.println("Running Tim Sort");
//            for (int i = 0; i < NUM_TEST_CASES; i++) {
//                testTimSort(num_numbers);
//                System.out.println("Done: " + (i + 1));
//            }
//        }



        // test int cases
//        testThreeWayMS();
//        testRandomQS();
//        testQuadHS();
//        testTimSort();

        // test double cases
//        testThreeWayMSDouble();
//        testRandomQSDouble();
//        testQuadHSDouble();
//        testTimSortDouble();

    } // end main method

    public static void testTimSort(int numNumbers) {
        TimSort ts = new TimSort();
//        ts.initArray(
//                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
//                NUM_NUMBERS
//        );

        ts.initArray(numNumbers);
        ts.print(PRINT_ARR);

        long startTime = System.nanoTime();
        ts.sort();
        long endTime = System.nanoTime();
        ts.print(PRINT_ARR);
        if (LOG)
            logger.log("ts_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

        if (!ts.isSorted()) {
            throw new RuntimeException("Something wasn't sorted! " + " ts int " + numNumbers);
        }
    }

    public static void testTimSortDouble() {
        TimSortDouble ts = new TimSortDouble();
        ts.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        ts.print(PRINT_ARR);
        ts.sort();
        ts.print(PRINT_ARR);
        System.out.println("Done.");
        System.out.println("Sorted: " + ts.isSorted());
    }

    public static void testQuadHS(int numNumbers) {
        QuadHeapSort qhs = new QuadHeapSort();
//        qhs.initArray(
//                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
//                NUM_NUMBERS
//        );

        qhs.initArray(numNumbers);
        qhs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        qhs.sort(numNumbers);
        long endTime = System.nanoTime();
        qhs.print(PRINT_ARR);
        if (LOG)
            logger.log("qhs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

        if (!qhs.isSorted()) {
            throw new RuntimeException("Something wasn't sorted! " + " qhs int " + numNumbers);
        }

    }

    public static void testQuadHSDouble() {
        QuadHeapSortDouble qhs = new QuadHeapSortDouble();
        qhs.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        qhs.print(PRINT_ARR);
        qhs.sort(NUM_NUMBERS);
        qhs.print(PRINT_ARR);
        System.out.println("Done.");
        System.out.println("Sorted: " + qhs.isSorted());

    }

    public static void testRandomQS(int numNumbers) {
        RandomizedQuickSort rqs = new RandomizedQuickSort();
//        rqs.initArray( // very slow, don't use for testing
//                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
//                NUM_NUMBERS
//        );

        rqs.initArray(numNumbers);
        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();
        rqs.print(PRINT_ARR);
        if (LOG)
            logger.log("rqs_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

        if (!rqs.isSorted()) {
            throw new RuntimeException("Something wasn't sorted! " + " rqs int " + numNumbers);
        }

    }

    public static void testRandomQSDouble() {
        RandomizedQuickSortDouble rqs = new RandomizedQuickSortDouble();
        rqs.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        rqs.print(PRINT_ARR);
        rqs.sort(0, NUM_NUMBERS - 1);
        rqs.print(PRINT_ARR);
        System.out.println("Done.");
        System.out.println("Sorted: " + rqs.isSorted());

    }

    public static void testThreeWayMS(int numNumbers) {
        ThreeWayMergeSort twms = new ThreeWayMergeSort();
//        twms.initArray(
//                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
//                NUM_NUMBERS
//        );

        twms.initArray(numNumbers);
        twms.print(PRINT_ARR);

        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();
        twms.print(PRINT_ARR);
        if (LOG)
            logger.log("twms_int_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms

        if (!twms.isSorted()) {
            throw new RuntimeException("Something wasn't sorted! " + " twms int " + numNumbers);
        }

    }

    public static void testThreeWayMSDouble(int numNumbers) {
        ThreeWayMergeSortDouble twms = new ThreeWayMergeSortDouble();

        twms.initArray(numNumbers);

//        twms.print(true);
        long startTime = System.nanoTime();
        twms.sort(0,numNumbers - 1);
        long endTime = System.nanoTime();
//        twms.print(true);

        if (!twms.isSorted())
            throw new RuntimeException("Something wasn't sorted! " + " twms double " + numNumbers);

        if (LOG)
            logger.log("twms_double_" + numNumbers, Long.toString((endTime - startTime) / 1000000)); // log in ms
    }

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
