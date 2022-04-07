package com.data_structure.algo.ds.string;

public class ReverseWordInString {
  public static void main(String[] args) {
    String input = "Hi Divya How are u    ";
    System.out.println(getTheReversedWords(input));
  }

  private static StringBuffer getTheReversedWords(String input) {
    int i = input.length() - 1;
    int j = input.length() - 1;
    StringBuffer ans = new StringBuffer();
    while (i >= 0) {
      if (input.charAt(i) == ' ') {
        j = i;
      }
      while (i >= 0 && input.charAt(i) != ' ') {
        i--;
      }
      if (ans.length() > 0) {
        ans.append(' ');
      }
      for (int k = i + 1; k < j; k++) {
        ans.append(input.charAt(k));
      }
    }
    return ans;
  }
}
