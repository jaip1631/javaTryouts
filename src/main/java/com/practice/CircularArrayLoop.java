package com.practice;

/*
Tags: TwoPointersTag
https://leetcode.com/problems/circular-array-loop/
Circular Array Loop

You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.



Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.


Note:

-1000 ≤ nums[i] ≤ 1000
nums[i] ≠ 0
1 ≤ nums.length ≤ 5000

*/

public class CircularArrayLoop {

  public static void main(String args[]) {
    CircularArrayLoop test = new CircularArrayLoop();
    System.out.println(test.circularArrayLoop(new int[]{2,-1,1,2,2}));
  }

  /*
  Runtime: 33 ms
  Memory Usage: 33.1 MB
  https://leetcode.com/submissions/detail/230449240/
  */
  public boolean circularArrayLoop(int[] nums) {
    int end, slow;
    int stepCount = 0;
    boolean forward;
    int len = nums.length;
    for(int start = 0; start < len; start++) {
      end = start;
      forward = nums[end] > 0;
      end = (len + (end + nums[end]%len))%len;
      slow = end;
      end = (len + (end + nums[end]%len))%len;
      stepCount = 1;
      while(slow != end && (forward == (nums[end] > 0)) && (forward == (nums[slow] > 0))) {
        slow = (len + ((slow+nums[slow])%len))%len;
        end = (len + ((end+nums[end])%len))%len;
        if((forward ^ nums[end]>0)) {
          break;
        }
        end = (len + ((end+nums[end])%len))%len;
        stepCount++;
      }
      if(start == end
          && stepCount != 1
          && (forward == (nums[end] > 0)) && (forward == (nums[slow] > 0))) {
        return true;
      }
    }

    return false;
  }
}
