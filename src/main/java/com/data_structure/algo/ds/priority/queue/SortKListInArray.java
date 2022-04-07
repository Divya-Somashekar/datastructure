package com.data_structure.algo.ds.priority.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SortKListInArray {
  public static void main(String[] args) {
    //Input: lists = [[1,4,5],[1,3,4],[2,6]]
    //Output: [1,1,2,3,4,4,5,6]
    Node list1 = new Node(1);
    list1.next = new Node(4);
    list1.next.next = new Node(5);
    Node list2 = new Node(1);
    list2.next = new Node(3);
    list2.next.next = new Node(4);
    Node list3 = new Node(2);
    list3.next = new Node(6);

    List<Node> list = new ArrayList<>();
    list.add(list1);
    list.add(list2);
    list.add(list3);
    PriorityQueue<Object> sortedList = getSortedList(list);

    while (!sortedList.isEmpty()) {
      System.out.print(sortedList.remove() + " ");
    }
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(4);
    listNode1.next.next = new ListNode(5);

    ListNode listNode2 = new ListNode(1);
    listNode2.next = new ListNode(3);
    listNode2.next.next = new ListNode(4);
    ListNode[] listArr = {listNode1, listNode2};

    mergeKLists(listArr);
  }

  private static PriorityQueue<Object> getSortedList(List<Node> listOfList) {
    Iterator<Node> iterator = listOfList.iterator();
    PriorityQueue<Object> queue = new PriorityQueue<>();
    while (iterator.hasNext()) {//k
      Node list = iterator.next();
      while (list != null) {//n
        queue.add(list.data);
        list = list.next;
      }
    }
    ArrayList<Object> list = new ArrayList<>(queue);
    return queue;
  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public static ListNode mergeKLists(ListNode[] listNodeArray) {
    Iterator<ListNode> iterator = Arrays.stream(listNodeArray).collect(Collectors.toList()).iterator();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    while (iterator.hasNext()) {//k
      ListNode list = iterator.next();
      while (list != null) {//n
        queue.add(list.val);
        list = list.next;
      }
    }
    ListNode ans = new ListNode();
    ListNode pointer = ans;
    while(!queue.isEmpty()){
      ListNode curr = new ListNode(queue.remove());
      pointer.next = curr;
      pointer = pointer.next;
    }
    return ans.next;
  }
}
