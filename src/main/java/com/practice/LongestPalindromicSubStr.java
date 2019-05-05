package com.practice;

/*
https://leetcode.com/problems/longest-palindromic-substring/
Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubStr {

  private int maxPLeft, maxPRight;

  public static void main(String args[]) {
    LongestPalindromicSubStr test = new LongestPalindromicSubStr();
    System.out.println(test.longestPalindrome_0("babad"));
  }

  /*
  Runtime: 6 ms
  Memory Usage: 37.3 MB
  https://leetcode.com/submissions/detail/223339946/
  */
  public String longestPalindrome_0(String s) {
    if(s == null || s.length() < 2)
      return s;

    maxPLeft = 0;
    maxPRight = 0;
    for(int i = 0; i < s.length(); i++) {
      expand(s, i, i);
      expand(s, i, i+1);
    }

    return s.substring(maxPLeft, maxPRight+1);
  }

  private void expand(String s, int left, int right) {
    while(left >=0 && right <s.length()
        && s.charAt(left) == s.charAt(right)) {
      if((maxPRight - maxPLeft) < (right - left)) {
        maxPRight = right;
        maxPLeft = left;
      }
      left--;
      right++;
    }
  }

  /*
  DP Solution
  Runtime: 221 ms
  Memory Usage: 50.4 MB
  https://leetcode.com/submissions/detail/223331462/
  */
  public String longestPalindrome_2(String s) {
    if(s == null || s.length() <= 1)
      return s;

    boolean arr[][] = new boolean[s.length()+1][s.length()];
    String maxPalindrome = String.valueOf(s.charAt(0));
    int maxLen = 1;

    for(int i = 0; i < s.length(); i++) {
      arr[0][i] = true;
      arr[1][i] = true;
    }

    for(int strLen = 2; strLen <= s.length(); strLen++) {
      for(int index = strLen-1; index < s.length(); index++) {
        arr[strLen][index] =
            (s.charAt(index) == s.charAt(index-strLen+1))
                && (arr[strLen-2][index-1]);
        if(arr[strLen][index] && strLen > maxLen) {
          maxPalindrome = s.substring(index-strLen+1, index+1);
        }
      }
    }
    return maxPalindrome;
  }
}
