package com.data_structure.algo.algorithms.dynamicProgramming.stocks;


public class StocksWithOneTransaction {
  public static void main(String[] args) {
    //int[] arr = new int[] {13, 40, 20, 15, 13, 10, 23, 8, 50, 100, 1};
    int[] arr = new int[] {100, 180, 260, 310, 40, 535, 695};
    System.out.println(getMaxProfitBruteForceApproach(arr));
    //System.out.println(getMaxProfit(arr));
    System.out.println(maxProfits(arr));
    System.out.println(maxProfit(arr));
  }

  private static int getMaxProfitBruteForceApproach(int[] prices) {
    //13, 40, 20, 15, 13, 10, 23, 8, 50, 100, 1
    int lsf = Integer.MAX_VALUE;
    int op = 0;
    int pist;

    for (int price : prices) {
      if (price < lsf) {
        lsf = price;
      }
      pist = price - lsf;
      if (op < pist) {
        op = pist;
      }
    }
    return op;
  }

  private static int getMaxProfit(int[] arr) {
    int maxProfit = 0;//13, 40-13=27, 27,-ve,
    for (int i = 1; i < arr.length; i++) {//13, 40, 20, 15,
      if (arr[i] > arr[i - 1]) {//13, 40< 13, 20<27,
        maxProfit += arr[i] - arr[i - 1];//13, 27
      }
    }
    return maxProfit;
  }

  public static int maxProfits(int[] prices) {
    int profit = 0;
    int len = prices.length;
    int iBuy = 0; // index when buying
    for(int i=0;i<len;i++){
      if(prices[iBuy] > prices[i]) iBuy = i;
      profit = Math.max(profit, prices[i] - prices[iBuy]);
    }
    return profit;
  }

  public static int maxProfit(int[] prices) {
    int buy = Integer.MAX_VALUE;
    int sell = 0;
    for (int price : prices) {
      buy = Math.min(buy, price);
      sell = Math.max(sell, price - buy);
    }
    return sell;
  }
}

