package com.data_structure.algo.ds.tree.traversal;

import com.data_structure.algo.ds.tree.Node;
import java.util.Stack;

public class PreOrderTraversalWithoutRecurssion {
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
    System.out.print("Pre Order Traversal = ");
    preOrderTraversal(tree);
  }

  private static void preOrderTraversal(Node tree) {
    if(tree == null) return;
    Stack<Node> stack = new Stack<>();
    Node curr = tree;
    while (!stack.isEmpty() || curr!=null){
      while (curr!=null) {
        System.out.print(curr.val+" ");
        if(curr.right!=null){
          stack.push(curr.right);
        }
        curr = curr.left;
      }
      if(!stack.isEmpty()){
        curr = stack.pop();
      }
    }
  }
}
