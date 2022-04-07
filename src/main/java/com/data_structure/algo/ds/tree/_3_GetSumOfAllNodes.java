package com.data_structure.algo.ds.tree;

public class _3_GetSumOfAllNodes {
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
    System.out.println("Sum of all nodes = " + getSum(tree));

  }

  private static int sum = 0;
  private static int getSum(Node tree) {
    if(tree == null) return 0;
    sum = tree.val + getSum(tree.left) + getSum(tree.right);
    return sum;
  }
}
