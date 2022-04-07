package com.data_structure.algo.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllPossibleParentheses {
  public static void main(String[] args) {
    int n = 3;
    Iterator<String> iterator = getAllParentheses(n).iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static List<String> getAllParentheses(int n) {
    List<String> ans = new ArrayList<>();
    backTrack(ans, "", 0, 0, n);
    return ans;
  }

  private static void backTrack(List<String> ans, String curr, int open, int close, int max) {
    if (curr.length() == max * 2) {
      ans.add(curr);
      return;
    }
    if (open < max) {
      backTrack(ans, curr + "(", open + 1, close, max);
    }
    if (close < max) {
      backTrack(ans, curr + ")", open, close + 1, max);
    }
  }
}
