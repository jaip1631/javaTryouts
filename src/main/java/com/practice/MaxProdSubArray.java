package com.practice;

/*
Tags: ArrayTag
https://leetcode.com/problems/maximum-product-subarray/
Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

public class MaxProdSubArray {

  public static void main(String args[]) {
    MaxProdSubArray test = new MaxProdSubArray();
    System.out.println(test.maxProduct_0(new int[]{2,-2,2,-2,2,-2,2,2}));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 39.9 MB
  https://leetcode.com/submissions/detail/228171605/
  Note: Two pass
  */
  public int maxProduct_0(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }

    int maxPos = Integer.MIN_VALUE;
    int product = 1;

    for(int i = 0; i < nums.length; i++) {
      product *= nums[i];
      if(product > maxPos)
        maxPos = product;
      if(product == 0) {
        product = 1;
      }
    }

    product = 1;
    for(int i = nums.length-1; i >= 0; i--) {
      product *= nums[i];
      if(product > maxPos)
        maxPos = product;
      if(product == 0) {
        product = 1;
      }
    }

    return maxPos;
  }

  /*
  Runtime: 1 ms
  Memory Usage: 35.6 MB
  https://leetcode.com/submissions/detail/228172172/
  Note: One Pass
  */
  public int maxProduct_1(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int res = nums[0];

    for(int i = 1; i < nums.length; i++)
    {
      if(nums[i] < 0)
      {
        int t = max;
        max = min;
        min = t;
      }

      max = Math.max(nums[i], nums[i]*max);
      min = Math.min(nums[i], nums[i]*min);
      res = Math.max(res,max);
    }
    return res;
  }
}
