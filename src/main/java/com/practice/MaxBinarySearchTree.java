package com.practice;

import com.practice.datastructures.SampleBinarySearchTrees;
import com.practice.datastructures.SampleBinaryTrees;
import com.practice.datastructures.TreeNode;

public class MaxBinarySearchTree {
  MaxBSTData getMaxBSTUtil(TreeNode root) {
    if(root == null) {
      return MaxBSTData.getNullBSTData();
    }

    MaxBSTData leftBSTData = getMaxBSTUtil(root.left);
    MaxBSTData rightBSTData = getMaxBSTUtil(root.right);

    MaxBSTData resultBstData = new MaxBSTData(root, leftBSTData, rightBSTData);
    if(BSTCheckDataUtil.isCombinedBST(root, leftBSTData.bstCheckData, rightBSTData.bstCheckData)) {
      resultBstData.curBSTSize = 1 + leftBSTData.curBSTSize + rightBSTData.curBSTSize;
      resultBstData.maximumBSTSize = resultBstData.curBSTSize;
      return resultBstData;
    }
    resultBstData.bstCheckData.isBST = false;
    resultBstData.maximumBSTSize = Math.max(leftBSTData.maximumBSTSize,
        Math.max(rightBSTData.maximumBSTSize, resultBstData.maximumBSTSize));
    return resultBstData;
  }

  int getMaxBST(TreeNode root) {
    if(root == null)
      return 0;

    MaxBSTData maxBSTData = getMaxBSTUtil(root);
    return maxBSTData.maximumBSTSize;
  }


  public static void main(String args[]) {
    MaxBinarySearchTree test = new MaxBinarySearchTree();
    System.out.println(test.getMaxBST(SampleBinaryTrees.sample_4()));
    System.out.println(test.getMaxBST(SampleBinarySearchTrees.sample_1()));
  }
}

class MaxBSTData {
  BSTCheckData bstCheckData;
  int maximumBSTSize = 1;
  int curBSTSize = 1;
  private static MaxBSTData nullBSTData = new MaxBSTData();

  private MaxBSTData() {
    bstCheckData = BSTCheckData.getNullObject();
    maximumBSTSize = 0;
    curBSTSize = 0;
  }

  public static MaxBSTData getNullBSTData() {
    return nullBSTData;
  }

  public MaxBSTData(TreeNode root, MaxBSTData left, MaxBSTData right) {
    bstCheckData = new BSTCheckData(root);
    bstCheckData.smallest = left.bstCheckData.getSmallest();
    bstCheckData.largest = right.bstCheckData.getLargest();
    maximumBSTSize = 0;
    curBSTSize = 1 + left.curBSTSize + right.curBSTSize;
  }
}