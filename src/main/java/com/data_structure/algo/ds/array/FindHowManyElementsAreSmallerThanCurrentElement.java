package com.data_structure.algo.ds.array;

import java.util.Arrays;

public class FindHowManyElementsAreSmallerThanCurrentElement {
  public static void main(String[] args) {
    int[] input = new int[] {8, 1, 2, 2, 3};
    System.out.println(Arrays.toString(getAns(input)));
  }

  private static int[] getAns(int[] input) {
    int[] buck = new int[101];

    for (int value : input) {
      buck[value] += 1;
    }
    for(int j=1; j<= 100; j++) {
      buck[j] += buck[j-1];
    }
    for(int k=0; k< input.length; k++) {
      int pos = input[k];
      input[k] = pos==0 ? 0 : buck[pos-1];
    }

    return input;
  }
}
