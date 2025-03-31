

public class Driver {

    public static final String FILE_NAME = "Integer_Unsorted_2^30"; // playground
    public static final int NUM_NUMBERS = (int) Math.pow(2, 30); // 16

    public static void main(String[] args) {
        ThreeWayMergeSort ms = new ThreeWayMergeSort();
        ms.initArray(
                "C:\\Users\\lutzr\\CS351\\ProjectSource\\CS361_Project\\tests\\" + FILE_NAME,
                NUM_NUMBERS
        );
        ms.print(false);
        ms.sort(0, NUM_NUMBERS - 1);
        System.out.println("Done.");
        System.out.println("Sorted: " + ms.isSorted());

    }
}

//TestCaseGenerator gtc = new TestCaseGenerator();
//        gtc.generate((int) Math.pow(2, 20), -500, 500, false, "Integer_Unsorted_2^20");
//        gtc.generate((int) Math.pow(2, 21), -500, 500, false, "Integer_Unsorted_2^21");
//        gtc.generate((int) Math.pow(2, 22), -500, 500, false, "Integer_Unsorted_2^22");
//        gtc.generate((int) Math.pow(2, 23), -500, 500, false, "Integer_Unsorted_2^23");
//        gtc.generate((int) Math.pow(2, 24), -500, 500, false, "Integer_Unsorted_2^24");
//        gtc.generate((int) Math.pow(2, 25), -500, 500, false, "Integer_Unsorted_2^25");
//        gtc.generate((int) Math.pow(2, 26), -500, 500, false, "Integer_Unsorted_2^26");
//        gtc.generate((int) Math.pow(2, 27), -500, 500, false, "Integer_Unsorted_2^27");
//        gtc.generate((int) Math.pow(2, 28), -500, 500, false, "Integer_Unsorted_2^28");
//        gtc.generate((int) Math.pow(2, 29), -500, 500, false, "Integer_Unsorted_2^29");

// TODO: short[] fixed the issue, maybe note with memory issue discussion
//        gtc.generate((int) Math.pow(2, 30), -500, 500, false, "Integer_Unsorted_2^30");