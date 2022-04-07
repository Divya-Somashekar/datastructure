package com.data_structure.algo.algorithms.backtracking.subset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllPossibleSubSet {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    List<List<Integer>> subsets = getSubsets(arr);
    for (List<Integer> subset : subsets) {
      Iterator<Integer> integers = subset.iterator();
      System.out.print("[ ");
      while (integers.hasNext()) {
        System.out.print(integers.next() + " ");
      }
      System.out.println("]");
    }
  }

  private static List<List<Integer>> getSubsets(int[] input) {
    List<List<Integer>> output = new ArrayList<>();// will have 2 to the power of n elements
    for (int lengthOfSubset = 0; lengthOfSubset <= input.length; lengthOfSubset++) {
      backtrack(0, new ArrayList<>(), input, lengthOfSubset, output);//lengthOfSubset is passed only for filling curr list to output
    }

    return output;
  }

  private static void backtrack(int subsetIndex, ArrayList<Integer> curr, int[] input, int lengthOfSubset,
                                List<List<Integer>> output) {
    if (curr.size() == lengthOfSubset) {
      output.add(new ArrayList<>(curr));
      return;
    }
    for (int i = subsetIndex; i < input.length; i++) {
      curr.add(input[i]);
      backtrack(i + 1, curr, input, lengthOfSubset, output);
      curr.remove(curr.size() - 1);
    }
  }
}
