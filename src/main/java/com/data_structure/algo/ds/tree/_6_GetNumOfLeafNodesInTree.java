package com.data_structure.algo.ds.tree;

public class _6_GetNumOfLeafNodesInTree {
  public static void main(String[] args) {
    Node tree = new Node(2);
    tree.left = new Node(7);
    tree.right = new Node(5);
    tree.left.left = new Node(2);
    tree.left.right = new Node(6);
    tree.right.right = new Node(9);
    tree.left.right.left = new Node(5);
    tree.left.right.right = new Node(11);
    tree.left.left.right = new Node(4);
    System.out.println("Sum of all nodes = " + getNoOfLeafNodesInTree(tree));
  }

  private static int getNoOfLeafNodesInTree(Node tree) {
    if(tree == null)return 0;
    if(tree.left == null && tree.right == null){
      return 1;
    }
    return getNoOfLeafNodesInTree(tree.left) + getNoOfLeafNodesInTree(tree.right);
  }

  /*private static int count = 0;
  private static int getNoOfLeafNodesInTree(Node tree) {
    if(tree == null)return 0;
    if(tree.left == null && tree.right == null){
      count++;
    }
    getNoOfLeafNodesInTree(tree.left);
    getNoOfLeafNodesInTree(tree.right);
    return count;
  }*/

}
