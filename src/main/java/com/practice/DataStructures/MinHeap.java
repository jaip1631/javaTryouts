package com.practice.DataStructures;

/**
 * Created by jaiprakash on 19/1/19
 */
public class MinHeap {

  private int size;
  private int capacity;
  private int arr[];

  public MinHeap(int arr[], int arrSize, int heapSize) {
    this.capacity = heapSize;
    this.size = arrSize;
    this.arr = new int[capacity];
    for (int i = 0; i < arrSize; i++) {
      this.arr[i] = arr[i];
    }

    heapify();
  }

  public MinHeap() {
  }

  private void heapify() {
    for (int i = size / 2; i >= 0; i--) {
      percolateUp(i);
    }
  }

  private int getLeftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int getRightChildIndex(int index) {
    return index *2+2;
  }

  private int getParentIndex(int index) {
    return (index-1)/2;
  }

  private void percolateUp(int index) {
    if(index < 0)
      return;
    int leftChildIndex = getLeftChildIndex(index);
    int rightChildIndex = getRightChildIndex(index);
    int minValueIndex = index;

    if(leftChildIndex < size
        && arr[leftChildIndex] < arr[minValueIndex])
        minValueIndex = leftChildIndex;
    if(rightChildIndex < size
        && arr[rightChildIndex] < arr[minValueIndex])
        minValueIndex = rightChildIndex;

    if(minValueIndex != index) {
      int temp = arr[index];
      arr[index] = arr[minValueIndex];
      arr[minValueIndex] = temp;

      percolateUp(getParentIndex(minValueIndex));
    }
  }

  public void push(int data) {
    if(size == capacity) {
      System.out.println("Heap Full");
      return;
    }

    arr[size++] = data;
    heapify();
  }

  public int pop() {
    if(size == 0) {
      System.out.println("Heap Already Empty");
      return -1;
    }

    int heapTop = arr[0];
    arr[0] = arr[size-1];
    --size;
    heapify();

    return heapTop;
  }

  public int top() {
    if(size == 0) {
      System.out.println("Heap Already Empty");
      return -1;
    }

    return arr[0];
  }
}
