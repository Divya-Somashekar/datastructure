package com.data_structure.algo.algorithms.backtracking.subset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllPossibleSubSetSum {
  /*
  * Example 1:

Input: candidates = [2,3,6,7], target = 7

Output: [[2,2,3],[7]]

Explanation:

2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.

7 is a candidate, and 7 = 7.

These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
'
*
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1

Output: []
  * */

  public static void main(String[] args) {
    int[] input = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> listOfCombinations = getListOfCombinations(input, target);
    for (List<Integer> listOfCombination : listOfCombinations) {
      Iterator<Integer> integers = listOfCombination.iterator();
      System.out.print("[ ");
      while (integers.hasNext()) {
        System.out.print(integers.next() + " ");
      }
      System.out.println("]");
    }
  }

  private static List<List<Integer>> getListOfCombinations(int[] input, int target) {
    List<List<Integer>> output = new ArrayList<>();
    backtrack(input, target, output, new ArrayList<>(), 0);
    return output;
  }

  private static void backtrack(int[] input, int target, List<List<Integer>> output, ArrayList<Integer> curr, int firstIndex) {
    if(target == 0){
      output.add(new ArrayList<>(curr));
      return;
    } else if (target < 0) {
      return;
    }
    for(int i = firstIndex; i < input.length; i++){
      curr.add(input[i]);
      backtrack(input, target-input[i], output, curr, i);
      curr.remove(curr.size()-1);
    }
  }
}
