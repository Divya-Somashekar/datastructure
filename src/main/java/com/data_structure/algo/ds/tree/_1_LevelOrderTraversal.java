package com.data_structure.algo.ds.tree;

public class _1_LevelOrderTraversal {
  public static void main(String[] args) {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    System.out.println("Level order traversal ");
    levelOrderTraversal(tree);
  }

  //With Recursion
  private static void levelOrderTraversal(Node tree) {
    if (tree == null) {
      return;
    }
    int heightOfTree = _7_GetTheHeightOfTree.getHeightOfTree(tree);
    for (int i = 0; i <= heightOfTree; i++) {
      _8_PrintElementsAtGivenLevel.getElementsAtGivenLevel(tree, i+1);
      System.out.println();
    }
  }

  //Without recurssion
  /*private static void levelOrderTraversal(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()){
      Node curr = q.poll();
      System.out.println(curr.val);
      if(curr.left!=null){
        q.add(curr.left);
      }
      if(curr.right!=null){
        q.add(curr.right);
      }
    }
  }*/
}
