package com.practice;

/*
https://leetcode.com/problems/jump-game-ii/
Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

*/

import java.util.Arrays;

public class JumpGameMinJumps {

  public static void main(String args[]) {
    JumpGameMinJumps test = new JumpGameMinJumps();
    System.out.println(test.jumps_0(new int[]{1,1,1,3}));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 38.2 MB
  https://leetcode.com/submissions/detail/227797103/
  */
  public int jumps_0(int arr[]) {
    if(arr == null || arr.length <= 1) {
      return 0;
    }

    int maxReachable = 0, curStretch = maxReachable, jumps = 0;

    for(int i = 0; i < arr.length-1; i++) {
      if(i > maxReachable) {
        return -1;
      }
      maxReachable = Math.max(maxReachable, arr[i]+i);
      if(i == curStretch) {
        jumps++;
        curStretch = maxReachable;
      }
    }

    return jumps;
  }

  /*
  Runtime: 222 ms
  Memory Usage: 38.5 MB
  https://leetcode.com/submissions/detail/227425324/
  */
  public int jumps_1(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int minJumps[] = new int[nums.length];
    Arrays.fill(minJumps, Integer.MAX_VALUE);
    minJumps[nums.length-1] = 0;

    for(int i = nums.length-2; i >=0; i--) {
      for(int j = i+1; j < nums.length && j <= i+nums[i]; j++) {
        minJumps[i] = Math.min(minJumps[i], minJumps[j]);
      }
      if(minJumps[i] != Integer.MAX_VALUE) {
        minJumps[i]++;
      }
    }

    return minJumps[0];
  }
}
