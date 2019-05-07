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

public class JumpGame {

  public static void main(String args[]) {
    JumpGame test = new JumpGame();
    System.out.println(test.canJump_0(new int[]{1, 2, 3}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 35.7 MB
  https://leetcode.com/submissions/detail/227421757/
  */
  public boolean canJump_0(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > max)
        return false;
      max = Math.max(max, nums[i] + i);
    }

    return true;
  }

  /*
  Runtime: 1 ms
  Memory Usage: 36.4 MB
  https://leetcode.com/submissions/detail/227416931/
  */
  public boolean canJump_1(int[] nums) {
    if(nums == null || nums.length <=1) {
      return true;
    }
    if(nums[0] == 0) {
      return false;
    }

    int curLife = nums[0]-1;
    for(int i = 1; i < nums.length; i++) {
      if(i == nums.length-1) {
        return true;
      }
      if(curLife < nums[i]) {
        curLife = nums[i];
      }
      if(curLife == 0) {
        return false;
      }
      curLife--;
    }

    return true;
  }
}
