package com.data_structure.algo.ds.tree;

public class _2_DFSTraversalWithRecurssion {
  public static void main(String[] args) {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    System.out.println("Pre order traversal ");
    preOrderTraversal(tree);
    System.out.println("\n In order traversal ");
    inOrderTraversal(tree);
    System.out.println("\n Post order traversal ");
    postOrderTraversal(tree);
  }

  private static void postOrderTraversal(Node tree) {
    if(tree == null){
      return;
    }
    postOrderTraversal(tree.left);
    postOrderTraversal(tree.right);
    System.out.print(tree.val+" ");
  }

  private static void inOrderTraversal(Node tree) {
    if (tree == null) {
      return;
    }
    inOrderTraversal(tree.left);
    System.out.print(tree.val+" ");
    inOrderTraversal(tree.right);
  }

  private static void preOrderTraversal(Node tree) {
    if (tree == null) {
      return;
    }
    System.out.print(tree.val+" ");
    preOrderTraversal(tree.left);
    preOrderTraversal(tree.right);
  }
}
