# gridTest
grid test - people count
## Benchmark results:
tested on intel i5 3.10 GHz with 2 cores

1. sample data with 10mln recs and 500 attrs  
  Generated in 2534 ms  
  Counting average time: 150 ms on 1 core 61 ms on 2 cores  
2. sample data with 10mln recs and 63 attrs  
  Generated in 437 ms  
  Counting average time: 49ms on 1 core, 28 ms on 2 cores  

## conclusion
it can be easily scaled by adding new cores, it is linear
Algorithm complexity is O(n) so total time should be better than T1/core_number (where T1 is time on one core)
The number of attributes also affects speed. The attributes are kept as bit in long data type so speed for 1-64 is the same, but adding more will increase, in my test 512 attrs is about 2 times slower




