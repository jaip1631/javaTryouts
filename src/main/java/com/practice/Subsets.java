package com.practice;

/*
Tags: BackTrackingTag
https://leetcode.com/problems/subsets/
Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

  public static void main(String args[]) {
    Subsets test = new Subsets();
    System.out.println(test.subsets_0(new int[]{1, 2, 3}));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 38.3 MB
  https://leetcode.com/submissions/detail/226727756/
  */
  public List<List<Integer>> subsets_0(int[] nums) {
    List<Integer> curList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    generateAllSets_0(nums, 0, curList, result);
    return result;
  }
  public void generateAllSets_0(int arr[], int curIndex, final List<Integer> curList,
      final List<List<Integer>> result) {
    if(curIndex == arr.length) {
      result.add(new ArrayList<>(curList));
      return;
    }

    generateAllSets_0(arr, curIndex+1, curList, result);
    curList.add(arr[curIndex]);
    generateAllSets_0(arr, curIndex+1, curList, result);
    curList.remove(curList.size()-1);
  }

  /*
  Runtime: 1 ms
  Memory Usage: 38.4 MB
  https://leetcode.com/submissions/detail/227198274/
  */
  public List<List<Integer>> subsets_2(int[] nums) {
    List<Integer> curList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    generateAllSets_2(nums, 0, curList, result);
    return result;
  }
  public void generateAllSets_2(int arr[], int curIndex, final List<Integer> curList,
      final List<List<Integer>> result) {
    if(curIndex == arr.length) {
      result.add(new ArrayList<>(curList));
      return;
    }

    for(int i = curIndex; i < arr.length; i++) {
      curList.add(arr[i]);
      generateAllSets_2(arr, i+1, curList, result);
      curList.remove(curList.size()-1);
    }

    result.add(new ArrayList<>(curList));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 38.4 MB
  https://leetcode.com/submissions/detail/226725036/
  */
  public List<List<Integer>> subsets_1(int[] nums) {
    return generateAllSets_1(nums, 0);
  }
  public List<List<Integer>> generateAllSets_1(int arr[], int curIndex) {
    if(curIndex == arr.length) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }

    List<List<Integer>> exclude = generateAllSets_1(arr, curIndex+1);
    List<List<Integer>> include = new ArrayList<>();
    for(List<Integer> list : exclude) {
      List<Integer> copy = new ArrayList<>(list);
      copy.add(arr[curIndex]);
      include.add(copy);
    }

    List<List<Integer>> result = new ArrayList<>();
    result.addAll(exclude);
    result.addAll(include);
    return result;
  }
}
