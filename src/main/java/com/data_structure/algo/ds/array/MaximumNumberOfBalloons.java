package com.data_structure.algo.ds.array;

public class MaximumNumberOfBalloons {
  public static void main(String[] args) {
    String input = "lloo";
    System.out.println(getMaxNoOfBallons(input));
  }

  private static int getMaxNoOfBallons(String input) {
    int[] ans = new int[5];//b a l o n
    for(Character c : input.toCharArray()) {
      switch (c){
        case 'b':ans[0]++;break;
        case 'a':ans[1]++;break;
        case 'n':ans[2]++;break;
        case 'l':ans[3]++;break;
        case 'o':ans[4]++;break;
      }
    }
    int minOfSingleChar = Math.min(ans[0], Math.min(ans[1], ans[2]));
    int minOfRepeatedChar = Math.min(ans[3], ans[4]);
    return Math.min(minOfSingleChar, minOfRepeatedChar/2);
  }
}
