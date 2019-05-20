package com.practice.datastructures;

/**
 * Created by jaiprakash on 10/1/19
 */
public class SampleLinkedList {

  /*
   * 1->2->3->NULL
   * */
  public static ListNode sample_1() {
    ListNode head = new ListNode(1);
    ListNode next_1 = new ListNode(2);
    ListNode next_2 = new ListNode(3);
    ListNode next_3 = new ListNode(4);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;

    return head;
  }

  /*
   * 1->2->3->4->5->6->NULL
   * */
  public static ListNode sample_2() {
    ListNode head = new ListNode(1);
    ListNode next_1 = new ListNode(2);
    ListNode next_2 = new ListNode(3);
    ListNode next_3 = new ListNode(4);
    ListNode next_4 = new ListNode(5);
    ListNode next_5 = new ListNode(6);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;
    next_3.next = next_4;
    next_4.next = next_5;

    return head;
  }
}
