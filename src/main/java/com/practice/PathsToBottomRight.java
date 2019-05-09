package com.practice;

/*
Tags: MatrixTag, DPTag
Unique Paths
https://leetcode.com/problems/unique-paths/

robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class PathsToBottomRight {

  public static void main(String args[]) {
    PathsToBottomRight test = new PathsToBottomRight();
    System.out.println(test.uniquePaths(3,2));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 32.1 MB
  https://leetcode.com/submissions/detail/227848109/
  */
  public int uniquePaths(int m, int n) {
    if(m == 0 || n == 0) {
      return 0;
    }

    int mat[][] = new int[m][n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(i == 0 || j == 0) {
          mat[i][j] = 1;
        } else {
          mat[i][j] = mat[i][j-1] + mat[i-1][j];
        }
      }
    }

    return mat[m-1][n-1];
  }
}
