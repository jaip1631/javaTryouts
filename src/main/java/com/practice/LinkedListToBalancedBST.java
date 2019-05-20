package com.practice;

import com.practice.datastructures.ListNode;
import com.practice.datastructures.SampleLinkedList;
import com.practice.datastructures.TreeNode;
import com.practice.datastructures.Utils;

/**
 * Created by jaiprakash on 10/1/19
 */
public class LinkedListToBalancedBST {
  ListNode head;

  private TreeNode convertLinkedListToBalancedBST(ListNode head) {
    this.head = head;

    return constructAndFillBalancedBST(head);
    /*return constructThenFillBalancedBST(head);*/
  }

  private TreeNode constructAndFillBalancedBST(ListNode head) {
    return null;
  }

  private TreeNode constructThenFillBalancedBST(ListNode head) {
    TreeNode root = constructEmptyBalancedTree(head);
    fillBalancedTree(root);
    return root;
  }

  private TreeNode constructEmptyBalancedTree(ListNode head) {
    return Utils.constructBalancedTreeOfSize(Utils.getSizeLinkedList(head));
  }

  private void fillBalancedTree(TreeNode root) {
    if(root == null || head == null)
      return;

    if(root.left != null) {
      fillBalancedTree(root.left);
    }

    root.val = head.val;
    head = head.next;

    if(root.right != null) {
      fillBalancedTree(root.right);
    }
  }

  public static void main(String args[]) {
    LinkedListToBalancedBST test = new LinkedListToBalancedBST();
    test.convertLinkedListToBalancedBST(SampleLinkedList.sample_2());
  }
}
