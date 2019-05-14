package com.practice;

/*
Tags: ArragTag, TwoPointersTag
https://leetcode.com/problems/minimum-size-subarray-sum/
Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

*/

public class MinimumSizeSubarraySum {

  public static void main(String args[]) {
    MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
    System.out.println(test.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 35.4 MB
  https://leetcode.com/submissions/detail/228191795/
  */
  public int minSubArrayLen(int s, int[] nums) {
    int minRange = Integer.MAX_VALUE;
    int left = 0, right = 0;
    int curSum = 0;

    while(right < nums.length) {
      curSum += nums[right++];

      while(curSum >= s) {
        if(right-left < minRange)
          minRange = right-left;

        curSum-=nums[left++];
      }
    }

    return minRange == Integer.MAX_VALUE
        ?   0
        :   minRange;
  }
}
