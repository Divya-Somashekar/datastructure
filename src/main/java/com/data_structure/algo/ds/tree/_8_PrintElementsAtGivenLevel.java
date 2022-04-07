package com.data_structure.algo.ds.tree;

public class _8_PrintElementsAtGivenLevel {
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
    getElementsAtGivenLevel(tree, 3);

  }

  static void getElementsAtGivenLevel(Node tree, int level) {
    if (tree == null) {
      return;
    }
    if (level == 1) {
      System.out.print(tree.val + " ");
      return;
    }
    getElementsAtGivenLevel(tree.left, level - 1);
    getElementsAtGivenLevel(tree.right, level - 1);
  }
}
