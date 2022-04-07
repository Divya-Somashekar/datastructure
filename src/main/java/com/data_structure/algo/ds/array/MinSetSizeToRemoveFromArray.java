package com.data_structure.algo.ds.array;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinSetSizeToRemoveFromArray {
  public static void main(String[] args) {
    int[] arr = {7, 7, 7, 7, 7, 7};
    System.out.println(minSetSize(arr));
  }

  private static int minSetSize(int[] arr) {

    HashMap<Integer, Integer> mapOfIntegerAndItsFrequency = new HashMap<>();
    for (Integer i : arr) {
      if (mapOfIntegerAndItsFrequency.get(i) == null) {
        mapOfIntegerAndItsFrequency.put(i, 1);
      } else {
        mapOfIntegerAndItsFrequency.put(i, mapOfIntegerAndItsFrequency.get(i) + 1);
      }
    }
    LinkedHashMap<Integer, Integer> sortedMap =
        mapOfIntegerAndItsFrequency.entrySet().stream().sorted(comparingByValue())
            .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    int count = 0;
    int elementsToRemove = 0;
    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
      elementsToRemove += entry.getValue();

      if (arr.length - elementsToRemove <= arr.length / 2) {
        count++;
        break;
      } else {
        count++;
        elementsToRemove += entry.getValue();
      }
    }

    return count;
  }
}
