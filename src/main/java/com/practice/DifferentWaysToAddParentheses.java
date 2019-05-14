package com.practice;

/*
Tags: DPTag, DivideAndConquerTag
https://leetcode.com/problems/different-ways-to-add-parentheses/
Different Ways to Add Parentheses
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

  public static void main(String args[]) {
    DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
    System.out.println(test.diffWaysToCompute("1+2-3*4+5"));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 39 MB
  https://leetcode.com/submissions/detail/228892049/
  Note: Faster on smaller inputs only. Use DP solution for larger inputs
  */
  public List<Integer> diffWaysToCompute(String input) {
    return breaker(input, 0, input.length()-1);
  }

  public List<Integer> breaker(String input, int start, int end) {
    List<Integer> result = new ArrayList<>();
    boolean isNumber = true;
    for(int i = start; i <= end; i++) {
      if(input.charAt(i) == '-'
          || input.charAt(i) == '+'
          || input.charAt(i) == '*') {
        isNumber = false;
        List<Integer> left = breaker(input, start, i-1);
        List<Integer> right = breaker(input, i+1, end);

        for(Integer a: left) {
          for(Integer b: right) {
            if(input.charAt(i) == '-') {
              result.add(a-b);
            } else if(input.charAt(i) == '+') {
              result.add(a+b);
            } else {
              result.add(a*b);
            }
          }
        }
      }
    }

    if(isNumber) {
      result.add(Integer.parseInt(input.substring(start, end+1)));
    }
    return result;
  }

  /*
  Runtime: 13 ms
  Memory Usage: 35.7 MB
  https://leetcode.com/submissions/detail/228893056/
  Note: DP solution. Slower for smaller inputs but very efficient for larger inputs.
  */
  private Map<String, List<Integer>> map;
  public List<Integer> diffWaysToCompute_1(String input) {
    map = new HashMap<>();
    return breaker_1(input, 0, input.length()-1);
  }

  public List<Integer> breaker_1(String input, int start, int end) {
    if(map.containsKey(String.format("%d_%d", start, end))) {
      return map.get(String.format("%d_%d", start, end));
    }

    List<Integer> result = new ArrayList<>();
    boolean isNumber = true;
    for(int i = start; i <= end; i++) {
      if(input.charAt(i) == '-'
          || input.charAt(i) == '+'
          || input.charAt(i) == '*') {
        isNumber = false;
        List<Integer> left = breaker_1(input, start, i-1);
        List<Integer> right = breaker_1(input, i+1, end);

        for(Integer a: left) {
          for(Integer b: right) {
            if(input.charAt(i) == '-') {
              result.add(a-b);
            } else if(input.charAt(i) == '+') {
              result.add(a+b);
            } else {
              result.add(a*b);
            }
          }
        }
      }
    }

    if(isNumber) {
      result.add(Integer.parseInt(input.substring(start, end+1)));
    }

    map.put(String.format("%d_%d", start, end), result);
    return result;
  }
}
