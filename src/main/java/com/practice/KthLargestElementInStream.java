package com.practice;

import com.practice.DataStructures.MinHeap;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by jaiprakash on 19/1/19
 */
public class KthLargestElementInStream {
  public void printKthLargest(int arr[], int arrSize, int k) {
    MinHeap minHeap = null;
    int kthLargestElem = -1;
    for(int i = 0;  i < arrSize; i++) {
      if(i == k-1) {
        minHeap = new MinHeap(arr, k, k);
        kthLargestElem = minHeap.top();
      }
      else if(i > k -1) {
        if(minHeap.top() < arr[i]) {
          minHeap.pop();
          minHeap.push(arr[i]);
          kthLargestElem = minHeap.top();
        }
      }
      else {
        kthLargestElem = -1;
      }
      System.out.print(kthLargestElem + " ");
    }
  }

  public static void main(String args[]) {
    KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream();
    int arr[] = {755, 400, 933, 61 };
    int arrSize = arr.length;
    kthLargestElementInStream.printKthLargest(arr, arrSize, 4);
  }
}
