package com.data_structure.algo.ds.linkedlist;

/*
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
public class AddTwoLinkedList {
  public static void main(String[] args) {
    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(9);

    ListNode list2 = new ListNode(5);
    list2.next = new ListNode(6);
    list2.next.next = new ListNode(4);
    list2.next.next.next = new ListNode(9);

    ListNode sumList = getSumList(list1, list2);
    while (sumList!=null){
      System.out.print(sumList.val+" ");
      sumList = sumList.next;
    }
  }

 /* private static ListNode getSumList(ListNode list1, ListNode list2) {
    Stack<ListNode> stack1 = new Stack<>();
    Stack<ListNode> stack2 = new Stack<>();
    while (list1!=null){
      stack1.push(list1);
      list1 = list1.next;
    }
    while (list2!=null){
      stack2.push(list2);
      list2 = list2.next;
    }
    int carry = 0;
    ListNode head = null;
    while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
      int n1 = stack1.isEmpty() ? 0 : stack1.pop().val;
      int n2 = stack2.isEmpty() ? 0 : stack2.pop().val;

      int tmp = n1 + n2 + carry;
      ListNode newNode = new ListNode(tmp % 10);
      newNode.next = head;
      head = newNode;
      carry = tmp /10;
    }
    return head;
  }*/

  public static ListNode getSumList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode temp = dummy;
    int carry = 0;
    while( l1 != null || l2 != null || carry != 0){
      int sum = 0;
      if(l1 != null){
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2 != null){
        sum += l2.val;
        l2 = l2.next;
      }
      sum += carry;

      carry = sum / 10;
      sum = sum % 10;

      ListNode node = new ListNode(sum);
      temp.next = node;
      temp = temp.next;

    }
    return dummy.next;
  }
}
