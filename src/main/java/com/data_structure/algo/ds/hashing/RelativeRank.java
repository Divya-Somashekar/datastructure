package com.data_structure.algo.ds.hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeRank {
  /*
  Input: score = [5,4,3,2,1]
  Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
  Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
  */
  public static void main(String[] args) {
    int[] input = {10, 3, 8, 9, 4};
    for (String rank : getRanks(input)) {
      System.out.println(rank);
    }

  }

  /*private static String[] getRanks(int[] score) {
    int n = score.length;
    String[] result = new String[n];

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> score[b] - score[a]);

    for (int i = 0; i < n; i++) {
      pq.add(i);
    }
    int i = 1;
    while (!pq.isEmpty()) {

      int idx = pq.poll();

      if (i > 3) {
        result[idx] = Integer.toString(i);
      } else if (i == 1) {
        result[idx] = "Gold Medal";
      } else if (i == 2) {
        result[idx] = "Silver Medal";
      } else if (i == 3) {
        result[idx] = "Bronze Medal";
      }
      i++;
    }

    return result;
  }*/
  private static String[] getRanks(int[] input) {
    String[] ans = new String[input.length];
    
    for (int i = 0; i < input.length; i++) {
      int index = input[i];
      int rankOfI = input[index - 1];
      if (getRankMap().get(rankOfI) == null) {
        ans[i] = String.valueOf(rankOfI);
      } else {
        ans[i] = getRankMap().get(rankOfI);
      }
    }
    return ans;
  }

  private static Map<Integer, String> getRankMap() {
    Map<Integer, String> mapOfRankAndDes = new HashMap<>();

    mapOfRankAndDes.put(1, "Gold Medal");
    mapOfRankAndDes.put(2, "Silver Medal");
    mapOfRankAndDes.put(3, "Bronze Medal");
    return mapOfRankAndDes;
  }


}

class MyComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
    if (o1 < o2) {
      return -1;
    } else if (o1 > o2) {
      return 1;
    } else {
      return 0;
    }
  }
}
