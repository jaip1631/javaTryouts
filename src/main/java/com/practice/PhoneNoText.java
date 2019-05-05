package com.practice;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Letter Combinations of a Phone Number


Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNoText {

  public static void main(String args[]) {
    PhoneNoText test = new PhoneNoText();
    System.out.println(test.letterCombinations_0("23"));
  }

  private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  /*
  Runtime: 0 ms
  Memory Usage: 37 MB
  https://leetcode.com/submissions/detail/226874712/
  */
  public List<String> letterCombinations_0(String num) {
    if (num == null || num.length() == 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    helper(num, 0, new StringBuilder(), result);
    String[] res = new String[result.size()];

    return result;
  }

  private void helper(String num, int index, StringBuilder path, List<String> result) {
    if (index  == num.length()) {
      result.add(path.toString());
      return;
    }
    String key = keys[num.charAt(index) - '0'];
    for (int i = 0; i < key.length(); i++) {
      path.append(key.charAt(i));
      helper(num, index + 1, path, result);
      path.deleteCharAt(path.length() - 1);
    }
  }

  /*
  Runtime: 1 ms
  Memory Usage: 36.8 MB
  https://leetcode.com/submissions/detail/226691203/
  */
  public static Map<Integer, List<Character>> keyPad = new HashMap();
  static {
    keyPad.put(2, Arrays.asList('a', 'b', 'c'));
    keyPad.put(3, Arrays.asList('d', 'e', 'f'));
    keyPad.put(4, Arrays.asList('g', 'h', 'i'));
    keyPad.put(5, Arrays.asList('j', 'k', 'l'));
    keyPad.put(6, Arrays.asList('m', 'n', 'o'));
    keyPad.put(7, Arrays.asList('p', 'q', 'r', 's'));
    keyPad.put(8, Arrays.asList('t', 'u', 'v'));
    keyPad.put(9, Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations_1(String digits) {
    if(digits == null || digits.length() == 0) {
      return Collections.emptyList();
    }
    return letterCombinations(digits, 0);
  }

  public List<String> letterCombinations(String digits, int index) {
    if(index == digits.length()) {
      return Arrays.asList("");
    }

    List<String> result = new ArrayList<>();

    for(String str : letterCombinations(digits, index+1)) {
      for(Character ch : keyPad.get(digits.charAt(index) - '0')) {
        result.add(ch + str);
      }
    }

    return result;
  }
}
