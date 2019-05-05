package com.practice;

import com.practice.DataStructures.LinkedListNode;
import com.practice.DataStructures.SampleLinkedList;
import com.practice.DataStructures.TreeNode;
import com.practice.DataStructures.Utils;
import javax.rmi.CORBA.Util;

/**
 * Created by jaiprakash on 10/1/19
 */
public class LinkedListToBalancedBST {
  LinkedListNode head;

  private TreeNode convertLinkedListToBalancedBST(LinkedListNode head) {
    this.head = head;

    return constructAndFillBalancedBST(head);
    /*return constructThenFillBalancedBST(head);*/
  }

  private TreeNode constructAndFillBalancedBST(LinkedListNode head) {
    return null;
  }

  private TreeNode constructThenFillBalancedBST(LinkedListNode head) {
    TreeNode root = constructEmptyBalancedTree(head);
    fillBalancedTree(root);
    return root;
  }

  private TreeNode constructEmptyBalancedTree(LinkedListNode head) {
    return Utils.constructBalancedTreeOfSize(Utils.getSizeLinkedList(head));
  }

  private void fillBalancedTree(TreeNode root) {
    if(root == null || head == null)
      return;

    if(root.left != null) {
      fillBalancedTree(root.left);
    }

    root.data = head.data;
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
