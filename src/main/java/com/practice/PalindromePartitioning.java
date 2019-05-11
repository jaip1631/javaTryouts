package com.practice;

/*
tags: BackTrackingTag
https://leetcode.com/problems/palindrome-partitioning/
Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  public static void main(String args[]) {
    PalindromePartitioning test = new PalindromePartitioning();
    System.out.println(test.partition("aab"));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 38.6 MB
  https://leetcode.com/submissions/detail/228239744/
  Note: Can optimise by prior calculating all isPalindrome 2DArray using DP
  */
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    partition(s, result, path, 0);
    return result;
  }

  private void partition(String s, final List<List<String>> result,
      List<String> path, int index) {
    if(index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = index; i < s.length(); i++) {
      if(isPalindrome(s, index, i)) {
        path.add(s.substring(index, i+1));
        partition(s, result, path, i+1);
        path.remove(path.size()-1);
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while(left < right) {
      if(s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
