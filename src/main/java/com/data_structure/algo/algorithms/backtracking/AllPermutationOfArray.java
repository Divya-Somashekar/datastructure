package com.data_structure.algo.algorithms.backtracking;

public class AllPermutationOfArray {
  public static void main(String[] args) {
    String input = "abc";//
    System.out.println("All possible permutation ");
    getPermutation(input.toCharArray(), "");

    System.out.println("All possible permutation ");
    getPermutationBySwaping(input, 0, input.length() - 1);

    System.out.println("All possible permutation ");
    getPermutationByIndex(input, "");
  }

  private static void getPermutation(char[] inputArray, String output) {
    if (output.length() == inputArray.length) {
      System.out.println(output);
      return;
    }
    for (char currChar : inputArray) {//0
      if (!output.contains("" + currChar)) {
        getPermutation(inputArray, output + currChar);
      }
    }
  }

  private static void getPermutationBySwaping(String str, int l, int r) {
    if (l == r) {
      System.out.println(str);
    } else {
      for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        getPermutationBySwaping(str, l + 1, r);
        str = swap(str, l, i);
      }
    }
  }

  private static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }

  private static void getPermutationByIndex(String input, String answer) {
    if (input.length() == 0) {
      System.out.print(answer + "  ");
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      String left_substr = input.substring(0, i);
      String right_substr = input.substring(i + 1);
      String rest = left_substr + right_substr;
      getPermutationByIndex(rest, answer + ch);
    }
  }

}
