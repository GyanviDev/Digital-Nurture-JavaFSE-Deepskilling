# Financial Forecasting Analysis

## 1. Understanding Recursion
Recursion is a programming technique where a method calls itself to solve a smaller instance of the same problem. It simplifies code by breaking down complex iterative processes (like compounding interest over time) into a clean base case (when periods = 0) and a recursive step.

## 2. Time Complexity Analysis
* **Standard Recursion:** The time complexity of the standard recursive approach for future value calculation is **O(n)**, where 'n' is the number of periods, because it makes one recursive call per period. However, in more complex forecasting models (like finding Fibonacci sequences for market trends), standard recursion without caching can degrade to an exponential time complexity **O(2^n)** due to overlapping subproblems. 

## 3. Optimization Strategy
To optimize recursive solutions and avoid excessive computation, we implement **Memoization**. This involves creating a caching mechanism (like a `HashMap`) to store the results of expensive function calls. Before the recursive method executes, it checks the cache. If the result for that specific parameter exists, it returns the cached value in **O(1)** time, effectively pruning the execution tree and preventing redundant calculations.