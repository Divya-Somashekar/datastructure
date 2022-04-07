package com.data_structure.algo.ds.string;

public class ReverseString {
  public static void main(String[] args) {
    String str = "Divya";
    System.out.println(getReversedString(str));
  }

  private static String getReversedString(String str) {
    char[] chars = str.toCharArray();
    int i = 0;
    int j = str.length()-1;
    while (i < j){
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
      i++;
      j--;
    }
    return String.valueOf(chars);
  }
}
