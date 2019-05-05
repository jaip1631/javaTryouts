package com.practice;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepeatingChar {

  public static void main(String args[]) {
    LongestSubStrWithoutRepeatingChar test = new LongestSubStrWithoutRepeatingChar();
    System.out.println(test.lengthOfLongestSubstring_1("abcabcbb"));
  }

  /*
  Runtime: 3 ms
  Memory Usage: 38.5 MB
  https://leetcode.com/submissions/detail/226863603/
  */
  public int lengthOfLongestSubstring_0 (String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }

    int charMap[] = new int[256];
    Arrays.fill(charMap, -1);
    int maxSubStrLen = -1, startIndex = 0;

    for(int i = 0; i < s.length(); i++) {
      if(charMap[s.charAt(i)] != -1) {
        maxSubStrLen = Math.max(maxSubStrLen, i - startIndex);
        for(int j = startIndex; j < charMap[s.charAt(i)]; j++) {
          charMap[s.charAt(j)] = -1;
        }
        startIndex = charMap[s.charAt(i)] + 1;
      }
      charMap[s.charAt(i)] = i;
    }

    maxSubStrLen = Math.max(maxSubStrLen, s.length() - startIndex);

    return maxSubStrLen;
  }

  /*
  Runtime: 9 ms
  Memory Usage: 38.9 MB
  https://leetcode.com/submissions/detail/223135752/
  */
  public int lengthOfLongestSubstring_1(String s) {
    if(s == null || s.length() == 0)
      return 0;

    Map<Character, Integer> charMap = new HashMap<>();
    int maxLen = 0, startIndex = 0, i;
    for(i = 0; i < s.length(); i++) {
      if(charMap.containsKey(s.charAt(i))) {
        maxLen = maxLen < i-startIndex ?
            i-startIndex :
            maxLen;
        int firstOcc = charMap.get(s.charAt(i))+1;
        for(int j = startIndex; j < firstOcc; j++) {
          charMap.remove(s.charAt(j));
        }
        startIndex = firstOcc;
      }
      charMap.put(s.charAt(i), i);
    }
    maxLen = maxLen < i-startIndex ?
        i-startIndex :
        maxLen;

    return maxLen;
  }

  /*
  Runtime: 58 ms
  Memory Usage: 36.3 MB
  https://leetcode.com/submissions/detail/223134365/
  */
  public int lengthOfLongestSubstring_2(String s) {
    if(s == null || s.length() == 0)
      return 0;

    Map<Character, Integer> charMap = new HashMap<>();
    int maxLen = 0, startIndex = 0, i;
    for(i = 0; i < s.length(); i++) {
      if(charMap.containsKey(s.charAt(i))) {
        maxLen = maxLen < i-startIndex ?
            i-startIndex :
            maxLen;
        int firstOcc = charMap.get(s.charAt(i))+1;

        // traversing whole entrySet is inefficient in comparison to
        // targeted delete as in lengthOfLongestSubstring_1 solution
        charMap.entrySet()
            .removeIf(entrySet -> entrySet.getValue() < firstOcc);
        startIndex = firstOcc;
      }
      charMap.put(s.charAt(i), i);
    }
    maxLen = maxLen < i-startIndex ?
        i-startIndex :
        maxLen;

    return maxLen;
  }
}
