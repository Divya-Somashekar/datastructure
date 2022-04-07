package com.data_structure.algo.algorithms.greedy;

public class Train {
  public static void main(String[] args) {
    int[] arrival = new int[] {1, 3, 0, 5, 8, 5};
    int[] departure = new int[] {2, 4, 6, 7, 9, 9};
    System.out.println(getMaxPlatformNeeded(arrival, departure));
  }

  private static int getMaxPlatformNeeded(int[] arrival, int[] departure) {
    if (arrival.length == 0) {
      return 0;
    }
    if (arrival.length == 1) {
      return 1;
    }
    int maxTrainInPlatform = 0;
    int currTrainInPlatform = 0;
    int i = 0;
    int j = 0;
    for (int arr = 0; arr < arrival.length; arr++) {
      if (arrival[i] < departure[j]) {
        currTrainInPlatform++;
        i++;
      } else {
        currTrainInPlatform--;
        j++;
      }
      maxTrainInPlatform = Math.max(currTrainInPlatform, maxTrainInPlatform);
    }
    return maxTrainInPlatform;
  }

}
