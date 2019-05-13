package com.practice;

/*
Tags: BackTrackingTag, MathTag
https://leetcode.com/problems/permutation-sequence/
Permutation Sequence

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

*/

import java.util.ArrayList;
import java.util.List;

public class NthPermutationLexographic {

  public static void main(String args[]) {
    NthPermutationLexographic test = new NthPermutationLexographic();
    System.out.println(
        test.getNthPermutation(
            3,
            3
        )
    );
  }

  /*
  Runtime: 2 ms
  Memory Usage: 33.4 MB
  https://leetcode.com/submissions/detail/228561731/
  */
  public String getNthPermutation(Integer max, Integer n) {
    List<Integer> list = new ArrayList<>();
    for(int i = 1; i <= max; i++) {
      list.add(i);
    }
    StringBuilder result = new StringBuilder();

    MyInteger target = new MyInteger();
    target.setI(n);

    int fac[] = new int [list.size()+1];
    fillFactorials(fac);
    if(n > fac[fac.length-1]) {
      return "";
    }

    while (!list.isEmpty()) {
      int candidate = getStartingNum(list, target, fac);
      list.remove(list.indexOf(candidate));
      result.append(candidate);
    }

    return result.toString();
  }

  private void fillFactorials(int fac[]) {
    fac[0] = 1;
    for(int i = 1; i < fac.length; i++) {
      fac[i] = i * fac[i-1];
    }
  }

  private int getStartingNum(List<Integer> list, MyInteger targetPos, int fac[]) {
    for(int i = 1; i <= list.size(); i++) {
      if(i * fac[list.size()-1] >= targetPos.getI()) {
        targetPos.setI(targetPos.getI()-((i-1)*fac[list.size()-1]));
        return list.get(i-1);
      }
    }
    return -1;
  }

  public class MyInteger {
    Integer i;
    public void setI(Integer i) {
      this.i = i;
    }
    public Integer getI() {
      return i;
    }
  }
}
