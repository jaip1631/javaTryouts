package com.practice;

/*
Tags: ArrayTag, TreeTag
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*/

import com.practice.datastructures.TreeNode;
import com.practice.datastructures.Utils;
import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderPostorder {

  public static void main(String args[]) {
    TreeFromInorderPostorder test = new TreeFromInorderPostorder();
    Utils.printInorder(
        test.buildTree(
            new int[]{9,3,15,20,7},
            new int[]{9,15,7,20,3}
        )
    );
  }

  /*
  Runtime: 2 ms
  Memory Usage: 42.1 MB
  https://leetcode.com/submissions/detail/228387297/
  */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree_0(postorder, inorder);
  }

  public TreeNode buildTree_0(int[] postorder, int[] inorder) {
    initMap(inorder);
    return buildTree_0(postorder, postorder.length-1, inorder, 0, inorder.length-1);
  }

  private TreeNode buildTree_0(int postorder[], int postIndex,
      int inorder[], int inLeft, int inRight) {
    if(inRight < inLeft || postIndex < 0) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postIndex]);

    int inIndex = indexOfTreeNode.get(postorder[postIndex]);

    root.right = buildTree_0(postorder, postIndex-1, inorder, inIndex+1, inRight);
    root.left = buildTree_0(postorder, postIndex-(1+inRight-inIndex), inorder, inLeft, inIndex-1);

    return root;
  }
  Map<Integer, Integer> indexOfTreeNode;

  private void initMap(int inorder[]) {
    indexOfTreeNode = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      indexOfTreeNode.put(inorder[i], i);
    }
  }
}
