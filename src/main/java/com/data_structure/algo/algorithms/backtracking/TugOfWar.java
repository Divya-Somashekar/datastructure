package com.data_structure.algo.algorithms.backtracking;

public class TugOfWar {
  private static int minDiff = Integer.MAX_VALUE;
  public static void main(String[] args) {
    int[] players = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
    boolean[] teams = getTeams(players);

    System.out.print("The first subset is: ");
    for (int i = 0; i < players.length; i++) {
      if (teams[i]) {
        System.out.print(players[i] + " ");
      }
    }
    System.out.print("\nThe second subset is: ");
    for (int i = 0; i < players.length; i++) {
      if (!teams[i]) {
        System.out.print(players[i] + " ");
      }
    }
  }

  private static boolean[] getTeams(int[] input) {
    int noOfPlayers = input.length;
    boolean[] currPlayer = new boolean[noOfPlayers];
    boolean[] output = new boolean[noOfPlayers];
    int sum = 0;

    for (int i = 0; i < noOfPlayers; i++) {
      sum += input[i];
      currPlayer[i] = output[i] = false;
    }

    twoTeams(input, noOfPlayers, currPlayer, 0,
        output, sum, 0, 0);
    return output;
  }

  private static void twoTeams(int[] players, int noOfPlayers, boolean[] currPlayer, int noOfSelectedPlayers,
                               boolean[] soln, int sum, int currSum, int currPosition) {
    if (currPosition == noOfPlayers) {
      return;
    }

    if ((noOfPlayers / 2 - noOfSelectedPlayers) >
        (noOfPlayers - currPosition)) {
      return;
    }

    twoTeams(players, noOfPlayers, currPlayer,
        noOfSelectedPlayers, soln, sum,
        currSum, currPosition + 1);

    noOfSelectedPlayers++;
    currSum = currSum + players[currPosition];
    currPlayer[currPosition] = true;

    if (noOfSelectedPlayers == noOfPlayers / 2) {
      if (Math.abs(sum / 2 - currSum) < minDiff) {
        minDiff = Math.abs(sum / 2 - currSum);
        for (int i = 0; i < noOfPlayers; i++) {
          soln[i] = currPlayer[i];
        }
      }
    } else {
      twoTeams(players, noOfPlayers, currPlayer,
          noOfSelectedPlayers,
          soln, sum, currSum,
          currPosition + 1);
    }

    currPlayer[currPosition] = false;
  }
}
