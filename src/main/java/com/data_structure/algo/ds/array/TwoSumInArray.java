package com.data_structure.algo.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumInArray {

  /*
  *
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
* */

  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    int[] theTwoSum = findTheTwoSum(arr, target);
    System.out.println(theTwoSum[0]);
    System.out.println(theTwoSum[1]);

  }

  private static int[] findTheTwoSum(int[] arr, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> mapOfValueAndItsPosition = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (mapOfValueAndItsPosition.containsKey(target - arr[i])) {
        ans[0] = i;
        ans[1] = mapOfValueAndItsPosition.get(target - arr[i]);
        return ans;
      } else {
        mapOfValueAndItsPosition.put(arr[i], i);
      }
    }
    return ans;
  }
}
