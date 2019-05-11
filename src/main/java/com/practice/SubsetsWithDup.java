package com.practice;

/*
Tags: ArrayTag, BackTrackingTag
https://leetcode.com/problems/subsets-ii/
Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

  public static void main(String args[]) {
    SubsetsWithDup test = new SubsetsWithDup();
    System.out.println(test.subsetsWithDup(new int[]{1,2,2,2}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 36.6 MB
  https://leetcode.com/submissions/detail/228160931/
  */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    Arrays.sort(nums);
    subsetsWithDup(nums, path, result, 0);

    return result;
  }

  private void subsetsWithDup(int nums[], final List<Integer> path,
      final List<List<Integer>> result, int index) {
    if(index == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = index; i < nums.length; i++) {
      if(i > index && nums[i-1] == nums[i]) {
        continue;
      }

      path.add(nums[i]);
      subsetsWithDup(nums, path, result, i+1);
      path.remove(path.size()-1);
    }

    result.add(new ArrayList<>(path));
  }
}
