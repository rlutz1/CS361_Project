# CS361_Project


## How to Run 

All test cases will be run using the included `run.jar` file at the top of this directory. If run by itself with no arguments, it will ALL 4 sorts, running integer cases first, then floating point, using completely random test cases for each. The run will execute by default with 0 numbers and 1 test case iteration. This can be seen by running:

`java -jar run.jar`

The following command line arguments can be used to customize the run as needed:

+ `-pa true` will turn on the printing of values in the array. This is off by default, and it is recommended to keep it off for large test cases. It will print the array prior to sorting and then again once it is sorted, all numbers separated by a single space.
+ `-pt true` will turn on the printing of the time it took to sort the array in ms. This is off by default.
+ `-s true` will enable the seeding of the random case generator. Especially useful for seeing all sorting algorithms run on the same randomly generated test case. The seed number is, by default, 42.
+ `-p2 ` followed by any integer >= 0 will run the test case with a power of 2
  + Example: `-p2 3` -> run with 8 numbers in the sorting array.
+ `-n ` followed by any integer >= 0 will run the test case with the specified number.
  + Example: `-n 3` -> run with 3 numbers in the sorting array.
+ `-r ` followed by any integer >= 0 will specify the number of test cases to run.
  + Example: `-r 3` -> run the sorting algorithms 3 times on a distinct, n-sized array.

For the large test cases, you will likely need to increase the heap size (2^29-2^30 specifically). Therefore, all benchmarking commands below are given with `-Xmx12g` appended. You may remove this for all smaller test cases, but it is necessary to ensure the larger ones will run if the tester plans on doing so.


The following are test cases the can be run in the command line. Feel free to play around with the arguments! 

Quick note: the parsing of input is not highly regulated, so likely an error will be thrown by default on any strange input on command line, or the argument will be ignored if unrecognized. All parsing can be viewed in the project files /src/Driver.java.

### General Testing of Sort Capability

+ Run with 0 numbers:
  `java -jar run.jar -pa true -pt true -s true -n 0`
+ Run with 7 numbers:
  `java -jar run.jar -pa true -pt true -s true -n 7`
+ Run with 24 numbers
  `java -jar run.jar -pa true -pt true -s true -n 24`
+ Run with 100 numbers
  + Printing of array on:
    `java -jar run.jar -pa true -pt true -s true -n 100`
  + Printing of array off:
    `java -jar run.jar -pt true -s true -n 100`
+ Run with completely different test cases, each algorithm runs 3 times:
  `java -jar run.jar -pa true -pt true -n 7 -r 3`

### Testing with Specified Benchmarks

The following commands will run benchmarks 2^20 - 2^30, line by line. The printing the array will be turned off in the command (but you can turn it on if you're brave, of course). Printing the time it took to sort is turned on. All commands include the command to increase the java heap size, but this is technically only needed in the 2^29 and 2^30 cases (at least on the machine the benchmarks for this project ran on).

`java -Xmx12g -jar run.jar -pt true -p2 20`
`java -Xmx12g -jar run.jar -pt true -p2 21`
`java -Xmx12g -jar run.jar -pt true -p2 22`
`java -Xmx12g -jar run.jar -pt true -p2 23`
`java -Xmx12g -jar run.jar -pt true -p2 24`
`java -Xmx12g -jar run.jar -pt true -p2 25`
`java -Xmx12g -jar run.jar -pt true -p2 26`
`java -Xmx12g -jar run.jar -pt true -p2 27`
`java -Xmx12g -jar run.jar -pt true -p2 28`
`java -Xmx12g -jar run.jar -pt true -p2 29`
`java -Xmx12g -jar run.jar -pt true -p2 30`
