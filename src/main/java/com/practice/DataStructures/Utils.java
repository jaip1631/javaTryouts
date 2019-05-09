package com.practice.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaiprakash on 10/1/19
 */
public class Utils {
  public static void printMatrix(int arr[][], int row, int col) {
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }
  }

  public static void printInorder(TreeNode treeNode) {
    if(treeNode == null)
      return;

    printInorder(treeNode.left);
    System.out.println(treeNode.data);
    printInorder(treeNode.right);
  }


  public static void printPreOrder(TreeNode treeNode) {
    if(treeNode == null)
      return;

    System.out.println(treeNode.data);
    printPreOrder(treeNode.left);
    printPreOrder(treeNode.right);
  }

  public static int getMin(int a, int b) {
    return a<b?a:b;
  }

  public static int getSizeLinkedList(LinkedListNode head) {
    int size = 0;

    while(head != null) {
      size++;
      head = head.next;
    }

    return size;
  }

  public static TreeNode constructBalancedTreeOfSize(int n) {
    if(n == 0)
      return null;

    TreeNode balancedTreeHead = new TreeNode();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(balancedTreeHead);

    n--;
    while(n != 0) {
      TreeNode first = queue.poll();
      first.left = new TreeNode();
      queue.add(first.left);

      n--;
      if(n != 0) {
        first.right = new TreeNode();
        queue.add(first.right);
        n--;
      }
    }

    return balancedTreeHead;
  }
}
