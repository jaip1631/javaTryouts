package com.practice;

/*
https://leetcode.com/problems/jump-game/
Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/

import java.util.Arrays;

public class JumpGameMinJumps {

  public static void main(String args[]) {
    JumpGameMinJumps test = new JumpGameMinJumps();
    System.out.println(test.jump(new int[]{2,3,0,1,4}));
  }

  /*
  Runtime: 222 ms
  Memory Usage: 38.5 MB
  https://leetcode.com/submissions/detail/227425324/
  */
  public int jump(int[] nums) {
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
