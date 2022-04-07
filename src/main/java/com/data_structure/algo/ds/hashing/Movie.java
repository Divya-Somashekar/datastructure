package com.data_structure.algo.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("John:Titanic");
    list.add("Remo:Hulk");
    list.add("Krish:END");
    list.add("Victor:Hulk");
    list.add("Victor:SpiderMan");
    list.add("Remo:Hulk");
    list.add("Ricky:Spy");
    list.add("Mohana:Iron Man");
    list.add("Rohan:Hulk");
    System.out.println(findingYLocation(list, "Hulk", 6));
  }

  public static String findingYLocation(List<String> arr, String movieName, int N) {
    String output = "NOT FOUND";
    Map<String, List<String>> movieVsName = fillMap(arr, new HashMap<>());
    if (movieVsName.get(movieName) != null) {
      List<String> nameList = movieVsName.get(movieName);
      int count = 0;
      for (String name : nameList) {
        count++;
        if (count == N) {
          output = name;
        }
      }
    } else {
      output = "NOT FOUND";
    }
    return output;
  }

  private static Map<String, List<String>> fillMap(List<String> arr, Map<String, List<String>> map) {
    for (String nameAndMovie : arr) {
      String[] moveAndNameSplit = nameAndMovie.split(":");
      if (map.get(moveAndNameSplit[1]) != null) {
        List<String> name = map.get(moveAndNameSplit[1]);
        name.add(moveAndNameSplit[0]);
        map.put(moveAndNameSplit[1], name);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(moveAndNameSplit[0]);
        map.put(moveAndNameSplit[1], list);
      }
    }
    return map;
  }
}
