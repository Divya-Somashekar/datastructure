package com.data_structure.algo.ds.tree;

import static java.lang.Math.max;

public class _7_GetTheHeightOfTree {
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
    System.out.println("Max height of tree = " + getHeightOfTree(tree));
  }

  static int getHeightOfTree(Node tree) {
    if (tree == null) {
      return -1;//note this is -1
    }
    return 1 + max(getHeightOfTree(tree.left), getHeightOfTree(tree.right));

  }
}
