package com.practice.arrays;

/*
https://leetcode.com/problems/combination-sum-ii/
Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumWithDup {

  public static void main(String args[]) {
    CombinationSumWithDup test = new CombinationSumWithDup();
    System.out.println(test.combinationSum_0(new int[]{10,1,2,7,6,1,5}, 8));
  }

  /*
  Runtime: 3 ms
  Memory Usage: 39.3 MB
  https://leetcode.com/submissions/detail/227194201/
  */
  public List<List<Integer>> combinationSum_0(int[] arr, int target) {
    List<Integer> curList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(arr);
    combinationSum_0(arr, 0, target, curList, result);

    return result;
  }

  private void combinationSum_0(int arr[], int curIndex, int target,
      final List<Integer> curList, final List<List<Integer>> result) {
    if(target == 0) {
      result.add(new ArrayList<>(curList));
      return;
    }

    if(curIndex == arr.length) {
      return;
    }

    for(int i = curIndex; i < arr.length; i++) {
      if(i > curIndex && arr[i] == arr[i-1]) {
        continue;
      }
      if(target >= arr[i]) {
        //include element at nextUniqueIndex
        curList.add(arr[i]);
        combinationSum_0(arr, i+1, target-arr[i], curList, result);
        curList.remove(curList.size()-1);
      }
    }
  }

  /*
  Runtime: 11 ms
  Memory Usage: 39.7 MB
  https://leetcode.com/submissions/detail/227191710/
  */
  public List<List<Integer>> combinationSum_1(int[] arr, int target) {
    List<Integer> curList = new ArrayList<>();
    Set<List<Integer>> resultSet = new HashSet<>();

    Arrays.sort(arr);
    combinationSum_1(arr, 0, target, curList, resultSet);

    return new ArrayList<>(resultSet);
  }

  private void combinationSum_1(int arr[], int curIndex, int target,
      final List<Integer> curList, final Set<List<Integer>> result) {
    if(target == 0) {
      result.add(new ArrayList<>(curList));
      return;
    }

    if(curIndex == arr.length) {
      return;
    }

    if(target >= arr[curIndex]) {
      //include element at curIndex
      curList.add(arr[curIndex]);
      combinationSum_1(arr, curIndex+1, target-arr[curIndex], curList, result);
      curList.remove(curList.size()-1);
    }

    //exclude element at curIndex
    combinationSum_1(arr, curIndex+1, target, curList, result);
  }
}
