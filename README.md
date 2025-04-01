# CS361_Project

## Notes
+ all of them: implement as short[], int[] would take more careful planning because of memory issues.
+ *mergesort*: we have an issue with 2^30 and getting memory space for the merge. temp arrays WILL NOT cut it with that size. consider special case for in place merging OR other options. check on this and see if the rabbit hole is worth it. 2^29 works just fine, takes ~60 seconds from first run.
+ *quicksort*: well, fuck, stack overflow error on any case > 2^23. that's an issue. make sure its actually an input size issue and not logic, but seems to be fine with smallers. confirmed, all 2^24 and higher fail with a stack overflow. todo: try an iterative version over recursive. see if that solves the issue.
+ process thoughts
  + have some sort of iteration. read in the file ONCE. maybe in the driver? idk, but have a loop at least that reads in the data and re sorts it. have it run like. 30 - 50 times? enough to get a clear average of the time it takes to sort via implementation. record all that data.
  + run test cases on different days. shut things down on laptop. MARKEDLY different performance time when my cpu is cleared up, so def note those outliers and take an array of data.

CS361 project files
