package com.practice;

/*
https://leetcode.com/problems/container-with-most-water/
Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


8      |         |
7      |         |   |
6      | |       |   |
5      | |   |   |   |
4      | |   | | |   |
3      | |   | | | | |
2      | | | | | | | |
1    | | | | | | | | |

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

import java.util.ArrayList;
import java.util.List;

public class RainWaterTrappingContainer {

  public static void main(String args[]) {
    RainWaterTrappingContainer test = new RainWaterTrappingContainer();
    System.out.println(test.maxArea_0(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 40.6 MB
  https://leetcode.com/submissions/detail/223778839/
  */
  public int maxArea_0(int[] height) {
    int max = Integer.MIN_VALUE;
    int left = 0;
    int right = height.length - 1;

    while(left < right){
      int l = height[left];
      int r = height[right];
      max = Math.max(max, ((Math.min(l, r) * (right - left))));
      if(l <  r)
        left++;
      else
        right--;
    }

    return max;
  }


  /*
  Runtime: 15 ms
  Memory Usage: 40.8 MB
  https://leetcode.com/submissions/detail/223776318/
  */
  public int maxArea_1(int[] height) {
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    int area = 0;

    List<Integer> highToLow = new ArrayList<>();

    for(int i = height.length-1; i >=0; i--) {
      if(highToLow.isEmpty() ||
          height[i] > height[highToLow.get(highToLow.size()-1)]){
        right[i] = i;
        highToLow.add(i);
      } else {
        int j = highToLow.size()-1;
        while(j >= 0 &&
            height[i] <= height[highToLow.get(j)]) {
          right[i] = highToLow.get(j);
          j--;
        }
      }
    }

    highToLow.clear();
    for(int i = 0; i < height.length; i++) {
      if(highToLow.isEmpty() ||
          height[i] > height[highToLow.get(highToLow.size()-1)]){
        left[i] = i;
        highToLow.add(i);
      } else {
        int j = highToLow.size()-1;
        while(j >= 0 &&
            height[i] <= height[highToLow.get(j)]) {
          left[i] = highToLow.get(j);
          j--;
        }
      }
    }

    for(int i = 0; i < height.length; i++) {
      area = Math.max(Math.min(height[left[i]], height[right[i]]) *
          (right[i] - left[i]), area);
    }
    return area;
  }
}
