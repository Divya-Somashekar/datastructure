package com.data_structure.algo.ds.array;

public class SearchInsertAtPosition {
  public static void main(String[] args) {
    int[] input = new int[]{1,3,5,6};//sorted Array
    int n = 3;//insert n in correct place
    System.out.println(searchInsert(input, n));
  }

  //You must write an algorithm with O(log n) runtime complexity.
  public static int searchInsert(int[] input, int target) {//Return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    int index = 0;
    for(int i = 0; i < input.length; i++){
      index++;
      if(input[i] >= target){
        return i;
      }
    }
    return index;
  }
}
