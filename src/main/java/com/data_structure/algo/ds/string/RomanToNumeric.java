package com.data_structure.algo.ds.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumeric {
  public static void main(String[] args) {
    System.out.println(romanToInt("LVIII"));
  }

  public static int romanToInt(String s) {
    Map<Character, Integer> map = getMapOfRomanNumtoNumeric();
    int res = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
        res -= map.get(s.charAt(i));
      } else {
        res += map.get(s.charAt(i));
      }
    }
    return res + map.get(s.charAt(s.length() - 1));
  }

  private static Map<Character, Integer> getMapOfRomanNumtoNumeric() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    return map;
  }
}
