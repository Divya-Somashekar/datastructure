package com.data_structure.algo.ds.string;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
  public static void main(String[] args) {
    String str = "[{(})]";
    System.out.println(isBalanced(str));
  }

/*  private static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (stack.empty()) {
        return false;
      } else if (c == ')' && stack.pop() != '(') {
        return false;
      } else if (c == '}' && stack.pop() != '{') {
        return false;
      } else if (c == ']' && stack.pop() != '[') {
        return false;
      }
    }
    return stack.empty();
  }*/
  private static boolean isBalanced(String str) {
    if (str.isEmpty()) {
      return true;
    }
    if (str == null || str.length() % 2 != 0) {
      return false;
    }
    Map<Character, Character> map = getHashTable();

    char[] chars = str.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      if (!(c == '{' || c == '(' || c == '[' || c == ']' || c == ')' || c == '}')) {//use BiMap
        return false;
      }
      if (map.get(c) != null) {
        if (!stack.empty() && stack.peek().equals(map.get(c))) {
          stack.pop();
        } else {
          stack.push(c);
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }

  private static Map<Character, Character> getHashTable() {
    Map<Character, Character> map = new Hashtable<>();
    map.put(']', '[');
    map.put(')', '(');
    map.put('}', '{');
    return map;
  }
}