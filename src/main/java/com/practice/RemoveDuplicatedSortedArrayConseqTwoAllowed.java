package com.practice;

/*
Tags: ArrayTag
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
Remove Duplicates from Sorted Array II

Given a sorted array nums, remove the duplicates in-place such that duplicates
appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the
input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being
1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of
nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.

*/

public class RemoveDuplicatedSortedArrayConseqTwoAllowed {

  public static void main(String args[]) {
    RemoveDuplicatedSortedArrayConseqTwoAllowed test = new RemoveDuplicatedSortedArrayConseqTwoAllowed();
    System.out.println(test.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 36 MB
  https://leetcode.com/submissions/detail/228151065/
  */
  public int removeDuplicates(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }

    int writeHead = 1, readHead = 1;
    int count = 1, maxConseqAllowed = 2;

    while(readHead != nums.length) {
      if(nums[readHead] == nums[writeHead-1] && count < maxConseqAllowed) {
        nums[writeHead] = nums[readHead];
        writeHead++;
        count++;
      } else if(nums[readHead] != nums[writeHead-1]) {
        nums[writeHead] = nums[readHead];
        writeHead++;
        count = 1;
      }

      readHead++;
    }

    return writeHead;
  }
}
