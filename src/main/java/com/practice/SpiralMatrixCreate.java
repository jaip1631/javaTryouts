package com.practice;

/*
Tags: MatrixTag
https://leetcode.com/problems/spiral-matrix-ii/
Spiral Matrix II

Given a positive integer n, generate a square matrix filled with elements
from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

import com.practice.datastructures.Utils;

public class SpiralMatrixCreate {

  public static void main(String args[]) {
    SpiralMatrixCreate test = new SpiralMatrixCreate();
    int matrix[][] = test.generateMatrix(3);
    Utils.printMatrix(matrix);
  }

  /*
  Runtime: 0 ms
  Memory Usage: 33.2 MB
  https://leetcode.com/submissions/detail/227846752/
  */
  public int[][] generateMatrix(int n) {
    int matrix[][] = new int [n][n];

    int left = 0, right = n-1, top = 0, bottom = n-1, counter = 1;

    while(left < right && top < bottom) {
      for(int i = left; i < right; i++) {
        matrix[top][i] = counter;
        counter++;
      }

      for(int i = top; i < bottom; i++) {
        matrix[i][right] = counter;
        counter++;
      }

      for(int i = right; i > left; i--) {
        matrix[bottom][i] = counter;
        counter++;
      }

      for(int i = bottom; i > top; i--) {
        matrix[i][left] = counter;
        counter++;
      }
      left++;
      right--;
      top++;
      bottom--;
    }


    if(left < right && top == bottom) {
      for(int i = left; i <= right; i++) {
        matrix[top][i] = counter;
        counter++;
      }
    } else if(top < bottom && left == right) {
      for(int i = top; i <= bottom; i++) {
        matrix[i][left] = counter;
        counter++;
      }
    } else if(left == right && top == bottom) {
      matrix[top][left] = counter;
    }

    return matrix;
  }
}
