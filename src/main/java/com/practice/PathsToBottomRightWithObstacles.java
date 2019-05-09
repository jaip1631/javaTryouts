package com.practice;

/*
Tags: DPTag, MatrixTag
Unique Paths II
https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

public class PathsToBottomRightWithObstacles {

  public static void main(String args[]) {
    PathsToBottomRightWithObstacles test = new PathsToBottomRightWithObstacles();
    System.out.println(
        test.uniquePathsWithObstacles(new int [][]{{0,0,0},{0,1,0},{0,0,0}})
    );
  }

  public int uniquePathsWithObstacles(int[][] mat) {
    if(mat.length == 0 || mat[0].length == 0) {
      return 0;
    }

    int m = mat.length;
    int n = mat[0].length;

    if(mat[m-1][n-1] == 1 || mat[0][0] == 1) {
      return 0;
    }
    mat[0][0] = -1;

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(mat[i][j] == 1 || (i == 0 && j == 0)) {
          continue;
        } else {
          int left = 0;
          int top = 0;

          if(j>0 && mat[i][j-1] != 1) {
            left = mat[i][j-1];
          }
          if(i>0 && mat[i-1][j] != 1) {
            top = mat[i-1][j];
          }
          mat[i][j] = left + top;
        }
      }
    }

    return -1 * mat[m-1][n-1];
  }
}
