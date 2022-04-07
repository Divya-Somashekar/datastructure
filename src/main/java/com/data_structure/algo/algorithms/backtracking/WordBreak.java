package com.data_structure.algo.algorithms.backtracking;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
  public static void main(String[] args) {
    String input = "iloveicecreamandmango";
    List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
        "man", "mango", "icecream", "and",
        "go", "i", "love", "ice", "cream");
    wordBreak(dict, input);

    //System.out.println("\nSecond Test:");
    //String str2 = "ilovesamsungmobile";
    //wordBreak(str2.length(), dict, str2);

  }

  private static void wordBreak(List<String> dict, String input) {
    String ans = "";
    wordBreakUtil(input.length(), input, dict, ans);
  }

  private static void wordBreakUtil(int inputLength, String input, List<String> dict, String ans) {
    for (int i = 1; i <= inputLength; i++) {
      String prefix = input.substring(0, i);
      if (dict.contains(prefix)) {
        if (i == inputLength) {
          ans += prefix;
          System.out.println(ans);
          return;
        }
        wordBreakUtil(inputLength - i, input.substring(i, inputLength), dict, ans + prefix + " ");
      }
    }
  }
  //Time Complexity: O(2n). Because there are 2n combinations in The Worst Case.
  //Auxiliary Space: O(n2). Because of the Recursive Stack of wordBreakUtil() function in The Worst Case.

}
