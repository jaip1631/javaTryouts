package com.practice;

/*
Tags: BackTrackingTag
https://leetcode.com/problems/permutations/
Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String args[]) {
    Permutations test = new Permutations();
    System.out.println(test.permute_0(new int[]{1,2,3}));
  }

  /*
  Runtime: 1 ms
  Memory Usage: 36.5 MB
  https://leetcode.com/submissions/detail/228236758/
  Note: Solution using swapping palces.
  */
  public List<List<Integer>> permute_0(int[] nums) {
    List<List<Integer>> lists =new ArrayList<>();
    permute(nums,0,lists);
    return lists;

  }
  public static void permute(int[] array,int start,List<List<Integer>> lists){
    if (start==array.length){
      List<Integer> list=new ArrayList<>();
      for(int a:array){
        list.add(a);
      }
      lists.add(list);
    }
    else {
      for(int i=start;i<array.length;i++){
        swap(array,start,i);
        permute(array,start+1,lists);
        swap(array,i,start);
      }
    }
  }

  private static void swap(int[] array,int s,int i){
    int t= array[s];
    array[s]=array[i];
    array[i]=t;
  }

  /*
  Runtime: 1 ms
  Memory Usage: 37.5 MB
  https://leetcode.com/submissions/detail/228229556/
  */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    permute(nums, result, path);
    return result;
  }

  private void permute(int nums[], final List<List<Integer>> result,
      final List<Integer> path) {
    if(path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i = 0; i < nums.length; i++) {
      if(!path.contains(nums[i])) {
        path.add(nums[i]);
        permute(nums, result, path);
        path.remove(path.size()-1);
      }
    }
  }
}
