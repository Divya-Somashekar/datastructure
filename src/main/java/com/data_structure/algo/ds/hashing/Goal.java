package com.data_structure.algo.ds.hashing;

/*
public class Goal {
  public static void main(String[] args) {
    SinglyLinkedListNode list1 =
        new SinglyLinkedListNode(9, "A", new SinglyLinkedListNode(7, "B", new SinglyLinkedListNode(5, "c", null)));
    //System.out.println(listByPerformance());
  }
*/
/*
Don,9
Birbal,7
Akbar,5
Amit,4
Raaj,1
4
Smriti,8
Pooja,6
Mithali,3
Shefali,2
*//*

  public static SinglyLinkedListNode listByPerformance(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
    PriorityQueue<SinglyLinkedListNode> players = new PriorityQueue<>(Comparator.comparingInt(a -> a.goalCount));
    players.add(list1);
    players.add(list2);
    SinglyLinkedListNode currPlayer;
    SinglyLinkedListNode output = null;
    while (!players.isEmpty()) {
      currPlayer = players.remove();
      output = new SinglyLinkedListNode(currPlayer.goalCount, currPlayer.name);
      output.next = currPlayer.next;
    }
    return output;
  }

  private static Map<String, List<String>> fillMap(List<String> arr, Map<String, List<String>> map) {
    for (String nameAndMovie : arr) {
      String[] moveAndNameSplit = nameAndMovie.split(":");
      if (map.get(moveAndNameSplit[1]) != null) {
        List<String> name = map.get(moveAndNameSplit[1]);
        name.add(moveAndNameSplit[0]);
        map.put(moveAndNameSplit[1], name);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(moveAndNameSplit[0]);
        map.put(moveAndNameSplit[1], list);
      }
    }
    return map;
  }

  static class SinglyLinkedListNode {
    int goalCount;
    String name;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int goalCount, String name) {
      this.goalCount = goalCount;
      this.name = name;
    }
  }
}
*/
