# CS361_Project

## Notes
+ all of them: implement as short[], int[] would take more careful planning because of memory issues.
+ *mergesort*: we have an issue with 2^30 and getting memory space for the merge. temp arrays WILL NOT cut it with that size. consider special case for in place merging OR other options. check on this and see if the rabbit hole is worth it. 2^29 works just fine, takes ~60 seconds from first run.
+ process thoughts
  + have some sort of iteration. read in the file ONCE. maybe in the driver? idk, but have a loop at least that reads in the data and re sorts it. have it run like. 30 - 50 times? enough to get a clear average of the time it takes to sort via implementation. record all that data.

CS361 project files
