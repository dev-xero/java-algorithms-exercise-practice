# Java Algorithms Exercise Practice
☕ Exercise solutions for chapter 1.1 written in Java

## Algorithms Implemented
1. isBetweenZeroAndOne()
2. toBinaryString()
3. printTwoDmBooleanArray()
4. printTwoDmIntArray()
5. printIntArray()
6. matrixTransposition()
7. lg()
8. Fibonacci.Fib()
9. Fibonnaci.FastFib()
10. fact()
11. binarySearch()
12. bruteForceSearch()

## Code Examples
We are asked in exercise (1.1.19) to improve the fib method to use some sort of cache. This one is particularly interesting because it runs in O(1) time provided that the cache contains the previous two sequences. Generating the previous sequences is done using loops.
```java
    // dynamic programming and memoization
    public static long FastFib(int N, HashMap<Integer, Long> cache) {
        if (N == 0) {
            cache.put(N, 0L);
            return 0;
        }

        if (N == 1) {
            cache.put(N, 1L);
            return 1;
        }

        cache.put(N, cache.get(N - 2) + cache.get(N - 1));
        return cache.get(N);
    }
```

## Python Implementation
I've implemented the same methods but in Python over [here](https://github.com/dev-xero/python-algorithms-exercise-practice), if you're interested.
