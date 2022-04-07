package com.data_structure.algo.ds.bitmapping;

public class NoOfOnes {
  public static void main(String[] args) {
    System.out.println(hammingWeight(2));
  }
  public static int hammingWeight(int n) {
    int count = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        count++;
      }
      mask <<= 1;
    }
    return count;
  }
}
