package com.practice;

/*
Tags: ArrayTag, BinarySearchTag
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

public class SortedRotatedNoDupFindMin {

  public static void main(String args[]) {
    SortedRotatedNoDupFindMin test = new SortedRotatedNoDupFindMin();
    System.out.println(test.findMin(new int[]{3, 1, 2}));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 39.5 MB
  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
  */
  public int findMin(int[] arr) {
    int left = 0, right = arr.length-1, middle;

    while (left < right) {
      middle = left + (right-left)/2;

      if(middle > left &&
          arr[middle - 1] > arr[middle]) {
        return arr[middle];
      }

      if(arr[middle + 1] < arr[middle]) {
        return arr[middle+1];
      }

      if(arr[right] < arr[middle]) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return arr[left];
  }
}
