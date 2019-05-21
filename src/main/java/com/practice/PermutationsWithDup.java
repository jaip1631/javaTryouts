package com.practice;

/*
Tags: StarTag, BackTrackingTag
https://leetcode.com/problems/permutations-ii/
Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithDup {

  public static void main(String args[]) {
    PermutationsWithDup test = new PermutationsWithDup();
    System.out.println(test.permuteUnique(new int[]{0,0,0,1,9}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 38.1 MB
  https://leetcode.com/submissions/detail/230446480/
  Note: Taking boolean isUsed[] instead of Boolean isUsed pushed this
        solution from 2 ms -> 1 ms. As in Boolean, I had to do
        Arrays.fill(isUsed, Boolean.False) because default value
        would be null. In boolean, default value is false, so no need to
        re-initialise it.
  */
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    return permute_1(nums);
  }

  public List<List<Integer>> permute_1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean isUsed[] = new boolean[nums.length];

    permute_1(nums, result, path, isUsed);
    return result;
  }

  private void permute_1(int nums[], List<List<Integer>> result,
      List<Integer> path, boolean isUsed[]) {
    if(path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = 0; i < nums.length; i++) {
      if(isUsed[i]) {
        continue;
      }
      if(i>0 && nums[i] == nums[i-1] && !isUsed[i-1]) {
        continue;
      }
      isUsed[i] = true;
      path.add(nums[i]);
      permute_1(nums, result, path, isUsed);
      path.remove(path.size()-1);
      isUsed[i] = false;
    }
  }

  /*
  Runtime: 2 ms
  Memory Usage: 39.8 MB
  https://leetcode.com/submissions/detail/230441300/
  */
  public List<List<Integer>> permute_2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    permute_2(nums, result, path, 0);
    return result;
  }

  private void permute_2(int nums[], List<List<Integer>> result,
      List<Integer> path, int curIndex) {
    if(path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = curIndex; i < nums.length; i++) {
      if(i>curIndex && nums[i] == nums[i-1]) {
        continue;
      }
      int backup[] = Arrays.copyOfRange(nums, curIndex, nums.length);
      swap(nums, i, curIndex);
      Arrays.sort(nums, curIndex+1, nums.length);
      path.add(nums[curIndex]);
      permute_2(nums, result, path, curIndex+1);
      path.remove(path.size()-1);
      for(int j = curIndex; j < nums.length; j++) {
        nums[j] = backup[j-curIndex];
      }
    }
  }

  private static void swap(int[] array,int s,int i){
    int t= array[s];
    array[s]=array[i];
    array[i]=t;
  }
}
