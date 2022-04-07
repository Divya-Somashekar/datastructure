package com.data_structure.algo.algorithms.backtracking.matrix;

public class RatInAMaze {
  private static int mazeSize = 0;

  public static void main(String[] args) {
    int[][] maze =
        {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}};
    mazeSize = maze.length;
    System.out.println("The Rat in the maze " + (solveMaze(maze) ? "can come out!!" : "can not come out!!"));
  }

  private static boolean solveMaze(int[][] maze) {
    int[][] sol = new int[mazeSize][mazeSize];
    if (!solveMazeUtil(maze, 0, 0, sol)) {
      return false;
    }
    printSolution(sol);
    return true;
  }

  static boolean solveMazeUtil(int[][] maze, int row, int column, int[][] sol) {
    // if (row, y is goal) return true
    if (row == mazeSize - 1 && column == mazeSize - 1 && maze[row][column] == 1) {
      sol[row][column] = 1;
      return true;
    }

    // Check if maze[row][y] is valid
    if (isSafe(maze, row, column)) {
      // Check if the current block is already part of solution path.
      if (sol[row][column] == 1) {
        return false;
      }

      // mark row, y as part of solution path
      sol[row][column] = 1;

      /* Move forward in row direction */
      if (solveMazeUtil(maze, row + 1, column, sol)) {
        return true;
      }

      /* If moving in row direction doesn't give solution then Move down in y direction */
      if (solveMazeUtil(maze, row, column + 1, sol)) {
        return true;
      }

      /* If moving in y direction doesn't give solution then Move backwards in row direction */
      if (solveMazeUtil(maze, row - 1, column, sol)) {
        return true;
      }

      /* If moving backwards in row direction doesn't give solution then Move upwards in y direction */
      if (solveMazeUtil(maze, row, column - 1, sol)) {
        return true;
      }

      /* If none of the above movements works then BACKTRACK: un mark row, y as part of solution path */
      sol[row][column] = 0;
      return false;
    }

    return false;
  }

  static void printSolution(int[][] sol) {
    for (int i = 0; i < mazeSize; i++) {
      for (int j = 0; j < mazeSize; j++) {
        System.out.print(" " + sol[i][j] + " ");
      }
      System.out.println();
    }
  }

  static boolean isSafe(
      int[][] maze, int row, int column) {
    // if (x, y outside maze) return false
    return (row >= 0 && row < mazeSize && column >= 0 && column < mazeSize && maze[row][column] == 1);
  }
}

