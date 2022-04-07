package com.data_structure.algo.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {
  /*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example, Given [[0, 30],[15, 20],[5, 10]] return 2.
[[0, 30],[5, 10], [6,16], [15, 20]], return 3.
*/
  public static void main(String[] args) {
    List<Integer> startMeeting = new ArrayList<>();
    List<Integer> endMeeting = new ArrayList<>();
    startMeeting.add(1);
    startMeeting.add(3);
    startMeeting.add(0);
    startMeeting.add(5);
    startMeeting.add(8);
    startMeeting.add(5);
    endMeeting.add(2);
    endMeeting.add(4);
    endMeeting.add(6);
    endMeeting.add(7);
    endMeeting.add(9);
    endMeeting.add(9);
    System.out.println("The max meeting rooms needed - "+getMaxMeetingRoomCount(startMeeting, endMeeting));

    System.out.println("-------------------------------------------------------------------");

    System.out.println("-------------------------------------------------------------------");
    int[] start = {1, 3, 0, 5, 8, 5};
    int[] finish = {2, 4, 6, 7, 9, 9};
    List<Meeting> meetings = new ArrayList<>();
    for (int i = 0; i < start.length; i++) {
      meetings.add(new Meeting(start[i], finish[i], i));
    }

    List<Integer> meeting = getConductedMeetingList(meetings);
    System.out.println("The index of meeting conducted : ");
    for (Integer integer : meeting) {
      System.out.print(integer + 1 + " ");
    }
    //Time Complexity: O(N log(N))
    //
    //Auxiliary Space: O(2*N) for creating a vector of pairs that is approximately equal to O(n)
    //
  }

  public static List<Integer> getConductedMeetingList(List<Meeting> meetingList) {
    ArrayList<Integer> output = new ArrayList<>();

    int maxEndTime;
    meetingList.sort(Comparator.comparingInt(x -> x.end));

    output.add(meetingList.get(0).pos);
    maxEndTime = meetingList.get(0).end;

    for (int i = 1; i < meetingList.size(); i++) {
      if (meetingList.get(i).start > maxEndTime) {
        output.add(meetingList.get(i).pos);
        maxEndTime = meetingList.get(i).end;
      }
    }
    return output;
  }

  static int getMaxMeetingRoomCount(List<Integer> start, List<Integer> timeTaken) {
    List<CanAPersonAttendAllMeeting.Interval> intervalList = new ArrayList<>();
    for (int i = 0; i < start.size(); i++) {
      intervalList.add(new CanAPersonAttendAllMeeting.Interval(start.get(i), start.get(i) + timeTaken.get(i)));
    }
    intervalList.sort(Comparator.comparingInt(i -> i.end));

    int res = 0;
    int prevEnd = Integer.MIN_VALUE; // finish time of the previous meeting

    for (CanAPersonAttendAllMeeting.Interval interval : intervalList) {
      if (interval.start >= prevEnd) { // is there a conflict with the previous meeting?
        res++;
        prevEnd = interval.end; // update the previous finish time
      }
    }
    return res;
  }

  public static int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    for (int[] itv : intervals) {
      if (heap.isEmpty()) {
        count++;
        heap.offer(itv[1]);
      } else {
        if (itv[0] >= heap.peek()) {
          heap.poll();
        } else {
          count++;
        }

        heap.offer(itv[1]);
      }
    }

    return count;
  }

  static class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
      this.start = start;
      this.end = end;
      this.pos = pos;
    }
  }
}
