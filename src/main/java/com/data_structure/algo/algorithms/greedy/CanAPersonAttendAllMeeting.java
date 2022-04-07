package com.data_structure.algo.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
* Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.
*/
public class CanAPersonAttendAllMeeting {
  public static void main(String[] args) {
    Interval[] interval = new Interval[] {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
    System.out.println(canAttendMeetings(interval));
  }

  private static boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i].end > intervals[i + 1].start) {
        return false;
      }
    }

    return true;
  }

  static class Interval {
    int start;
    int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
