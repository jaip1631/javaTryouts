package com.practice;

/*
Tags: TwoPointersTag
https://leetcode.com/problems/sort-colors/
Sort Colors

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

import java.util.Arrays;

public class SortColors {

  public static void main(String args[]) {
    SortColors test = new SortColors();
    int arr[] = new int[]{2,0,2,1,1,0};
    test.sortColors(arr);
    System.out.println(Arrays.toString(arr));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 34.1 MB
  https://leetcode.com/submissions/detail/228052115/
  */
  public void sortColors(int[] nums) {
    int zero = 0, one  = 0, two = nums.length-1;
    int temp;

    while(one <= two) {
      while(zero < nums.length && nums[zero] == 0)
        zero++;

      if(one < zero)
        one = zero;
      while(one < nums.length && nums[one] == 1)
        one++;

      while(two >= 0 && nums[two] == 2)
        two--;

      if(one <= two) {
        if(nums[two] == 0) {
          temp = nums[zero];
          nums[zero] = 0;
          nums[two] = temp;
        }
        else {
          temp = nums[one];
          nums[one] = 1;
          nums[two] = temp;
        }
      }
    }
  }
}
