package com.data_structure.algo.ds.tree;

public class _4_GetEvenAndOddLevelDifference {
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
    System.out.println("Sum of all nodes = " + getDifference(tree));

  }

  private static int getDifference(Node tree) {
    if(tree == null)return 0;
    return tree.val - getDifference(tree.left) - getDifference(tree.right);
  }
}
