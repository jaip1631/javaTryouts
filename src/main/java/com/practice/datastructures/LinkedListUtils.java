package com.practice.datastructures;

public class LinkedListUtils {
  public static void printLinkedList(ListNode head) {
    while(head != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println("NULL");
  }
}
