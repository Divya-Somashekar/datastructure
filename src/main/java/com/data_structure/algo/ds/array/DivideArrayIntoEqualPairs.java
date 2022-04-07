package com.data_structure.algo.ds.array;

import java.util.HashSet;
import java.util.Set;

public class DivideArrayIntoEqualPairs {
  public static void main(String[] args) {
    int[] input = new int[]{3,2,3,2,2,2};
    System.out.println(isDivisionPossible(input));
  }

  private static boolean isDivisionPossible(int[] input) {
    Set<Integer> set = new HashSet<>();
    for(Integer i : input){
      if(!set.add(i)){
        set.remove(i);
      }
    }
    return set.isEmpty();
  }
}
