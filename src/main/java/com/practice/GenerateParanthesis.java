package com.practice;

/*
https://leetcode.com/problems/generate-parentheses/
Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateParanthesis {

  public static void main(String args[]) {
    GenerateParanthesis test = new GenerateParanthesis();
    System.out.println(test.generateParenthesis_0(3));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 40 MB
  https://leetcode.com/submissions/detail/226721383/
  */
  public List<String> generateParenthesis_0(int n) {
    StringBuilder path = new StringBuilder();
    List<String> result = new ArrayList<>();

    generateParanthesis_0(n, n, path, result);

    return result;
  }

  public void generateParanthesis_0(int openRem, int closedRem,
      StringBuilder path, final List<String> result) {
    if(openRem == 0 && closedRem == 0) {
      result.add(path.toString());
      return;
    }

    if(openRem < closedRem) {
      path.append(")");
      generateParanthesis_0(openRem, closedRem-1, path, result);
      path.deleteCharAt(path.length()-1);
    }

    if(openRem != 0) {
      path.append("(");
      generateParanthesis_0(openRem-1, closedRem, path, result);
      path.deleteCharAt(path.length()-1);
    }
  }

  /*
  Runtime: 4 ms
  Memory Usage: 41 MB
  https://leetcode.com/submissions/detail/226719537/
  */
  public List<String> generateParenthesis_1(int n) {
    return generateParenthesis_1(n, n);
  }

  public List<String> generateParenthesis_1(int openRem, int closedRem) {
    if(closedRem == 0) {
      return Arrays.asList("");
    }

    List<String> useClosed = Collections.emptyList();
    List<String> useOpened = Collections.emptyList();

    if(openRem < closedRem) {
      useClosed = generateParenthesis_1(openRem, closedRem-1);
    }

    if(openRem != 0) {
      useOpened = generateParenthesis_1(openRem-1 ,closedRem);
    }

    List<String> result = new ArrayList<>();

    for(String str : useOpened) {
      result.add("(" + str);
    }
    for(String str : useClosed) {
      result.add(")" + str);
    }

    return result;
  }
}
