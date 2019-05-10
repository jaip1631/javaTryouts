package com.practice;

/*
Tags: ArrayTag, MatrixTag
https://leetcode.com/problems/rotate-image/
Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

*/

import com.practice.DataStructures.Utils;

public class RotateMatrix90Clockwise {

  public static void main(String args[]) {
    RotateMatrix90Clockwise test = new RotateMatrix90Clockwise();
    int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
    Utils.printMatrix(arr);
    test.rotate(arr);
    Utils.printMatrix(arr);
  }

  /*
  Runtime: 0 ms
  Memory Usage: 35.6 MB
  https://leetcode.com/submissions/detail/227400862/
  */
  public void rotate(int[][] matrix) {
    int temp, len = matrix.length;

    int left = 0, top = 0, right = len-1, bottom = len-1;

    while(left < right) {
      for(int i = left; i < right; i++) {
        temp = matrix[top][i];
        matrix[top][i] = matrix[len-1-i][left];
        matrix[len-1-i][left] = matrix[bottom][len-1-i];
        matrix[bottom][len-1-i] = matrix[i][right];
        matrix[i][right] = temp;
      }
      left++;
      right--;
      top++;
      bottom--;
    }
  }
}
