package com.practice;

import com.practice.datastructures.TreeNode;
import com.practice.datastructures.Utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jaiprakash on 14/2/19
 */


public class TreeFromInorderPreorder {
  static int index = 0;
  Map<Integer, Integer> indexOfTreeNode;

  public TreeNode buildTreeUtil(List<Integer> A, List<Integer> B,
      int leftIndex, int rightIndex) {
    if(leftIndex > rightIndex)
      return null;

    TreeNode root = new TreeNode(A.get(index));
    index++;
    root.left = buildTreeUtil(A, B, leftIndex, indexOfTreeNode.get(root.data)-1);
    root.right = buildTreeUtil(A, B, indexOfTreeNode.get(root.data)+1, rightIndex);

    return root;
  }

  public TreeNode buildTree(List<Integer> A, List<Integer> B) {
    TreeNode root = null;
    if(A == null)
      return root;

    if(A.isEmpty())
      return root;

    indexOfTreeNode = new HashMap<Integer, Integer>(B.size());
    for(int i = 0; i < B.size(); i++) {
      indexOfTreeNode.put(B.get(i), i);
    }

    return buildTreeUtil(A, B, 0, A.size()-1);
  }

  public static void main(String args[]) {
    TreeFromInorderPreorder test = new TreeFromInorderPreorder();
    TreeNode treeNode = test.buildTree(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 2, 4, 1, 5));

    Utils.printInorder(treeNode);
    Utils.printPreOrder(treeNode);
  }
}
