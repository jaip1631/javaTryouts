package com.practice.datastructures;

/**
 * Created by jaiprakash on 10/1/19
 */
public class SampleLinkedList {

  /*
   * 1->2->3->NULL
   * */
  public static LinkedListNode sample_1() {
    LinkedListNode head = new LinkedListNode(1);
    LinkedListNode next_1 = new LinkedListNode(2);
    LinkedListNode next_2 = new LinkedListNode(3);
    LinkedListNode next_3 = new LinkedListNode(4);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;

    return head;
  }

  /*
   * 1->2->3->4->5->6->NULL
   * */
  public static LinkedListNode sample_2() {
    LinkedListNode head = new LinkedListNode(1);
    LinkedListNode next_1 = new LinkedListNode(2);
    LinkedListNode next_2 = new LinkedListNode(3);
    LinkedListNode next_3 = new LinkedListNode(4);
    LinkedListNode next_4 = new LinkedListNode(5);
    LinkedListNode next_5 = new LinkedListNode(6);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;
    next_3.next = next_4;
    next_4.next = next_5;

    return head;
  }
}
