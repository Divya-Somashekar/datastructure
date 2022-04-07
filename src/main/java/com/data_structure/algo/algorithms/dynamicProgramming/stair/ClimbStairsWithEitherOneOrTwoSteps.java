package com.data_structure.algo.algorithms.dynamicProgramming.stair;

public class ClimbStairsWithEitherOneOrTwoSteps {
  public static void main(String[] args) {
    System.out.println(climbStairsUsingRecurssion(6));
    System.out.println(climbStairsUsingDynamicProgramming(6));
    //We can optimize the space used in method 2 by storing the previous two numbers only because that is all we need to get the next Fibonacci number in series.
    System.out.println(climbStairsSpaceOptimised(6));
    //n =   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    //sol = 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
  }

  private static int climbStairsUsingDynamicProgramming(int n) {
    int[] f = new int[n + 2];
    f[0] = 0;
    f[1] = 1;

    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  private static int climbStairsUsingRecurssion(int n) {
    if (n <= 1) {
      return n;
    }
    return climbStairsUsingRecurssion(n - 1) + climbStairsUsingRecurssion(n - 2);
  }

  public static int climbStairsSpaceOptimised(int n) {
    int first = 0;
    int second = 1;
    int temp;
    if (n == 0) {
      return first;
    }
    if (n == 1) {
      return second;
    }

    for (int i = 2; i <= n; i++) {
      temp = first + second;
      first = second;
      second = temp;
    }
    return second;
  }
}
