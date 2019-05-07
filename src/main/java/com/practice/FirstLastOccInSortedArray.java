package com.practice;

/*
Tags: ArrayTag
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/

import java.util.Arrays;

public class FirstLastOccInSortedArray {

  public static void main(String args[]) {
    FirstLastOccInSortedArray test = new FirstLastOccInSortedArray();
    System.out.println(Arrays.toString(test.searchRange(new int[]{0, 0, 1, 2, 4, 4}, 4)));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 44.3 MB
  https://leetcode.com/submissions/detail/227180681/
  */
  public int[] searchRange(int[] arr, int target) {
    int result[] = new int[] {-1, -1};
    if(arr == null || arr.length == 0) {
      return result;
    }

    int firstOcc = findFirstOcc(arr, target), lastOcc = -1;
    if(firstOcc != -1) {
      result[0] = firstOcc;
      result[1] = findLastOcc(arr, firstOcc, target);
    }

    return result;
  }

  private int findLastOcc(int arr[], int start, int target) {
    int left = start, right = arr.length-1, middle = 0;

    // find lastOcc
    while(left+1 < right) {
      middle = left + (right-left)/2;
      if(arr[middle] == target) {
        left = middle;
      } else if(arr[middle] < target) {
        left = middle +1;
      } else {
        right = middle- 1;
      }
    }

    if(arr[right] == target) {
      return right;
    } else if(arr[left] == target) {
      return left;
    } else {
      return -1;
    }
  }

  private int findFirstOcc(int arr[], int target) {
    int left = 0, right = arr.length -1 , middle = 0;

    // find firstOcc
    while(left < right) {
      middle = left + (right-left)/2;
      if(arr[middle] == target) {
        right = middle;
      } else if(arr[middle] < target) {
        left = middle +1;
      } else {
        right = middle- 1;
      }
    }

    if(arr[left] != target) {
      return -1;
    }

    return left;
  }
}
