package com.data_structure.algo.algorithms.backtracking.matrix;

public class AllPossiblePathCountIn_MxN_Matrix {
  public static void main(String[] args) {
    int row = 3;
    int column = 4;
    System.out.println(findNoOfPathPossible(row, column));
  }

  private static int findNoOfPathPossible(int row, int column) {
    if(row == 1 || column ==1) return 1;
    return findNoOfPathPossible(row, column-1)+ findNoOfPathPossible(column, row-1);
  }
}
