package com.data_structure.algo.algorithms.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationOfPhoneNumber {
  public static void main(String[] args) {
    String input = "23";
    Map<Integer, String> map = new HashMap<>();
    fillMapOfNumberVsItsValue(map);
    Queue<String> output = getAllLetterCombination(input, map);
    while (!output.isEmpty()) {
      System.out.println(output.remove());
    }
  }

  private static Queue<String> getAllLetterCombination(String input, Map<Integer, String> map) {
    Queue<String> output = new LinkedList<>();
    for (int i = 0; i < input.length(); i++) {
      backTrack(input, map, output, i, Character.getNumericValue(input.charAt(i)));
    }
    return output;
  }

  private static void backTrack(String input, Map<Integer, String> map, Queue<String> output, int currInputIndex, int currInput) {
    if (input.length() == 0) {
      return;
    }
    output.add("");
    while (output.peek().length() == currInputIndex) {
      String p = output.remove();
      for (Character c : map.get(currInput).toCharArray()) {
        output.add(p + c);
      }
    }
  }

  private static void fillMapOfNumberVsItsValue(Map<Integer, String> map) {
    map.put(1, "");
    map.put(2, "abc");
    map.put(3, "def");
    map.put(4, "ghi");
    map.put(5, "jkl");
    map.put(6, "mno");
    map.put(7, "pqrs");
    map.put(8, "tuv");
    map.put(9, "wxyz");
  }
}
