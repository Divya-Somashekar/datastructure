package com.data_structure.algo.algorithms.dynamicProgramming;

public class HouseRobbery {
  //You are a robber and planning to rob house along street, each house has certain amount
  //Condition : you can not rob adjacent house
  public static void main(String[] args) {
    //int[] input = new int[] {2, 7, 9, 3, 1};//12 <2, 7, 11, 11, 12>
    //int[] input = new int[] {6, 7, 1, 30, 8, 2, 4};//41 <6, 7, 7, 37, 37, 39, 41>
    int[] input = new int[] {20, 5, 1, 13, 6, 11, 40};//73 <20, 20, 21, 33, 33, 44, 73>
    System.out.println(getMaxAmountRobbed(input));
  }

  private static int getMaxAmountRobbed(int[] input) {
    if (input == null || input.length == 0) {
      return 0;
    }
    if (input.length == 1) {
      return input[0];
    }
    if (input.length == 2) {
      return Math.max(input[0], input[1]);
    }
    int[] dp = new int[input.length];
    dp[0] = input[0];
    dp[1] = Math.max(input[0], input[1]);
    for (int i = 2; i <= input.length - 1; i++) {
      dp[i] = Math.max(input[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[input.length - 1];
  }
}
