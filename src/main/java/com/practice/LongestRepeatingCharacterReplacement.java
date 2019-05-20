package com.practice;

/*
Tags: StarTag, TwoPointersTag, SlidingWindowTag
https://leetcode.com/problems/longest-repeating-character-replacement/
Longest Repeating Character Replacement

Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/

public class LongestRepeatingCharacterReplacement {

  public static void main(String args[]) {
    LongestRepeatingCharacterReplacement test = new LongestRepeatingCharacterReplacement();
    System.out.println(test.characterReplacement_0("AABABBA", 1));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 34.8 MB
  https://leetcode.com/submissions/detail/229901114/
  */
  public int characterReplacement_0(String str, int k) {
    int start = 0, end = 0;
    int localMaxFreq = 0, maxWinLen = 0;
    int arr[] = new int[26];
    char s[] = str.toCharArray();

    for(start = 0, end = 0; end < s.length; end++) {
      if(localMaxFreq < ++arr[s[end]-'A']) {
        localMaxFreq = arr[s[end]-'A'];
      }
      while(end-start+1 - localMaxFreq > k) {
        --arr[s[start++]-'A'];
      }
      if(maxWinLen < end-start+1) {
        maxWinLen = end-start+1;
      }
    }

    return maxWinLen;
  }
  /*
  Runtime: 4 ms
  Memory Usage: 34.8 MB
  https://leetcode.com/submissions/detail/229900964/
  */
  public int characterReplacement_1(String s, int k) {
    int start = 0, end = 0;
    int localMaxFreq = 0, maxWinLen = 0;
    int arr[] = new int[26];

    for(start = 0, end = 0; end < s.length(); end++) {
      if(localMaxFreq < ++arr[s.charAt(end)-'A']) {
        localMaxFreq = arr[s.charAt(end)-'A'];
      }
      while(end-start+1 - localMaxFreq > k) {
        --arr[s.charAt(start++)-'A'];
      }
      if(maxWinLen < end-start+1) {
        maxWinLen = end-start+1;
      }
    }

    return maxWinLen;
  }

  /*
  Runtime: 7 ms
  Memory Usage: 35.3 MB
  https://leetcode.com/submissions/detail/229894740/
  */
  public int characterReplacement_2(String s, int k) {
    int start = 0, end = 0;
    int localMaxFreq = 0, maxWinLen = 0;
    int arr[] = new int[26];

    for(start = 0, end = 0; end < s.length(); end++) {
      arr[s.charAt(end)-'A']++;
      if(localMaxFreq < arr[s.charAt(end)-'A']) {
        localMaxFreq = arr[s.charAt(end)-'A'];
      }
      while(end-start+1 - localMaxFreq > k) {
        arr[s.charAt(start)-'A']--;
        start++;
        localMaxFreq = getMaxValue_2(arr);
      }
      if(maxWinLen < end-start+1) {
        maxWinLen = end-start+1;
      }
    }

    return maxWinLen;
  }

  private int getMaxValue_2(int arr[]) {
    int max = arr[0];

    for(int i = 1; i < arr.length; i++) {
      if(max < arr[i]) {
        max = arr[i];
      }
    }
    return max;
  }
}
