package com.practice.DataStructures;

/**
 * Created by jaiprakash on 10/1/19
 */
public class SampleLinkedList {

  /*
   * 10->20->30->NULL
   * */
  public static LinkedListNode sample_1() {
    LinkedListNode head = new LinkedListNode(10);
    LinkedListNode next_1 = new LinkedListNode(20);
    LinkedListNode next_2 = new LinkedListNode(30);
    LinkedListNode next_3 = new LinkedListNode(40);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;

    return head;
  }

  /*
   * 10->20->30->40->50->60->NULL
   * */
  public static LinkedListNode sample_2() {
    LinkedListNode head = new LinkedListNode(10);
    LinkedListNode next_1 = new LinkedListNode(20);
    LinkedListNode next_2 = new LinkedListNode(30);
    LinkedListNode next_3 = new LinkedListNode(40);
    LinkedListNode next_4 = new LinkedListNode(50);
    LinkedListNode next_5 = new LinkedListNode(60);

    head.next = next_1;
    next_1.next = next_2;
    next_2.next = next_3;
    next_3.next = next_4;
    next_4.next = next_5;

    return head;
  }
}
