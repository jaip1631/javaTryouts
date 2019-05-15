package com.practice;

/*
Tags: HeapTag, DivideAndConquerTag
https://leetcode.com/problems/k-closest-points-to-origin/
K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

*/

import com.practice.datastructures.Utils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthClosestPointToOrigin {

  public static void main(String args[]) {
    KthClosestPointToOrigin test = new KthClosestPointToOrigin();
    int mat[][] = new int [][]{{3,3},{5,-1},{-2,4}};
    Utils.printMatrix(mat);
    int result[][] = test.kClosest_0(mat, 2);
    Utils.printMatrix(result);
  }

  /*
  Runtime: 3 ms
  Memory Usage: 60.8 MB
  https://leetcode.com/submissions/detail/229001571/
  Note: Divide and conquer solution (using QuickSort)
  */
  public int[][] kClosest_0(int[][] points, int K) {
    if(points == null || points.length == 0) return points;
    if(K < 1) return new int[][]{{0,0}};

    int left = 0;
    int right = points.length-1;
    while(left < right){
      int pivot = partition_0(points, left, right);
      if(pivot == K) break;
      else if(pivot < K) left = pivot;
      else right = pivot-1;
    }
    return Arrays.copyOf(points, K);
  }

  public int partition_0(int[][] points, int start, int end){
    int pivot = distance_0(points[end]);
    int left = start;
    int right = end-1;
    while(left <= right){
      while(left <= right && distance_0(points[left]) < pivot) left ++;
      while(left <= right && distance_0(points[right]) > pivot) right --;
      if(left <= right){
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
        left ++;
        right --;
      }
    }
    int[] temp = points[left];
    points[left] = points[end];
    points[end] = temp;

    return left;
  }

  public int distance_0(int[] point){
    return point[0]*point[0] + point[1]*point[1];
  }

  /*
  Runtime: 20 ms
  Memory Usage: 61 MB
  https://leetcode.com/submissions/detail/228999761/
  Note: Faster than below solution because we don't need to recalculate
        getDistance for pq.peek()
  */
  public class PointRef {
    private int index;
    private int distance;
    public int getDistance_1(){
      return distance;
    }
    public int getIndex(){
      return index;
    }
    public PointRef(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }
  }

  public int[][] kClosest_1(int[][] points, int K) {
    PriorityQueue<PointRef> pq =
        new PriorityQueue<>(
            K,
            new comp_1()
        );

    for(int i = 0; i < points.length; i++) {
      int thisDistance = getDistance_1(points[i]);
      if(i < K) {
        pq.add(new PointRef(i, thisDistance));
      } else if(thisDistance < pq.peek().getDistance_1()) {
        pq.poll();
        pq.add(new PointRef(i, thisDistance));
      }
    }

    int result[][] = new int[pq.size()][2];
    int i = 0;
    for(PointRef p : pq) {
      result[i][0] = points[p.getIndex()][0];
      result[i][1] = points[p.getIndex()][1];
      i++;
    }
    return result;
  }

  public int getDistance_1(int points[]) {
    return (points[0]*points[0]) + (points[1]*points[1]);
  }

  class comp_1 implements Comparator<PointRef> {

    @Override
    public int compare(PointRef o1, PointRef o2) {
      return o2.getDistance_1()-o1.getDistance_1();
    }
  }

  /*
  Runtime: 29 ms
  Memory Usage: 59.1 MB
  https://leetcode.com/submissions/detail/229002717/
  Note: We re-calculate getDistance for each pq.peek(). Hence slow
  */
  public int[][] kClosest_2(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        K,
        new comp_2()
    );

    for(int i = 0; i < points.length; i++) {
      if(i < K) {
        pq.add(points[i]);
      } else if(getDistance_2(points[i]) < getDistance_2(pq.peek())) {
        pq.poll();
        pq.add(points[i]);
      }
    }

    int result[][] = new int[pq.size()][2];
    while(K-- > 0){
      result[K] = pq.poll();
    }
    return result;
  }
  public int getDistance_2(int points[]) {
    return (points[0]*points[0]) + (points[1]*points[1]);
  }

  class comp_2 implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return getDistance_2(o2)- getDistance_2(o1);
    }
  }
}
