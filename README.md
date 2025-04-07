# CS361_Project

## Notes
+ all of them: implement as short[], int[] would take more careful planning because of memory issues.
+ *mergesort*: we have an issue with 2^30 and getting memory space for the merge. temp arrays WILL NOT cut it with that size. consider special case for in place merging OR other options. check on this and see if the rabbit hole is worth it. 2^29 works just fine, takes ~60 seconds from first run.
+ *quicksort*: well, fuck, stack overflow error on any case > 2^23. that's an issue. make sure its actually an input size issue and not logic, but seems to be fine with smallers. confirmed, all 2^24 and higher fail with a stack overflow. todo: try an iterative version over recursive. see if that solves the issue.
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
