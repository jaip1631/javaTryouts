package com.practice;

/*
Tags: ArrayTag, TreeTag
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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

public class TreeFromInorderPreorder {

  public static void main(String args[]) {
    TreeFromInorderPreorder test = new TreeFromInorderPreorder();
    Utils.printInorder(
        test.buildTree_0(
            new int[]{3,9,20,15,7},
            new int[]{9,3,15,20,7}
            )
    );
  }


  /*
  Runtime: 3 ms
  Memory Usage: 39.3 MB
  https://leetcode.com/submissions/detail/228374280/
  Note: Optimised using Map to find index in inorder array (O)1.
        Remove MyInteger class and calculate preIndex increment
        based on inIndex
  */
  public TreeNode buildTree_0(int[] preorder, int[] inorder) {
    initMap(inorder);
    return buildTree_0(preorder, 0, inorder, 0, inorder.length-1);
  }

  private TreeNode buildTree_0(int preorder[], int preIndex,
      int inorder[], int inLeft, int inRight) {
    if(inRight < inLeft || preIndex >= preorder.length) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preIndex]);

    int inIndex = indexOfTreeNode.get(preorder[preIndex]);

    root.left = buildTree_0(preorder, preIndex+1, inorder, inLeft, inIndex-1);
    root.right = buildTree_0(preorder, preIndex+1+inIndex-inLeft, inorder, inIndex+1, inRight);

    return root;
  }
  Map<Integer, Integer> indexOfTreeNode;

  private void initMap(int inorder[]) {
    indexOfTreeNode = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      indexOfTreeNode.put(inorder[i], i);
    }
  }

  /*
  Runtime: 12 ms
  Memory Usage: 41.5 MB
  https://leetcode.com/submissions/detail/228372001/
  Note: Optimised by searching within range in inorder array
  */
  public TreeNode buildTree_1(int[] preorder, int[] inorder) {
    MyInteger preIndex = new MyInteger(0);
    return buildTree_1(preorder, preIndex, inorder, 0, inorder.length-1);
  }

  private TreeNode buildTree_1(int preorder[], MyInteger preIndex,
      int inorder[], int inLeft, int inRight) {
    if(inRight < inLeft || preIndex.val == preorder.length) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preIndex.val]);

    int inIndex = getIndexOf(inorder, inLeft, inRight, preorder[preIndex.val]);

    preIndex.val++;
    root.left = buildTree_1(preorder, preIndex, inorder, inLeft, inIndex-1);
    root.right = buildTree_1(preorder, preIndex, inorder, inIndex+1, inRight);

    return root;
  }

  private int getIndexOf(int inorder[], int left, int right, int val) {
    for(int i = left; i <= right; i++) {
      if(inorder[i] == val) {
        return i;
      }
    }
    return -1;
  }

  /*
  Runtime: 39 ms
  Memory Usage: 45.2 MB
  https://leetcode.com/submissions/detail/228371815/
  Note: Searching on complete inorder array in getIndexOf(). Hence slow
  */
  public TreeNode buildTree_2(int[] preorder, int[] inorder) {
    MyInteger preIndex = new MyInteger(0);
    return buildTree_2(preorder, preIndex, inorder, 0, inorder.length-1);
  }

  private TreeNode buildTree_2(int preorder[], MyInteger preIndex,
      int inorder[], int inLeft, int inRight) {
    if(inRight < inLeft || preIndex.val == preorder.length) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preIndex.val]);

    int inIndex = getIndexOf(inorder, preorder[preIndex.val]);

    preIndex.val++;
    root.left = buildTree_2(preorder, preIndex, inorder, inLeft, inIndex-1);
    root.right = buildTree_2(preorder, preIndex, inorder, inIndex+1, inRight);

    return root;
  }

  private int getIndexOf(int inorder[], int val) {
    for(int i = 0; i < inorder.length; i++) {
      if(inorder[i] == val) {
        return i;
      }
    }
    return -1;
  }

  class MyInteger {
    public int val;
    public MyInteger(int _val) {
      val = _val;
    }
  }
}
