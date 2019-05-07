package com.practice;

/*
Tags: ArrayTag, GreedyTag
https://leetcode.com/problems/wiggle-subsequence/
Wiggle Subsequence

A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

*/

public class WiggleSubSeq {

  public static void main(String args[]) {
    WiggleSubSeq test = new WiggleSubSeq();
    System.out.println(test.getLargestLenZigZagSubSeq(new int[]{5, 5, 5, 5, 2, 3, 7, 6}));
  }

  /*
  Runtime: 0 ms
  Memory Usage: 33.6 MB
  https://leetcode.com/submissions/detail/227332130/
  */
  public int getLargestLenZigZagSubSeq(int arr[]) {
    if(arr == null || arr.length == 0) {
      return 0;
    }
    if(arr.length == 1) {
      return 1;
    }

    int start = 0;
    while(start < arr.length-1 && arr[start] == arr[start+1]) {
      start++;
    };

    if(start == arr.length-1) {
      return 1;
    }

    int lastDiff, curDiff, curLen;
    lastDiff = arr[start+1] - arr[start];
    curLen = 2;
    start = start+1;

    for(int i = start; i < arr.length; i++) {
      curDiff = arr[i] - arr[i-1];
      if((lastDiff < 0 && curDiff > 0)
          || (lastDiff > 0 && curDiff < 0)) {
        curLen++;
        lastDiff = curDiff;
      }
      if(lastDiff == 0 && curDiff !=0) {
        lastDiff = curDiff;
      }
    }

    return curLen;
  }
}
