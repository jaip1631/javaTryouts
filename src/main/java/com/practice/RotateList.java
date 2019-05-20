package com.practice;

/*
Tags: LinkedListTag, TwoPointersTag
https://leetcode.com/problems/rotate-list/
Rotate List

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

*/

import com.practice.datastructures.LinkedListUtils;
import com.practice.datastructures.ListNode;
import com.practice.datastructures.SampleLinkedList;

public class RotateList {

  public static void main(String args[]) {
    RotateList test = new RotateList();
    LinkedListUtils.printLinkedList(SampleLinkedList.sample_2());
    int k = 9;
    System.out.println("K:" + k);
    LinkedListUtils.printLinkedList(
        test.rotateRight_0(
            SampleLinkedList.sample_2(),
            k
        )
    );
  }

  /*
  Runtime: 0 ms
  Memory Usage: 35.3 MB
  https://leetcode.com/submissions/detail/229897478/
  */
  public ListNode rotateRight_0(ListNode head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode rightEnd = head, rightHead = head, newHead = null;
    int length = 1;
    for(; rightEnd.next != null && length <= k; length++) {
      rightEnd = rightEnd.next;
    }
    k = k % length;
    if(k == 0) {
      return head;
    }
    rightEnd = head;
    for(length = 1; rightEnd.next != null && length <= k; length++) {
      rightEnd = rightEnd.next;
    }
    while(rightEnd.next != null) {
      rightEnd = rightEnd.next;
      rightHead = rightHead.next;
    }
    rightEnd.next = head;
    newHead = rightHead.next;
    rightHead.next = null;

    return newHead;
  }

  /*
  Runtime: 1 ms
  Memory Usage: 35 MB
  https://leetcode.com/submissions/detail/229654344/
  */
  public ListNode rotateRight_1(ListNode head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    k = k % getLength(head);
    ListNode rightEnd = head, rightHead = head, newHead = null;
    for(int i = 0; rightEnd.next != null && i < k; i++) {
      rightEnd = rightEnd.next;
    }
    while(rightEnd.next != null) {
      rightEnd = rightEnd.next;
      rightHead = rightHead.next;
    }
    rightEnd.next = head;
    newHead = rightHead.next;
    rightHead.next = null;
    return newHead;
  }

  private int getLength(ListNode head) {
    int length = 0;
    while(head != null) {
      head = head.next;
      length++;
    }
    return length;
  }

}
