package com.data_structure.algo.algorithms.dynamicProgramming;

public class CoinChange {
  public static void main(String[] args) {
    int amount = 15;
    int[] possibleChanges = {2, 3, 7};
    System.out.println(getPossibleWaysUsingRecurssion(amount, possibleChanges));
    System.out.println("--------------------------");
    System.out.println(getPossibleWaysOptimisedSolution(amount, possibleChanges));
  }

  private static int getPossibleWaysOptimisedSolution(int amount, int[] possibleChanges) {
    int[] arr = new int[amount + 1];
    int minCoins = 0;
    arr[0] = 1;
    for (int i = 1; i < amount + 1; i++) {
      minCoins = Integer.MAX_VALUE;
      for (Integer coin : possibleChanges) {
        if (i - coin >= 0) {
          minCoins = Math.min(minCoins, 1 + arr[i - coin]);
        }
      }
      arr[i] = minCoins;
    }
    return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
  }

  private static int getPossibleWaysUsingRecurssion(int amount, int[] possibleCoins) {
    if (amount == 0) {
      return 0;
    }
    int minCoins = Integer.MAX_VALUE;
    for (Integer coin : possibleCoins) {
      if ((amount - coin) >= 0) {
        minCoins = Math.min(minCoins, 1 + getPossibleWaysUsingRecurssion(amount - coin, possibleCoins));
      }
    }
    return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
  }
}
