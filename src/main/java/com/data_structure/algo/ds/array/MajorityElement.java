package com.data_structure.algo.ds.array;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
  //The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.
  public static void main(String[] args) {
    int[] input = new int[] {2, 2, 1, 1, 1, 2, 2};
    System.out.println(getMajorityElementUsingSorting(input));
    System.out.println(getMajorityElementUsingHashMap(input));
    System.out.println(getMajorityElement(input));
  }

  private static int getMajorityElementUsingSorting(int[] input) {//Time :O(nlogn) && Space :O(1)
    Arrays.sort(input);
    return input[input.length / 2];  // as they have mention that there exist majority element for sure
  }

  private static int getMajorityElementUsingHashMap(int[] input) {//Time : O(n) && Space:O(n)
    HashMap<Integer, Integer> fmap = new HashMap<>();  //fmap: frequency map
    for (int num : input) {
      fmap.put(num, fmap.getOrDefault(num, 0) + 1);
    }

    for(int num : fmap.keySet()) {
      if (fmap.get(num) > input.length / 2) {
        return num;
      }
    }
    return -1;
  }

  private static int getMajorityElement(int[] input) {//Time : O(N) && Space:O(1)
    int count = 0;
    int major = input[0];
    for (int i : input) {
      if (count == 0) {
        major = i;
        count++;
      } else if (i == major) {
        count++;
      } else {
        count--;
      }
    }
    return major;
  }

}
