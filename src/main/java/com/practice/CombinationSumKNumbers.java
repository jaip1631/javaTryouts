package com.practice;

/*
Tags: ArrayTag, BackTrackingTag
https://leetcode.com/problems/combination-sum-iii/
Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumKNumbers {

  public static void main(String args[]) {
    CombinationSumKNumbers test = new CombinationSumKNumbers();
    System.out.println(test.combinationSum3(3, 9));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 32.9 MB
  https://leetcode.com/submissions/detail/228193227/
  */
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    combinationSum3(k, n, new int[]{1,2,3,4,5,6,7,8,9}, result, path, 0);
    return result;
  }

  private void combinationSum3(int k, int target, int nums[],
      List<List<Integer>> result, List<Integer> path, int index) {
    if(target == 0 && k == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = index; i < nums.length; i++) {
      if(target >= nums[i] && k > 0) {
        path.add(nums[i]);
        combinationSum3(k-1, target-nums[i], nums, result, path, i+1);
        path.remove(path.size()-1);
      }
    }
  }
}
