package com.data_structure.algo.ds.array;

public class LargestSumOfContiguousArray {
  public static void main(String[] args) {
    int[] arr = {-2, -3, 4, -1, -2, 1 ,5, -3};
    System.out.println(printLargestSum(arr));
  }

  private static int printLargestSum(int[] arr) {
    int max_so_far = Integer.MIN_VALUE;
    int max_index = 0;
    for(Integer i : arr){
      max_index += i;
      if(max_so_far < max_index){
        max_so_far = max_index;
      }
      if(max_index < 0){
        max_index = 0;
      }
    }
    return max_so_far;
  }
}
