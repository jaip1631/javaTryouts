package com.practice.DataStructures;

/**
 * Created by jaiprakash on 9/12/18
 */
public class DoubleLinkedListNode {
  public Integer data;
  public DoubleLinkedListNode next, previous;

  public DoubleLinkedListNode (int data) {
    this.data = data;
    next = previous = null;
  }

  public DoubleLinkedListNode() {}
}
