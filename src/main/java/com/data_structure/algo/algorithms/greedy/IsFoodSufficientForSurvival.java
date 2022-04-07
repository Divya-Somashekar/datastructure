package com.data_structure.algo.algorithms.greedy;

public class IsFoodSufficientForSurvival {
  /*You are a poor person in an island. There is only one shop in this island, this shop is open on all days of the week except for Sunday. Consider following constraints:

N:Maximum unit of food you can buy each day.
S:Number of days you are required to survive.
M:Unit of food required each day to survive.
Currently, it's Monday, and you need to survive for the next S days.
Find the minimum number of days on which you need to buy food from the shop so that you can survive the next S days, or determine that it isn't possible to survive.

Input : S = 10 N = 16 M = 2
Output : Yes 2
Input : 10 20 30
Output : No */
  public static void main(String[] args) {
    int maxFoodYouCanBuyInOneDay = 16;//S
    int noOfDayToSurvive = 10;//N
    int foodForEachDay = 2;//M

    canSurvive(maxFoodYouCanBuyInOneDay, noOfDayToSurvive, foodForEachDay);
  }

  private static void canSurvive(int maxFoodYouCanBuyInOneDay, int noOfDayToSurvive, int foodForEachDay) {
    if (((maxFoodYouCanBuyInOneDay * 6) < (foodForEachDay * 7) && noOfDayToSurvive > 6) || foodForEachDay > maxFoodYouCanBuyInOneDay)
      System.out.println("No");

    else {

      // If we can survive then we can
      // buy ceil(A/N) times where A is
      // total units of food required.
      int days = (foodForEachDay * noOfDayToSurvive) / maxFoodYouCanBuyInOneDay;

      if (((foodForEachDay * noOfDayToSurvive) % maxFoodYouCanBuyInOneDay) != 0)
        days++;

      System.out.println("Yes " + days);
    }
  }
  //Time Complexity: O(1)
  //Space Complexity: O(1)
}
