package com.practice.DataStructures;

/**
 * Created by jaiprakash on 4/12/18
 */
public class SampleBinarySearchTrees {
  /*
   *           30
   *       20      40
   *     10  25
   * */
  public static TreeNode sample_1() {
    TreeNode root = new TreeNode(30);

    TreeNode left = new TreeNode(20);
    TreeNode right = new TreeNode(40);
    root.left = left;
    root.right = right;

    left = new TreeNode(10);
    right = new TreeNode(25);
    root.left.left = left;
    root.left.right = right;

    return root;
  }

  /*
   *           30
   *       20      40
   *     10  25  35   45
   * */
  public static TreeNode sample_2() {
    TreeNode root = new TreeNode(30);

    TreeNode left = new TreeNode(20);
    TreeNode right = new TreeNode(40);
    root.left = left;
    root.right = right;

    left = new TreeNode(10);
    right = new TreeNode(25);
    root.left.left = left;
    root.left.right = right;

    left = new TreeNode(35);
    right = new TreeNode(45);
    root.right.left = left;
    root.right.right = right;

    return root;
  }
}
