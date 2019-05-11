package com.practice;

import com.practice.datastructures.TreeNode;
import com.practice.datastructures.SampleBinarySearchTrees;
import com.practice.datastructures.SampleBinaryTrees;

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

  private BSTCheckData isBSTBottomUpUtil(TreeNode root) {
    if(root == null)
      return BSTCheckData.getNullObject();

    BSTCheckData leftBSTCheckData = isBSTBottomUpUtil(root.left);
    if(!leftBSTCheckData.isBST)
      return BSTCheckData.getFalseObject();

    BSTCheckData rightBSTCheckData = isBSTBottomUpUtil(root.right);
    if(!rightBSTCheckData.isBST)
      return BSTCheckData.getFalseObject();

    BSTCheckData resultBSTCheckData = new BSTCheckData(root);
    if(BSTCheckDataUtil.isCombinedBST(root, leftBSTCheckData, rightBSTCheckData)) {
      resultBSTCheckData.isBST = true;
      resultBSTCheckData.smallest = leftBSTCheckData.getSmallest();
      resultBSTCheckData.largest = rightBSTCheckData.getLargest();
      return resultBSTCheckData;
    }
    return  BSTCheckData.getFalseObject();
  }

  public boolean isBSTBottomUp(TreeNode root) {
    if(root == null)
      return true;
    BSTCheckData result = isBSTBottomUpUtil(root);
    return result.isBST;
  }

  public static void main(String args[]) {
    BinarySearchTreeCheck test = new BinarySearchTreeCheck();
    System.out.println(test.isBSTBottomUp(SampleBinaryTrees.sample_2()));
    System.out.println(test.isBSTBottomUp(SampleBinarySearchTrees.sample_1()));
  }
}

class BSTCheckDataUtil {

  public static boolean isCombinedBST(TreeNode root, BSTCheckData left, BSTCheckData right) {
    if(!left.isBST || !right.isBST) {
      return false;
    }
    if(left.getLargest() != null && root.data < left.getLargest().data) {
      return false;
    }

    if(right.getSmallest() != null && root.data > right.getSmallest().data) {
      return false;
    }

    return true;
  }
}

class BSTCheckData {
  public TreeNode root;
  public TreeNode smallest;
  public TreeNode largest;
  public boolean isBST = false;

  private static BSTCheckData nullObject = new BSTCheckData();
  private static BSTCheckData falseObject = BSTCheckDataFalse();

  public TreeNode getSmallest() {
    return smallest == null ? root : smallest;
  }

  public TreeNode getLargest() {
    return largest == null ? root : largest;
  }

  private BSTCheckData() {
    root = null;
    smallest = null;
    largest = null;
    isBST = true;
  }

  private static BSTCheckData BSTCheckDataFalse() {
    BSTCheckData falseObject = new BSTCheckData();
    falseObject.isBST = false;
    return falseObject;
  }

  public static BSTCheckData getFalseObject() {
    return falseObject;
  }

  public static BSTCheckData getNullObject() {
    return nullObject;
  }

  public BSTCheckData(TreeNode root) {
    this.root = root;
    smallest = null;
    largest = null;
    isBST = true;
  }
}