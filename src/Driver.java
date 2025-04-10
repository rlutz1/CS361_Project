import DoubleSort.QuadHeapSortDouble;
import DoubleSort.RandomizedQuickSortDouble;
import DoubleSort.TimSortDouble;
import IntSort.QuadHeapSort;
import IntSort.RandomizedQuickSort;
import IntSort.ThreeWayMergeSort;
import IntSort.TimSort;

public class Driver {

    public static final String FILE_NAME = "Integer_Unsorted_2^24"; // "Integer_Unsorted_2^30"; // playground
    public static final int NUM_NUMBERS = (int) Math.pow(2, 24);//(int) Math.pow(2, 3); // 16
    public static final boolean PRINT_ARR = false;
    public static final byte NUM_TEST_CASES = 20;

    public static void main(String[] args) {
        // generating test case files for consistent testing
//        generateDoubleFiles();
//        generateIntFiles();

        for (int i = 0; i < NUM_TEST_CASES; i++) {
            testRandomQS();
        }

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

    public static void testTimSort() {
        TimSort ts = new TimSort();
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

    public static void testQuadHS() {
        QuadHeapSort qhs = new QuadHeapSort();
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

    public static void testRandomQS() {
        RandomizedQuickSort rqs = new RandomizedQuickSort();
//        rqs.initArray( // very slow, don't use for testing
//                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
//                NUM_NUMBERS
//        );

        rqs.initArray((int) Math.pow(2, 20));
        rqs.print(PRINT_ARR);

        long startTime = System.nanoTime();
        rqs.sort(0, (int) Math.pow(2, 20) - 1);
        long endTime = System.nanoTime();
        System.out.println("RQS Integer Done. Took " + ((endTime - startTime) / 1000000 + " ms"));  //divide by 1000000 to get MILLISECONDS.

        rqs.print(PRINT_ARR);
        System.out.println("Sorted: " + rqs.isSorted());

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

    public static void testThreeWayMS() {
        ThreeWayMergeSort twms = new ThreeWayMergeSort();
        twms.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        twms.print(PRINT_ARR);
        twms.sort(0, NUM_NUMBERS - 1);
        twms.print(PRINT_ARR);
        System.out.println("Done.");
        System.out.println("Sorted: " + twms.isSorted());
    }

    public static void testThreeWayMSDouble() {
        ThreeWayMergeSortDouble twms = new ThreeWayMergeSortDouble();
        twms.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        twms.print(PRINT_ARR);
        twms.sort(0, NUM_NUMBERS - 1);
        twms.print(PRINT_ARR);
        System.out.println("Done.");
        System.out.println("Sorted: " + twms.isSorted());
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
