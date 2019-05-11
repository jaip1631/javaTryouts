package com.practice;

import com.practice.datastructures.DoubleLinkedListNode;
import com.practice.datastructures.TreeNode;
import com.practice.datastructures.SampleBinarySearchTrees;

/**
 * Created by jaiprakash on 9/12/18
 */

public class BottomViewOfTree {
  private DoubleLinkedListNode node, head;
  /*
   *           0
   *       1       2
   *          3         4
   *                        5
   * */

  private void bottomViewOfTreeUtil(TreeNode root, DoubleLinkedListNode node) {
    if(root == null) {
      return;
    }

    if (node == null) {
      node = new DoubleLinkedListNode(root.data);
      head = node;
    } else {
      node.data = root.data;
    }

    if(root.left != null) {
      if(node.previous == null) {
        node.previous = new DoubleLinkedListNode();
        node.previous.next = node;
        head = node.previous;
      }
      bottomViewOfTreeUtil(root.left, node.previous);
    }

    if(root.right != null) {
      if(node.next == null) {
        node.next = new DoubleLinkedListNode();
        node.next.previous = node;
      }
      bottomViewOfTreeUtil(root.right, node.next);
    }
  }

  public void bottomViewOfTree(TreeNode root) {
    bottomViewOfTreeUtil(root, node);
    printList();
  }


  public void printList() {
    if(head != null) {
      DoubleLinkedListNode tempHead = head;
      while(tempHead != null) {
        System.out.println(tempHead.data);
        tempHead = tempHead.next;
      }
    }
  }

  public static void main(String args[]) {
    BottomViewOfTree test = new BottomViewOfTree();
    test.bottomViewOfTree(SampleBinarySearchTrees.sample_2());
  }
}
