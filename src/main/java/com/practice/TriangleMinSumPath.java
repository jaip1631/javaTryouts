package com.practice;

/*
Tags: ArrayTag, DPTag
https://leetcode.com/problems/triangle/
Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/

import java.util.Arrays;
import java.util.List;

public class TriangleMinSumPath {

  public static void main(String args[]) {
    TriangleMinSumPath test = new TriangleMinSumPath();
    System.out.println(
        test.minimumTotal_0(
            Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)))
    );
  }

  /*
  Runtime: 2 ms
  Memory Usage: 35.7 MB
  https://leetcode.com/submissions/detail/228366484/
  Note: Optimisation is to use array to store minSums.
        And avoid list access like list.get(i).get(j). Instead
        first get list.get(1) and then access its (j)
  */
  public int minimumTotal_0(List<List<Integer>> triangle) {
    if(triangle.isEmpty()) {
      return 0;
    }

    Integer nextRow[] = triangle.get(triangle.size()-1).toArray(new Integer[0]);
    for(int i = triangle.size()-2; i >= 0; i--) {
      List<Integer> curRow = triangle.get(i);
      for(int j = 0; j < curRow.size(); j++) {
        nextRow[j] = curRow.get(j) + Math.min(nextRow[j], nextRow[j+1]);
      }
    }

    return nextRow[0];
  }

  /*
  Runtime: 4 ms
  Memory Usage: 36 MB
  https://leetcode.com/submissions/detail/228356806/
  */
  public int minimumTotal_1(List<List<Integer>> triangle) {
    if(triangle.isEmpty()) {
      return 0;
    }

    if(triangle.size() == 1) {
      return triangle.get(0).get(0);
    }


    Integer mat[][] = new Integer [triangle.size()][];
    for(int i = 0; i < triangle.size(); i++) {
      mat[i] = triangle.get(i).toArray(new Integer[0]);
    }

    Integer min, rowMin = Integer.MAX_VALUE;
    for(int i = 1; i < mat.length; i++) {
      rowMin = Integer.MAX_VALUE;
      for(int j = 0; j < mat[i].length; j++) {
        min = Integer.MAX_VALUE;
        if(j > 0 && mat[i-1][j-1] < min) {
          min = mat[i-1][j-1];
        }
        if(j != mat[i].length-1
            && mat[i-1][j] < min) {
          min = mat[i-1][j];
        }

        mat[i][j] += min;
        if(mat[i][j] < rowMin) {
          rowMin = mat[i][j];
        }
      }
    }

    return rowMin;
  }

  /*
  Runtime: 10 ms
  Memory Usage: 37.4 MB
  https://leetcode.com/submissions/detail/228354672/
  */
  public int minimumTotal_2(List<List<Integer>> triangle) {
    if(triangle.isEmpty()) {
      return 0;
    }

    if(triangle.size() == 1) {
      return triangle.get(0).get(0);
    }

    Integer min, rowMin = Integer.MAX_VALUE;
    for(int i = 1; i < triangle.size(); i++) {
      rowMin = Integer.MAX_VALUE;
      for(int j = 0; j < triangle.get(i).size(); j++) {
        min = Integer.MAX_VALUE;
        if(j > 0 && triangle.get(i-1).get(j-1) < min) {
          min = triangle.get(i-1).get(j-1);
        }
        if(j != triangle.get(i).size()-1
            && triangle.get(i-1).get(j) < min) {
          min = triangle.get(i-1).get(j);
        }

        triangle.get(i).set(j, min+triangle.get(i).get(j));
        if(triangle.get(i).get(j) < rowMin) {
          rowMin = triangle.get(i).get(j);
        }
      }
    }

    return rowMin;
  }
}
