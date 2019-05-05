package com.practice;

/*
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

import com.practice.DataStructures.LinkedListNode;
import com.practice.DataStructures.LinkedListUtils;
import com.practice.DataStructures.SampleLinkedList;

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
  public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
    if(l1 == null)
      return l2;
    if(l2 == null)
      return l1;

    LinkedListNode resultHead = null, curNode = null;
    int carry = 0;
    while(l1 != null && l2 != null) {
      if(resultHead == null) {
        resultHead = new LinkedListNode((l1.data + l2.data + carry)%10);
        curNode = resultHead;
      } else {
        curNode.next = new LinkedListNode((l1.data + l2.data + carry)%10);
        curNode = curNode.next;
      }
      carry = (l1.data + l2.data + carry)/10;
      l1 = l1.next;
      l2 = l2.next;
    }

    while(l1 != null) {
      curNode.next = new LinkedListNode((l1.data + carry)%10);
      curNode = curNode.next;
      carry = (l1.data + carry)/10;
      l1 = l1.next;
    }


    while(l2 != null) {
      curNode.next = new LinkedListNode((l2.data + carry)%10);
      curNode = curNode.next;
      carry = (l2.data + carry)/10;
      l2 = l2.next;
    }

    if(carry != 0) {
      curNode.next = new LinkedListNode(carry);
    }

    return resultHead;
  }
}
