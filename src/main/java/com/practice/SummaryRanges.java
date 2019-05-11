package com.practice;

/*
Tags: ArrayTag
https://leetcode.com/problems/summary-ranges/
Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

  public static void main(String args[]) {
    SummaryRanges test = new SummaryRanges();
    System.out.println(test.summaryRanges(new int[]{0,2,3,4,6,8,9}));
  }


  /*
  Runtime: 0 ms
  Memory Usage: 33.9 MB
  https://leetcode.com/submissions/detail/228195838/
  */
  public List<String> summaryRanges(int[] nums) {
    if(nums.length == 0) {
      return Collections.emptyList();
    }

    List<String> result = new ArrayList<>();

    int start = 0;
    for(int i = 0; i < nums.length; i++) {
      start = i;
      while(i < nums.length-1 && nums[i] == nums[i+1]-1) {
        i++;
      }

      if(start == i) {
        result.add(""+nums[start]);
      } else {
        result.add(nums[start]+"->"+nums[i]);
      }
    }

    return result;
  }
}
