package com.data_structure.algo.algorithms.backtracking.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2
        3 4
Output : 1 2 4
         1 3 4
* */
public class AllPathFromTopLeftToBottomRightIn_MxN_Matrix {
  public static void main(String[] args) {
    int[][] mat = {{1, 4, 5, 6},
        {1, 2, 5, 6},{1, 2, 3, 6}};
    printMatrix(mat);
  }

  private static void printMatrix(int[][] mat) {
    printAllPath(mat, mat.length - 1, mat[0].length - 1, 0, 0, new ArrayList<>());
  }


  private static void printAllPath(int[][] mat, int row, int column, int i, int j, List<Integer> list) {//[][], <2>, <3>, <0>, <0>, <[]> //
    if (i > row || j > column) {
      return;
    }
    list.add(mat[i][j]);//<1>
    if (i == row && j == column) {//
      System.out.println(list);
    }
    printAllPath(mat, row, column, i + 1, j, list);//[][], <2>, <3>, <1>, <0>, <[]>
    printAllPath(mat, row, column, i, j + 1, list);//[][], <2>, <3>, <>, <>, <>
    list.remove(list.size() - 1);
  }
}
