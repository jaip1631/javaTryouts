package com.practice;

/*
Tags: ArrayTag
https://leetcode.com/problems/spiral-matrix/submissions/
Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrixPrint {

  public static void main(String args[]) {
    SpiralMatrixPrint test = new SpiralMatrixPrint();
    int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(test.spiralOrder(arr));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 33.9 MB
  https://leetcode.com/submissions/detail/227410549/
  */
  public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }

    List<Integer> result = new ArrayList<>();
    int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;

    while(left < right && top < bottom) {
      for(int i = left; i < right; i++) {
        result.add(matrix[top][i]);
      }

      for(int i = top; i < bottom; i++) {
        result.add(matrix[i][right]);
      }

      for(int i = right; i > left; i--) {
        result.add(matrix[bottom][i]);
      }

      for(int i = bottom; i > top; i--) {
        result.add(matrix[i][left]);
      }
      left++;
      right--;
      top++;
      bottom--;
    }


    if(left < right && top == bottom) {
      for(int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
    } else if(top < bottom && left == right) {
      for(int i = top; i <= bottom; i++) {
        result.add(matrix[i][left]);
      }
    } else if(left == right && top == bottom) {
      result.add(matrix[top][left]);
    }

    return result;
  }
}
