package com.practice;

import com.practice.DataStructures.TreeNode;
import com.practice.DataStructures.SampleBinarySearchTrees;

/**
 * Created by jaiprakash on 4/12/18
 */
public class AddAllGreaterValuesToEveryNodeInBST {
  private Integer addValue = 0;
  public void modifyBSTUtil(TreeNode root) {
    if(root == null) {
      return;
    }

    if(root.right != null) {
      modifyBSTUtil(root.right);
    }

    root.data += addValue;
    addValue = root.data;

    if(root.left != null) {
      modifyBSTUtil(root.left);
    }
  }

  public void printPostOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    printPostOrder(root.right);
    System.out.println(root.data);
    printPostOrder(root.left);
  }
  // This class initialises the value of sum to 0
  public class Sum {
    int sum = 0;
  }

  // Recursive function to add all greater values in
  // every treeNode
  private void modifyBSTUtil(TreeNode treeNode, Sum S)
  {
    // Base Case
    if (treeNode == null)
      return;

    // Recur for right subtree
    this.modifyBSTUtil(treeNode.right, S);

    // Now *sum has sum of nodes in right subtree, add
    // root->data to sum and update root->data
    S.sum = S.sum + treeNode.data;
    treeNode.data = S.sum;

    // Recur for left subtree
    this.modifyBSTUtil(treeNode.left, S);
  }

  // A wrapper over modifyBSTUtil()
  private void modifyBST(TreeNode treeNode)
  {
    Sum S = new Sum();
    this.modifyBSTUtil(treeNode, S);
  }

  public static void main(String args[]) {
    AddAllGreaterValuesToEveryNodeInBST test = new AddAllGreaterValuesToEveryNodeInBST();
    TreeNode tempTree = SampleBinarySearchTrees.sample_1();
    test.modifyBST(tempTree);
    test.printPostOrder(tempTree);
  }
}
