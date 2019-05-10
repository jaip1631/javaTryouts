package com.practice;

/*
Tags: BinarySearchTag, MatrixTag
https://leetcode.com/problems/search-a-2d-matrix/
Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

*/

import com.practice.DataStructures.Utils;

public class Searcha2DMatrix {

  public static void main(String args[]) {
    Searcha2DMatrix test = new Searcha2DMatrix();
    int mat[][] = new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    Utils.printMatrix(mat);
    System.out.println(test.searchMatrix(mat, 3));
  }


  public boolean searchMatrix(int[][] mat, int target) {
    if(mat.length == 0 || mat[0].length == 0) {
      return false;
    }
    return search(mat, target, 0, mat.length-1, 0, mat[0].length-1);
  }

  public boolean search(int mat[][], int target,
      int startRow, int endRow, int startCol, int endCol) {
    if(startRow >=mat.length || endRow<0
        || startCol >=mat[0].length || endCol <0) {
      return false;
    }
    if(startRow > endRow || startCol > endCol) {
      return false;
    }
    int midRow = startRow + (endRow-startRow)/2;
    int midCol = startCol + (endCol-startCol)/2;

    if(mat[midRow][midCol] == target) {
      return true;
    }
    if(mat[midRow][midCol] > target) {
      return search(mat, target, startRow, midRow-1, startCol, endCol)
          || search(mat, target, midRow, endRow, startCol, midCol-1);
    }
    else {
      return search(mat, target, startRow, endRow, midCol+1, endCol)
          || search(mat, target, midRow+1, endRow, startCol, midCol);
    }
  }
}
