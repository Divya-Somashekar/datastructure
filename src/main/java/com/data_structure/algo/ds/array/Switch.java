package com.data_structure.algo.ds.array;

public class Switch {
  /*
  * string of bulbs, each character is representation of bulb state [on or off]
  * 0 means on and x is off
  * one bulb is on that's enough for thr room to enlight
  * every bulb will toggle till any one bulb is on
  * you can toggle switch k no of time
  *
  * eg: k = 2 , "00x0x"
  * when k = 1 switch toggle and become "xx00x" 1st bulb is on make it off, 2nd bulb is on make in off, 3rd bulb is off make it on. enough stop here
  * when k = 2 input is "xx00x" 1st bulb is of make it on that's enough stop here.
  * */
  public static void main(String[] args) {
    System.out.println(solve(2, "00x0x"));
  }

  private static String solve(int noOfTimeToToggle, String input) {
    for (int i = 0; i < noOfTimeToToggle; i++) {
      int index = 0;
      for (Character c : input.toCharArray()) {
        index++;
        if (c == 'x') {
          c = '0';
          input = input.substring(0, index - 1) + c + "" + input.substring(index);
          break;
        } else {
          c = 'x';
          input = input.substring(0, index - 1) + c + "" + input.substring(index);
        }
      }
    }
    return input;
  }
}
