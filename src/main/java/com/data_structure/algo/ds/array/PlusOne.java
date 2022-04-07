package com.data_structure.algo.ds.array;

public class PlusOne {
  public static void main(String[] args) {
    // int[] input = new int[] {9, 9, 9, 9};
    // int[] input = new int[] {1, 2, 3};
    // int[] input = new int[] {9, 9, 1, 9};
    int[] input = new int[] {9, 1, 9, 9};
    int[] result = getPlusOneResult(input);
    for (Integer i : result) {
      System.out.print(i + " ");
    }
  }

  private static int[] getPlusOneResult(int[] input) {
    for (int i = input.length - 1; i >= 0; i--) {//iterate each element from right to left
      if (input[i] < 9) {//
        input[i]++;
        return input;
      }
      input[i] = 0;
    }

    int[] newNumber = new int[input.length + 1];//This is for case 9, 99, 999, 9999
    newNumber[0] = 1;//just make the first element 1 and all others are zero by default

    return newNumber;
  }
}
