package com.data_structure.algo.ds.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfStringHasUniqueCharacters {
  public static void main(String[] args) {
    System.out.println("Give string "+ (isUnique("abcdefabcc") ? "has unique characters" : "does not has unique characters"));
    List<String> list = new ArrayList<>();

  }

  private static boolean isUnique(String input) {
    char[] chars = input.toCharArray();
    int inputSize = input.length();
    Set<Character> set = new HashSet<>();
    for(Character c: chars){
      set.add(c);
    }
    return inputSize == set.size();
  }
}
