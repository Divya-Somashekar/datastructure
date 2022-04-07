package com.data_structure.algo.ds.stack;

import java.util.Stack;

public class LongestValidBraket {
  public static void main(String[] args) {
    //   "Input: s = \")()()))))()()()))\" o=5, c=12"));
    System.out.println(getLongestValidBracket(")()()))))()()()))"));
  }

  private static int getLongestValidBracket(String str) {
    Stack<Integer> st = new Stack<>();
    int maxLength = 0;
    int startIndex = -1;
    for (int currIndex = 0; currIndex < str.length(); currIndex++) {
      if (str.charAt(currIndex) == '(') {
        st.push(currIndex);
      } else {
        if (st.isEmpty()) {
          startIndex = currIndex;
        } else {
          st.pop();
          if (st.isEmpty()) {
            maxLength = Math.max(maxLength, currIndex - startIndex);
          } else {
            maxLength = Math.max(maxLength, currIndex - st.peek());
          }
        }
      }
    }
    return maxLength;
  }
}
