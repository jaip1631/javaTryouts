package com.practice.datastructures;

public class LinkedListUtils {
  public static void printLinkedList(LinkedListNode head) {
    while(head != null) {
      System.out.print(head.data + "->");
      head = head.next;
    }
    System.out.println("NULL");
  }
}
