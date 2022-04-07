package com.data_structure.algo.ds.string;

public class RepeatedCharacter {

  public static void main(String[] args) {
    String str = "aaaabbddddaaad";
    //expected output- a4b2d3a3d1
    System.out.println(getTheRepeatedCharacterOutput(str));
  }

  private static String getTheRepeatedCharacterOutput(String input) {
    if(input.isEmpty())return "";
    StringBuilder output = new StringBuilder();
    char[] chars = input.toCharArray();
    char currChar = chars[0];//a
    int count = 1;//1
    for(int i = 1; i < chars.length; i++){
      if(currChar!=chars[i]){//
        output.append(chars[i-1]);
        output.append(count);
        count = 1;
        currChar = chars[i];
      } else {
        count++;//2, 3, 4
      }
    }
    return String.valueOf(output);
  }
}
