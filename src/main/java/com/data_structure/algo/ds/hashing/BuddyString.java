package com.data_structure.algo.ds.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {
  public static void main(String[] args) {
    String input1 = "ab";
    String input2 = "ba";
    //String input1 = "ab";
    //String input2 = "ba";//false
    //String input1 = "aa";
    //String input2 = "aa";//true
    System.out.println(buddyStrings(input1, input2));
  }

  public static boolean buddyStrings(String input1, String input2) {
    if (input1.length() != input2.length()) {
      return false;
    }
    if (input1.equals(input2)) {
      Set<Character> set = new HashSet<>();
      for (char c : input1.toCharArray()) {
        set.add(c);
      }
      return set.size() < input1.length();
    } else {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < input1.length(); i++) {
        if (input1.charAt(i) != input2.charAt(i)) {
          list.add(i);
        }
      }
      return list.size() == 2 && input1.charAt(list.get(0)) == input2.charAt(list.get(1)) &&
          input2.charAt(list.get(0)) == input1.charAt(list.get(1));
    }
  }
}
