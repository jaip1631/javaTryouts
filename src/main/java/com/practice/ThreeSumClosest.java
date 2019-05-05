package com.practice;

/*
https://leetcode.com/problems/3sum-closest/
3Sum Closest

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String args[]) {
    ThreeSumClosest test = new ThreeSumClosest();
    System.out.println(test.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }

  /*
  Runtime: 5 ms
  Memory Usage: 37.3 MB
  https://leetcode.com/submissions/detail/226688846/
  */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int sol = -1, maxDistance = Integer.MAX_VALUE;
    int left, right, curSum;
    for(int i = 0; i < nums.length-2; i++) {

      left = i+1;
      right = nums.length-1;
      while(left < right) {
        curSum = nums[i]+nums[left]+nums[right];
        if(Math.abs(curSum - target) < maxDistance) {
          sol = curSum;
          maxDistance = Math.abs(curSum - target);
        }

        if(curSum == target) {
          return curSum;
        } else if(curSum < target) {
          left++;
        } else {
          right--;
        }
      }
    }

    return sol;
  }
}
