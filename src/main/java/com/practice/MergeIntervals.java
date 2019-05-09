package com.practice;

/*
Tags: ArraysTag
https://leetcode.com/problems/merge-intervals/
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/

import com.practice.DataStructures.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public static void main(String args[]) {
    MergeIntervals test = new MergeIntervals();
    int arr[][] = test.merge_0(new int[][]{{1,7}, {3,6}, {8,9}, {10, 11}});
    Utils.printMatrix(arr, arr.length, 2);
  }

  /*
  Runtime: 1 ms
  HOW IS IT WORKING???
  */
  public int[][] merge_0(int[][] intervals) {
    if (intervals==null || intervals.length==0) return new int[0][0];
    int[] a = new int[intervals.length];
    int[] b = new int[intervals.length];
    for (int i=0; i< intervals.length; i++)
    {
      a[i] = intervals[i][0];
      b[i] = intervals[i][1];
    }

    Arrays.sort(a);
    Arrays.sort(b);

    List<int[]> res = new ArrayList<int[]>();
    int i = 0;
    int j = 0;
    int first = a[i];
    i++;
    while (i<intervals.length)
    {
      while (i< intervals.length && b[j]>=a[i])
      {
        i++;
        j++;
      }

      if (i==intervals.length) break;
      res.add(new int[]{first, b[j]});


      first = a[i];
      i++;
      j++;
    }

    res.add(new int[]{first,b[intervals.length-1]} );
    int[][] r = new int[res.size()][2];
    for (i = 0; i< res.size(); i++)
    {
      r[i][0] = res.get(i)[0];
      r[i][1] = res.get(i)[1];
    }

    return r;
  }


  /*
  Runtime: 6 ms
  Memory Usage: 41.1 MB
  https://leetcode.com/submissions/detail/227837690/
  */
  public int[][] merge_1(int[][] intervals) {
    if(intervals.length == 0) {
      return new int[0][0];
    }

    //arguments to this method represent the arrays to be sorted
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    /*
    Saw that using Comparator.comparingInt had 45 ms runtime.

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });
    */

    List<Integer[]> list = new ArrayList<>();
    int start = intervals[0][0], end=intervals[0][1];
    for(int i = 0; i < intervals.length-1; i++) {
      //separate pair
      if(end < intervals[i+1][0]) {
        list.add(createPair(start, end));

        start = intervals[i+1][0];
        end = intervals[i+1][1];
      } else {
        end = Math.max(end, intervals[i+1][1]);
      }
    }

    //last cases

    list.add(createPair(
        start,
        end
    ));

    int result[][] = new int[list.size()][2];

    for(int i = 0; i < list.size(); i++) {
      result[i][0] = list.get(i)[0];
      result[i][1] = list.get(i)[1];
    }

    return result;
  }

  public Integer [] createPair(Integer a, Integer b) {
    Integer pair[] = new Integer[2];
    pair[0] = a;
    pair[1] = b;

    return pair;
  }

}
