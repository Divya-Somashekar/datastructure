package com.data_structure.algo.ds.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[]{1,2,3,1}));
  }

  private static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(Integer i: nums){
      if(set.contains(i)){
        return true;
      }else{
        set.add(i);
      }
    }
    return false;
  }
}
