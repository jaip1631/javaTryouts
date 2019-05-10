package com.practice;

/*
Tags: DPTag, MatrixTag
https://leetcode.com/problems/minimum-path-sum/
Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

import com.practice.DataStructures.Utils;

public class MinimumPathSum {

  public static void main(String args[]) {
    MinimumPathSum test = new MinimumPathSum();
    int mat[][] = new int [][]{{1,3,1},{1,5,1},{4,2,1}};
    Utils.printMatrix(mat);
    System.out.println(test.minPathSum(mat));
  }


  /*
  Runtime: 2 ms
  Memory Usage: 41.6 MB
  https://leetcode.com/submissions/detail/228041216/
  */
  public int minPathSum(int[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowL = grid.length;
    int colL = grid[0].length;
    int DP[][] = new int[rowL][colL];

    for(int i = 0; i < rowL; i++) {
      for(int j = 0; j < colL; j++) {
        if(i == 0 && j == 0) {
          DP[i][j] = grid[i][j];
        }
        else if(i == 0) {
          DP[i][j] = DP[i][j-1] + grid[i][j];
        }
        else if(j == 0) {
          DP[i][j] = DP[i-1][j] + grid[i][j];
        }
        else {
          DP[i][j] = Math.min(DP[i][j-1], DP[i-1][j]) + grid[i][j];
        }
      }
    }

    return DP[rowL-1][colL-1];
  }
}
