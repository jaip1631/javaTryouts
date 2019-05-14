package com.practice.datastructures;

public class MinHeap {
  private Integer arr[];
  private int curIndex;

  public MinHeap(int arr[], int arrSize) {
    this.arr = new Integer[arrSize];
    for (curIndex = 0; curIndex < arrSize; curIndex++) {
      this.arr[curIndex] = arr[curIndex];
    }
    curIndex--;
    heapify(getParent(curIndex));
  }
  public MinHeap(int size) {
    arr = new Integer[size];
    curIndex = -1;
  }

  public Integer top() {
    if(curIndex != -1) {
      return arr[0];
    }
    return null;
  }

  public Integer pop() {
    if(curIndex == -1) {
      return null;
    }

    Integer topElm = top();
    arr[0] = arr[curIndex];
    curIndex--;

    if(curIndex != -1) {
      percolateDown(0);
    }

    return topElm;
  }

  public void add(int n) {
    if(curIndex == arr.length-1) {
      return;
    }

    arr[++curIndex] = n;

    percolateUp(curIndex);
  }

  private void heapify(int startIndex) {
    if(startIndex < 0) {
      return;
    }

    for(int i = startIndex; i>=0; i--) {
      percolateDown(i);
    }
  }

  // used when replacing top with last element
  // and re-imposing heap property. And Heapify
  private void percolateDown(int index) {
    int leftChildIndex = getLeftChild(index);
    int rightChildIndex = getRightChild(index);
    int min = index;
    if(leftChildIndex <= curIndex && arr[min] > arr[leftChildIndex]) {
      min = leftChildIndex;
    }
    if(rightChildIndex <= curIndex && arr[min] > arr[rightChildIndex]) {
      min = rightChildIndex;
    }

    if(min != index) {
      swap(min, index);
      percolateDown(min);
    }
  }

  // used when adding an element at end of arr[]
  private void percolateUp(int index) {
    int parentIndex = getParent(index);
    if(parentIndex >= 0 && arr[parentIndex] > arr[index]) {
      swap(parentIndex, index);
      percolateUp(parentIndex);
    }
  }

  private void swap(int a, int b) {
    Integer temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  private int getParent(int index) {
    return (index-1)/2;
  }

  private int getLeftChild(int index) {
    return (index*2)+1;
  }

  private int getRightChild(int index) {
    return (index*2)+2;
  }
}