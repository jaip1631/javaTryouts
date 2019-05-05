package com.practice;

/*
https://leetcode.com/problems/3sum/
3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
  public static void main(String args[]) {
    ThreeSum test = new ThreeSum();
    System.out.println(test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }

  /*
  Runtime: 25 ms
  Memory Usage: 50.6 MB
  https://leetcode.com/submissions/detail/226430174/
  */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    if(n==0) return result;

    Arrays.sort(nums);

    for(int i=0;i<nums.length-2;i++) {

      int j = i+1;
      int k = nums.length-1;
      if(i>0 && nums[i]==nums[i-1]) continue;
      if(nums[i] > 0) break;
      while(j<k) {
        if (nums[i]+nums[j]+nums[k] >0) {
          k--;
        }else if (nums[i]+nums[j]+nums[k] < 0) {
          j++;
        } else {
          while(k>j && nums[k] == nums[k-1]) {
            k--;
          }
          while(j<k &&nums[j] == nums[j+1]) {
            j++;
          }
          List<Integer> item = new ArrayList<>();
          item.add(nums[i]);
          item.add(nums[j]);
          item.add(nums[k]);
          result.add(item);
          j++;
          k--;
        }
      }
    }
    return result;
  }

  /*
  Runtime: 504 ms
  Memory Usage: 50.6 MB
  https://leetcode.com/submissions/detail/226234638/
  */
  public List<List<Integer>> threeSum_2(int[] nums) {
    Set<Integer> reqNum = new HashSet<>();
    Integer reqSum = null;
    Set<List<Integer>> list = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      reqSum = -1 * nums[i];
      reqNum.clear();
      for(int j = i+1; j < nums.length; j++) {
        if(reqNum.contains(reqSum-nums[j])) {
          List<Integer> newList =Arrays.asList(reqSum-nums[j], nums[j], -1*reqSum);
          Collections.sort(newList);
          list.add(newList);
        } else {
          reqNum.add(nums[j]);
        }
      }
    }

    return new ArrayList<>(list);
  }
}
