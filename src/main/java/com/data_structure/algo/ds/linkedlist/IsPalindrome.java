package com.data_structure.algo.ds.linkedlist;
/*
BruteForce approach: using stack
iterate all and fill in stack
again iterate list and pop stack and if all are equal return true otherwise return false
time n and space n size of list

without using stack
create new linked list and store the reverse linked list and compare

3 pointer - take care of odd and even
Instead of reversing entire linked list find middle and reverse first half and compare mid -1 and mid +1
* */
public class IsPalindrome {
  public static void main(String[] args) {
    ListNode list = new ListNode(2);
    list.next = new ListNode(2);
    list.next.next = new ListNode(2);
    list.next.next.next = new ListNode(5);
    list.next.next.next.next = new ListNode(6);
    list.next.next.next.next.next = new ListNode(5);

    ListNode lis = null;
    int[] arr = new int[]{1, 6, 1};
    for (Integer a: arr){
      if(lis == null) {
        lis = new ListNode(a);
      } else {
        lis.next = new ListNode(a);
      }
    }
    System.out.println(isPalindrome(list));
  }
  public static int isPalindrome(ListNode head) {
    if(head == null || head.next == null) {
      return 1;
    }

    // find middle of the given linked list && p1 will point to middle node
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }

    // reversing first half
    ListNode tmp = null;
    ListNode prev = null;
    ListNode curr = head;
    while (curr != p1) {
      tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

    // odd number of elements, need left move p1 one step
    if (p2 != null && p2.next == null) p1 = p1.next;

    while(p1 != null) {
      if (p1.val != prev.val) return 0;
      p1 = p1.next;
      prev = prev.next;
    }
    return 1;
  }

}
