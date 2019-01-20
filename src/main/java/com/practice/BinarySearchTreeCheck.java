package com.practice;

import com.practice.DataStructures.TreeNode;
import com.practice.DataStructures.SampleBinarySearchTrees;
import com.practice.DataStructures.SampleBinaryTrees;

/**
 * Created by jaiprakash on 4/12/18
 */
public class BinarySearchTreeCheck {

  private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
    if(root == null) {
      return true;
    }

    if((min != null && min.data >= root.data)
        || (max != null && max.data <= root.data)) {
      return false;
    }

    return isBST(root.left, min, root)
        && isBST(root.right, root, max);
  }

  public boolean isBST(TreeNode root) {
    return root == null || isBST(root, null, null);
  }

  public static void main(String args[]) {
    BinarySearchTreeCheck test = new BinarySearchTreeCheck();
    System.out.println(test.isBST(SampleBinaryTrees.sample_2()));
    System.out.println(test.isBST(SampleBinarySearchTrees.sample_1()));
  }
}
