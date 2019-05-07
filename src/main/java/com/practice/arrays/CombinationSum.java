package com.practice.arrays;

/*
https://leetcode.com/problems/combination-sum/submissions/
Combination Sum

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String args[]) {
    CombinationSum test = new CombinationSum();
    System.out.println(test.combinationSum(new int[]{2,3,7,6}, 10));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 38.6 MB
  https://leetcode.com/submissions/detail/227194678/
  Note: no need to write exclude case
  */

  public List<List<Integer>> combinationSum(int[] arr, int target) {
    List<Integer> curList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    combinationSum(arr, 0, target, curList, result);

    return result;
  }

  private void combinationSum(int arr[], int curIndex, int target,
      final List<Integer> curList, final List<List<Integer>> result) {
    if(target == 0) {
      result.add(new ArrayList<>(curList));
      return;
    }

    for(int i = curIndex; i < arr.length; i++) {
      if(target >= arr[i]) {
        //include element at curIndex
        curList.add(arr[i]);
        combinationSum(arr, i, target-arr[i], curList, result);
        curList.remove(curList.size()-1);
      }

      // no need to write exclude case as incremented i will itself exclude it
    }
  }

  /*
  Runtime: 3 ms
  Memory Usage: 38.7 MB
  https://leetcode.com/submissions/detail/227186614/
  Note: We explicitly need to write exclude case
  */
  public List<List<Integer>> combinationSum_1(int[] arr, int target) {
    List<Integer> curList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    combinationSum_1(arr, 0, target, curList, result);

    return result;
  }

  private void combinationSum_1(int arr[], int curIndex, int target,
      final List<Integer> curList, final List<List<Integer>> result) {
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
      combinationSum_1(arr, curIndex, target-arr[curIndex], curList, result);
      curList.remove(curList.size()-1);
    }

    //exclude element at curIndex
    combinationSum_1(arr, curIndex+1, target, curList, result);
  }
}
