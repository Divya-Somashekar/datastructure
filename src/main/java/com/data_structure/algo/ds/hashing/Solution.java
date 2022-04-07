package com.data_structure.algo.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Solution {
  public static void main(String[] args) {
    String[] test = {"test1a", "test2a", "test2b", "test1b", "test1c", "test3"};
    String[] results = {"Wrong answer", "OK", "OK", "Runtime error", "OK", "Time limit exceeded"};
    System.out.println(solution(test, results));// 100*1/3
  }

  public static float solution(String[] t, String[] r) {
    int ans = 0;
    int totalTest = 0;
    Map<String, List<String>> mapofGroupNameAndItsResults = new HashMap<>();
    for (int i = 0; i < t.length; i++) {
      String test = t[i];
      char[] testChars = test.toCharArray();
      char lastCharacter = test.charAt(testChars.length - 1);

      if (!Character.isDigit(lastCharacter)) {
        String groupName = test.substring(0, testChars.length - 1);
        if (mapofGroupNameAndItsResults.get(groupName) == null) {
          ArrayList<String> results = new ArrayList<>();
          results.add(r[i]);
          mapofGroupNameAndItsResults.put(groupName, results);
        } else {
          List<String> list = mapofGroupNameAndItsResults.get(groupName);
          list.add(r[i]);
          mapofGroupNameAndItsResults.put(groupName, list);
        }
      } else {
        totalTest += 1;
        if (r[i].equals("OK")) {
          ans += 1;
        }
      }
    }
    for (Map.Entry<String, List<String>> entry : mapofGroupNameAndItsResults.entrySet()) {
      Iterator<String> iterator = entry.getValue().iterator();
      if (iterator.hasNext()) {
        if(!iterator.next().equalsIgnoreCase("OK")) {
          break;
        }
      }
      ans += 1;
    }

    return (100 * ans / (totalTest + mapofGroupNameAndItsResults.size()));
  }
}
