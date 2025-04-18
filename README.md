# CS361_Project

Default heap size command:
-Xmx6g
-Xmx12g -- for floats (ms and ts specifically due to 32 bit min)

## TODO
+ make sure all sorts are randomly generating numbers--allow for seeding if wanting to replicate the same test case
+ look to rqs integer test in driver for easy format
+ for loop all of them
+ run and don't use computer for anything else
+ let's get at least 100 runs for each case. take weekend time to run for the large inputs.
+ this will clarify all final needs when running all of them. -- document 
+ try QHS with ints. it should work. note any changes in performance
  + on that note, keep testing it, limit of < 2^29 should be fine but i clearly had a reason at the time for 2^28 so SUSPICIOUS
+ is math.pow an issue? if so: for loop it up
+ implement min in timsort.
+ change order of log and unsorted error
+ change all double tests to write to double file
+ just generally clean up the doubles
+ add Int to all intsorts or combine into one file.
+ can run with float mergesort 2^30 with 12gb to vm
  + change all doubles to floats, test, and run benchmarks
  + 


## Notes
+ all of them: implement as short[], int[] would take more careful planning because of memory issues.
+ *mergesort*: 
  + ~~progress: i can increase my jvm heapsize to abt 6gb (maybe less for short, unsure yet), and we can sort the 2^30! so, time to ask humayra about this issue tomorrow 4/8 because unclear if that's acceptable or not. need to discuss the same problem with the doubles/floats bc floats are a min 32 bits, and that will cause issues.~~
    + ~~but, i can at least be testing, the more pertinent question is what on earth is going on with whoever would be testing it.~~
    + ~~yup, crashed with 10g in heap. jesus. definitely going to have to talk with her on this. best case, i may be able to downgrade to 32 bit floats and have the heap up high enough.~~ ~~running with the doubles now. likely going to be a big problem there and will HAVE to downgrade to floats.~~
      + ~~we have an issue with 2^30 and getting memory space for the merge. temp arrays WILL NOT cut it with that size. consider special case for in place merging OR other options. check on this and see if the rabbit hole is worth it. 2^29 works just fine, takes ~60 seconds from first run.~~~~
+ *quicksort*: 
  + QS update: changed the range to ints (need to set vm to -Xmx6g to load 2^30 ints into ram, but otherwise fine.) noticed that the range of numbers needs to be higher. the duplicates in the small range was causing the stack over flow and instituting the worst case scenario (each sub prob turned into n - 1 in size instead of n/2)
    + also try on a different machine.
+ *quad heapsort*: neat! this one will work for all cases! 
  + things to note:
    + input caps at 2^30. this is due to integer overflow for child math. we do not attempt child math for any parent index >= 2^28. this is because the max signed int is 2^31. thus, the child of 2^28 would be 2^31 + 1 -> 4, which would overflow to -2^31. this is a limitation worth mentioning. works with all cases thus far with that simple 2^28 check.
    + this is the only one so far that has simply just worked on my machine out of the box (once overflow logic in place). favorite so far for that reason ;)
    + i wonder if a normal heap would work. hypothetically it could have a similar height to quicksort execution tree-ish. maybe a good way to see if my machine is the struggle versus logic? hm.
    + ran with all test case files. tested with cases
      + 0 numbers
      + 1 number
      + ascending list
      + descending list
      + non-power-of-two cases (num numbers == 17, 13, etc.)
+ *timsort*:
  + things to note
    + also breaking on 2^30 with out of memory error. so, it's the merge temp array. todo is to experiment with an in place merge and see if that will work, and then that should fix the three way ms as well.
+ process thoughts
  + have some sort of iteration. read in the file ONCE. maybe in the driver? idk, but have a loop at least that reads in the data and re sorts it. have it run like. 30 - 50 times? enough to get a clear average of the time it takes to sort via implementation. record all that data.
  + run test cases on different days. shut things down on laptop. MARKEDLY different performance time when my cpu is cleared up, so def note those outliers and take an array of data.
  + run with the following tests:
    + 0 numbers
    + 1 number
    + ascending list
    + descending list
    + non-power-of-two cases (num numbers == 17, 13, etc.)
    + randomized lists/other test cases of the same sizes *TODO!!!!!*
    + doubles/floats

CS361 project files
