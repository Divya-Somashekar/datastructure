package com.data_structure.algo.ds.string;

/*
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.*/
public class LowestCommonPrefix {
  public static void main(String[] args) {
    String[] strings = {"flower", "flow", "flight"};
    System.out.println(getTheLowestCommonPrefix(strings));
  }

  private static String getTheLowestCommonPrefix(String[] strings) {
    if (strings.length == 0) {
      return "";
    }
    String prefix = strings[0];
    if (strings.length == 1) {
      return prefix;
    }
    for (int i = 1; i < strings.length; i++) {
      String currentString = strings[i];
      while (currentString.indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }

}