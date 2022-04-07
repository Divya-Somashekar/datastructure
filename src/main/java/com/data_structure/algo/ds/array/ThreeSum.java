package com.data_structure.algo.ds.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
    int[] input = new int[] {-1, 0, 1, 2, -4, -1};
    //getThreeSum(input);
    System.out.println();
  }

  private static List<List<Integer>> getThreeSum(int[] input) {
    Arrays.sort(input);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < input.length - 2; i++) {
      if (i == 0 || (i > 0 && input[i] != input[i - 1])) {
        int lo = i + 1;
        int hi = input.length - 1;
        int sum = 0 - input[i];
        while (lo < hi) {
          if (input[lo] + input[hi] == sum) {
            res.add(Arrays.asList(input[i], input[lo], input[hi]));
            while (lo < hi && input[lo] == input[lo + 1]) {
              lo++;
            }
            while (lo < hi && input[hi] == input[hi - 1]) {
              hi--;
            }
            lo++;
            hi--;
          } else if (input[lo] + input[hi] < sum) {
            lo++;
          } else {
            hi--;
          }
        }
      }
    }
    return res;
  }
}
