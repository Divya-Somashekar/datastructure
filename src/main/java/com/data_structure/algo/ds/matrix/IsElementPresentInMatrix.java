package com.data_structure.algo.ds.matrix;

public class IsElementPresentInMatrix {
  public static void main(String[] args) {
    int element = 7;
    int[][] matrix = {{1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}};//64
    System.out.println(isElementPresent(element, matrix));
  }

  private static boolean isElementPresent(int element, int[][] matrix) {//3, 4
    int rowPointer = 0;
    for (int i = 0; i < matrix.length; i++) {//
      if (matrix[rowPointer][matrix[0].length-1] < element) {//
        rowPointer++;
      } else {
        for (int j = 0; j < matrix[0].length; j++) {
          if (element == matrix[rowPointer][j]) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
