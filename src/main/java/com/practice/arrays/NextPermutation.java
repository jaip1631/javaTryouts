package com.practice.arrays;

/*
https://leetcode.com/problems/next-permutation/
Next Permutation


Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

import java.util.Arrays;

public class NextPermutation {

  public static void main(String args[]) {
    NextPermutation test = new NextPermutation();
    int arr[] = {4, 7, 6, 5, 3, 2, 1};
    test.nextPermutation(arr);
    System.out.println(Arrays.toString(arr));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 38.6 MB
  https://leetcode.com/submissions/detail/226904387/

  Note that we used reverse instead of sort because its already in SortedInReverseOrder
  */
  public void nextPermutation(int[] nums) {
    if(nums == null || nums.length == 1)
      return;

    int swapIndex, swapTemp, i;
    for(i = nums.length-1; i >= 0; i--) {
      if(i <= nums.length-2 && nums[i] < nums[i+1]) {
        for(swapIndex = nums.length-1; nums[i] >= nums[swapIndex]; swapIndex--);
        //System.out.println(swapIndex);
        swapTemp = nums[i];
        nums[i] = nums[swapIndex];
        nums[swapIndex] = swapTemp;
        reverse(nums, i+1, nums.length-1);
        return;
      }
    }

    if(i == -1)
      reverse(nums, 0, nums.length-1);
  }

  public void reverse(int[] arr, int start, int end) {
    int temp;
    for(int i = start; i <= start + (end-start)/2; i++) {
      temp = arr[i];
      arr[i] = arr[end-i+start];
      arr[end-i+start] = temp;
    }
  }
}
