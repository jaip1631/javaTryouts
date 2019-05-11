package com.practice;

/*
Tags: MatrixTag
https://leetcode.com/problems/set-matrix-zeroes/
Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

*/

import com.practice.datastructures.Utils;

public class SetMatrixZeroes {

  public static void main(String args[]) {
    SetMatrixZeroes test = new SetMatrixZeroes();
    int mat[][] = new int [][]{{1,1,1},{1,0,1},{1,1,1}};
    Utils.printMatrix(mat);
    test.setZeroes(mat);
    Utils.printMatrix(mat);
  }

  /*
  Runtime: 1 ms
  Memory Usage: 46.2 MB
  https://leetcode.com/submissions/detail/228058103/
  */
  public void setZeroes(int[][] matrix) {
    if(matrix.length == 0) {
      return;
    }

    boolean rowZero = false, colZero = false;

    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(i == 0 && j == 0 && matrix[i][j] == 0) {
          colZero = true;
          rowZero = true;
        } else if(i == 0 && matrix[i][j] == 0) {
          rowZero = true;
        } else if(j == 0 && matrix[i][j] == 0) {
          colZero = true;
        } else if(matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[0].length; j++) {
        if(matrix[0][j] ==0 || matrix[i][0]==0) {
          matrix[i][j] = 0;
        }
      }
    }

    if(rowZero) {
      markRow(matrix, 0);
    }
    if(colZero) {
      markCol(matrix, 0);
    }
  }

  private void markCol(int[][] mat, int col) {
    for(int i = 0; i < mat.length; i++) {
      mat[i][col] = 0;
    }
  }

  private void markRow(int[][] mat, int row) {
    for(int i = 0; i < mat[0].length; i++) {
      mat[row][i] = 0;
    }
  }
}
