package com.practice;

/*
Tags: HeapTag, DivideAndConquerTag
https://leetcode.com/problems/kth-largest-element-in-an-array/
Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/

import com.practice.datastructures.MinHeap;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

  public static void main(String args[]) {
    KthLargestElementInArray test = new KthLargestElementInArray();
    System.out.println(test.findKthLargest_0(new int[]{3,2,3,1,2,4,5,5,6}, 4));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 36.7 MB
  https://leetcode.com/submissions/detail/228676828/
  */
  public int findKthLargest_0(int[] nums, int k) {
    MinHeap minHeap = new MinHeap(nums, k);
    for(int i = k; i < nums.length; i++) {
      if(nums[i] > minHeap.top()) {
        minHeap.pop();
        minHeap.add(nums[i]);
      }
    }
    return minHeap.top();
  }

  /*
  Runtime: 4 ms
  Memory Usage: 37.1 MB
  https://leetcode.com/submissions/detail/228671827/
  Note: Using inbuilt priority queue
  */
  public int findKthLargest_1(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for(int i = 0; i < nums.length; i++){
      if(i < k){
        minHeap.offer(nums[i]);
      }else if(minHeap.peek() < nums[i]){
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }
    return minHeap.peek();
  }

  /*
  Runtime: 35 ms
  Memory Usage: 36.8 MB
  https://leetcode.com/submissions/detail/228685275/
  Note: gets optimised by taking random pivot element
  */
  public int findKthLargest_2(int[] nums, int k) {
    return KthLargestUsingQuickSortDesc(nums, 0, nums.length-1, k);
  }

  public int KthLargestUsingQuickSortDesc(int nums[], int start, int end, int k) {
    int pivot = nums[end];
    int left = start;
    int right = end-1;

    while(left <= right) {
      if(nums[left] > pivot) {
        left++;
      } else {
        swap(nums, left, right);
        right--;
      }
    }
    swap(nums, left, end);
    int rank = left-start+1;
    if(k == rank) {
      return nums[left];
    } else if(k < rank ) {
      // move left
      return KthLargestUsingQuickSortDesc(nums, start, left-1, k);
    } else {
      // move right
      return KthLargestUsingQuickSortDesc(nums, left+1, end, k-(rank));
    }
  }

  public void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
