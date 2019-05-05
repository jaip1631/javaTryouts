package com.practice;

import com.practice.DataStructures.TreeNode;
import com.practice.DataStructures.SampleBinaryTrees;

/**
 * Created by jaiprakash on 30/11/18
 */

public class PrintSuccessiveLeafNodes {
  private TreeNode printSuccessiveLeafNodesUnOptimisedUtil(TreeNode root) {
    if(root != null) {
      if(root.left == null && root.right == null) {
        System.out.print(root.data);
        return null;
      }

      root.left = printSuccessiveLeafNodesUnOptimisedUtil(root.left);
      root.right = printSuccessiveLeafNodesUnOptimisedUtil(root.right);
      return root;
    }
    else {
      return null;
    }
  }

  public void printSuccessiveLeafNodesUnOptimised(TreeNode root) {
    if(root != null) {
      while(root.left != null || root.right != null) {
        printSuccessiveLeafNodesUnOptimisedUtil(root);
        System.out.println();
      }
      System.out.print(root.data);
    }
  }

  public static void main(String args[]) {
    PrintSuccessiveLeafNodes test = new PrintSuccessiveLeafNodes();
    test.printSuccessiveLeafNodesUnOptimised(SampleBinaryTrees.sample_1());
  }
}
