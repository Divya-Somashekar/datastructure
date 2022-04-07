package com.data_structure.algo.algorithms.dynamicProgramming;

import java.util.TreeSet;

public class UglyNumber {
  public static void main(String[] args) {
    int n = 150;
    System.out.println(
        n + "th ugly no. is " + getNthUglyNoWithoutDynamicProgramming(n));//Time Complexity: -, Auxiliary Space: O(1)
    System.out.println(
        n + "th ugly no. is " + getNthUglyNoUsingDynamicProgramming(n));//Time Complexity: O(n), Auxiliary Space: O(n)
    System.out.println(
        n + "th ugly no. is " + getNthUglyNoUsingSet(n));//Time Complexity:- O(N log N), Auxiliary Space:- O(N)
  }

  private static int getNthUglyNoWithoutDynamicProgramming(int n) {
    int i = 1;
    int count = 1;
    while (n > count) {
      i++;
      if (isUgly(i) == 1) {
        count++;
      }
    }
    return i;
  }

  static int isUgly(int no) {
    no = maxDivide(no, 2);
    no = maxDivide(no, 3);
    no = maxDivide(no, 5);

    return (no == 1) ? 1 : 0;
  }

  static int maxDivide(int a, int b) {
    while (a % b == 0) {
      a = a / b;
    }
    return a;
  }

  private static long getNthUglyNoUsingSet(int n) {
    TreeSet<Long> t = new TreeSet<>();
    t.add(1L);
    int i = 1;
    while (i < n) {
      long temp = t.pollFirst();
      t.add(temp * 2);
      t.add(temp * 3);
      t.add(temp * 5);
      i++;
    }
    return t.pollFirst();
  }

  private static int getNthUglyNoUsingDynamicProgramming(int n) {
    int[] ugly = new int[n];
    int i2 = 0, i3 = 0, i5 = 0;
    int nextMultipleOf2 = 2;
    int nextMultipleOf3 = 3;
    int nextMultipleOf5 = 5;
    int nextUglyNo = 1;

    ugly[0] = 1;

    for (int i = 1; i < n; i++) {
      nextUglyNo = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

      ugly[i] = nextUglyNo;
      if (nextUglyNo == nextMultipleOf2) {
        i2 = i2 + 1;
        nextMultipleOf2 = ugly[i2] * 2;
      }
      if (nextUglyNo == nextMultipleOf3) {
        i3 = i3 + 1;
        nextMultipleOf3 = ugly[i3] * 3;
      }
      if (nextUglyNo == nextMultipleOf5) {
        i5 = i5 + 1;
        nextMultipleOf5 = ugly[i5] * 5;
      }
    }
    return nextUglyNo;
  }
}
