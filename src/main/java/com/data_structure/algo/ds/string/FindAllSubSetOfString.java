package com.data_structure.algo.ds.string;

public class FindAllSubSetOfString {
  private static String[] findSubSet(String s) {
    String str = "FUN";
    int len = str.length();
    int temp = 0;
    String[] arr = new String[len * (len + 1) / 2];//n*(n+1)/2
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        arr[temp] = str.substring(i, j + 1);
        temp++;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    String[] subSet = findSubSet("FUN");
    for(String s: subSet) {
      System.out.println(s);
    }
  }
}
