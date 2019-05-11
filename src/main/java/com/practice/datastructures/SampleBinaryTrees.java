package com.practice.datastructures;

/**
 * Created by jaiprakash on 30/11/18
 */
public class SampleBinaryTrees {
  /*
   *           10
   *       20      30
   *     40  50
   * */
  public static TreeNode sample_1() {
    TreeNode root = new TreeNode(10);

    TreeNode left = new TreeNode(20);
    TreeNode right = new TreeNode(30);
    root.left = left;
    root.right = right;

    left = new TreeNode(40);
    right = new TreeNode(50);
    root.left.left = left;
    root.left.right = right;

    return root;
  }

  /*
   *           30
   *       20      40
   *     10  50
   * */
  public static TreeNode sample_2() {
    TreeNode root = new TreeNode(30);

    TreeNode left = new TreeNode(20);
    TreeNode right = new TreeNode(40);
    root.left = left;
    root.right = right;

    left = new TreeNode(10);
    right = new TreeNode(50);
    root.left.left = left;
    root.left.right = right;

    return root;
  }

  /*
   *           0
   *       1       2
   *          3         4
   *                        5
   * */
  public static TreeNode sample_3() {
    TreeNode root = new TreeNode(0);

    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(2);
    root.left = left;
    root.right = right;

    right = new TreeNode(3);
    root.left.right = right;

    right = new TreeNode(4);
    root.right.right = right;

    right = new TreeNode(5);
    root.right.right.right = right;

    return root;
  }


  /*
   *           1
   *               2
   *                  3
   *                      4
   *                    5
   * */
  public static TreeNode sample_4() {
    TreeNode root = new TreeNode(1);

    TreeNode right = new TreeNode(2);
    root.right = right;

    right = new TreeNode(3);
    root.right.right = right;

    right = new TreeNode(4);
    root.right.right.right = right;

    right = new TreeNode(5);
    root.right.right.right.left = right;

    return root;
  }


}
