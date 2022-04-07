package com.data_structure.algo.algorithms.dynamicProgramming.stair;

public class WaysToClimbStairsWithNoOfPossibleStepsGiven {
  public static void main(String[] args) {
    int n = 9;
    int[] possibleSteps = {2, 3, 4};
    System.out.println(getPossibleWaysUsingRecurssion(n, possibleSteps));
    System.out.println("--------------------------");
    System.out.println(getPossibleWaysOptimisedSolution(n, possibleSteps));
  }

  private static int getPossibleWaysOptimisedSolution(int n, int[] possibleSteps) {
    int[] arr = new int[n + 1];
    int noOfWays = 0;
    arr[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      noOfWays = 0;
      for (Integer step : possibleSteps) {
        if (i - step >= 0) {
          noOfWays += arr[i - step];
        }
      }
      arr[i] = noOfWays;
    }
    return noOfWays;
  }

  private static int getPossibleWaysUsingRecurssion(int n, int[] possibleSteps) {
    if (n == 0) {
      return 1;
    }
    int noOfWays = 0;
    for (Integer steps : possibleSteps) {
      if ((n - steps) >= 0) {
        noOfWays += getPossibleWaysUsingRecurssion(n - steps, possibleSteps);
      }
    }
    return noOfWays;
  }
}
