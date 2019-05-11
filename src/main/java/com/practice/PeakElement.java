package com.practice;

/*
Tags: ArrayTag, BinarySearchTag
https://leetcode.com/problems/find-peak-element/
Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

*/

public class PeakElement {

  public static void main(String args[]) {
    PeakElement test = new PeakElement();
    System.out.println(test.findPeakElement(new int[]{1,2,1,3,5,6,4}));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 37.5 MB
  https://leetcode.com/submissions/detail/228173161/
  */
  public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length-1, middle;

    while(left < right) {
      middle = left + (right-left)/2;
      if(middle > 0
          && nums[middle] > nums[middle+1]
          && nums[middle] > nums[middle-1]) {
        return middle;
      }
      if(nums[middle] < nums[middle+1]) {
        left = middle+1;
      } else {
        right = middle-1;
      }
    }

    return left;
  }
}
