package com.practice;

/*
Tags: ArrayTag, BinarySearchTag
https://leetcode.com/problems/search-in-rotated-sorted-array/
Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

public class SortedRotatedNoDupSearch {

  public static void main(String args[]) {
    SortedRotatedNoDupSearch test = new SortedRotatedNoDupSearch();
    System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 37.2 MB
  https://leetcode.com/submissions/detail/226907827/
  */
  public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0)
      return -1;

    int left = 0, right = nums.length-1, middle;

    do {
      middle = left + (right-left)/2;
      if(nums[middle] == target) {
        return middle;
      }

      if((nums[right] < nums[middle] &&
          (target > nums[middle] || target <= nums[right])) ||
          (nums[right] > nums[middle] &&
              target <= nums[right] && target > nums[middle])) {
        left = middle+1;
      } else {
        right = middle-1;
      }
    }while(left < right);

    if(nums[left] == target) {
      return left;
    }
    return -1;
  }
}
