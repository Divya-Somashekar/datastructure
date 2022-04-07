package com.data_structure.algo.ds.tree.traversal;

import com.data_structure.algo.ds.tree.Node;
import java.util.Stack;

public class InOrderWithoutRecurssion {
  public static void main(String[] args) {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.left = new Node(6);
    tree.right.right = new Node(7);
    tree.left.left.left = new Node(8);
    tree.left.right.left = new Node(9);
    tree.left.right.right = new Node(10);
    tree.right.left.right = new Node(11);
    System.out.print("In Order Traversal = ");
    inOrderTraversal(tree);
  }

  private static void inOrderTraversal(Node tree) {
    if (tree == null) return;
    Stack<Node> stack = new Stack<>();
    Node curr = tree;
    while (curr!=null || !stack.isEmpty()){
      while (curr!=null){
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      System.out.print(curr.val+" ");
      curr = curr.right;
    }
  }
}
