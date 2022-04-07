package com.data_structure.algo.ds.linkedlist;

public class MergeTwoSortedList {
  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(3);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(2);
    list2.next.next = new ListNode(4);

    ListNode mergedList = mergeTwoLists(list1, list2);
    while (mergedList!=null){
      System.out.print(mergedList.val+" ");
      mergedList = mergedList.next;
    }
  }
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode temp = dummy;

    if(list1 == null) return list2;
    if(list2 == null) return list1;

    while(list1 != null && list2 != null){
      if(list1.val < list2.val){
        temp.next = list1;
        list1 = list1.next;
      }else{
        temp.next = list2;
        list2 = list2.next;
      }
      temp = temp.next;
    }

    while(list1 != null){
      temp.next = list1;
      list1 = list1.next;
      temp = temp.next;
    }

    while(list2 != null){
      temp.next = list2;
      list2 = list2.next;
      temp = temp.next;
    }

    return dummy.next;
  }
}
