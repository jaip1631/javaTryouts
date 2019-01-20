package com.practice.DataStructures;

import java.util.ListIterator;

/**
 * Created by jaiprakash on 9/12/18
 */
public class DLLIterator implements ListIterator {
  DoubleLinkedListNode node = null;

  public boolean hasNext() {
    return node != null;
  }

  public Object next() {
    Object data  = node.data;
    node = node.next;
    return data;
  }

  public boolean hasPrevious() {
    return node != null && node.previous != null;
  }

  public Object previous() {
    node = node.previous;
    return node.data;
  }

  public int nextIndex() {
    return 0;
  }

  public int previousIndex() {
    return 0;
  }

  public void remove() {

  }

  public void set(Object o) {

  }

  public void add(Object o) {
    if(node == null) {

    }
  }
}
