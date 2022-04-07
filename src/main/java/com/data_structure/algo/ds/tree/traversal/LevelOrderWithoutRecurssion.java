package com.data_structure.algo.ds.tree.traversal;

import com.data_structure.algo.ds.tree.Node;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderWithoutRecurssion {
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
    System.out.print("Level Order Traversal = ");
    LevelOrderTraversal(tree);
  }

  private static void LevelOrderTraversal(Node tree) {
    if(tree == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(tree);
    while (!queue.isEmpty()){
      Node curr = queue.remove();
      System.out.println(curr);
      if(curr.right!=null){
        queue.add(curr.right);
      }
      if(curr.left!=null){
        queue.add(curr.left);
      }
    }
  }


}
