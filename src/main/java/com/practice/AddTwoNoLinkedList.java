package com.practice;

/*
Tags: LinkedListTag
https://leetcode.com/problems/add-two-numbers/
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

import com.practice.datastructures.ListNode;
import com.practice.datastructures.LinkedListUtils;
import com.practice.datastructures.SampleLinkedList;

public class AddTwoNoLinkedList {

  public static void main(String args[]) {
    AddTwoNoLinkedList test = new AddTwoNoLinkedList();
    LinkedListUtils.printLinkedList(
        test.addTwoNumbers(
            SampleLinkedList.sample_1(),
            SampleLinkedList.sample_2()
        )
    );
  }

  /*
  Runtime: 1 ms
  Memory Usage: 46.2 MB
  https://leetcode.com/submissions/detail/223128031/
  */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null)
      return l2;
    if(l2 == null)
      return l1;

    ListNode resultHead = null, curNode = null;
    int carry = 0;
    while(l1 != null && l2 != null) {
      if(resultHead == null) {
        resultHead = new ListNode((l1.val + l2.val + carry)%10);
        curNode = resultHead;
      } else {
        curNode.next = new ListNode((l1.val + l2.val + carry)%10);
        curNode = curNode.next;
      }
      carry = (l1.val + l2.val + carry)/10;
      l1 = l1.next;
      l2 = l2.next;
    }

    while(l1 != null) {
      curNode.next = new ListNode((l1.val + carry)%10);
      curNode = curNode.next;
      carry = (l1.val + carry)/10;
      l1 = l1.next;
    }


    while(l2 != null) {
      curNode.next = new ListNode((l2.val + carry)%10);
      curNode = curNode.next;
      carry = (l2.val + carry)/10;
      l2 = l2.next;
    }

    if(carry != 0) {
      curNode.next = new ListNode(carry);
    }

    return resultHead;
  }
}
