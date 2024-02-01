package se.artshop.ensosensespringbootapi;

import java.util.Arrays;

public class LeetCode {

  public static void main(String[] args) {

    int[] numbers = {1, 4, 1};

    System.out.println(romanToInt("C"));
  }

  public static int numIdenticalPairs(int[] nums) {
    int goodPairs = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == nums[i]) {
        goodPairs++;
      }

    }
    return goodPairs;
  }

  public static int[] runningSum(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result = nums[i] + nums[i + 1];
      nums = new int[result];
    }
    return nums;
  }

  public static int romanToInt(String s) {
    int I = 1;
    int V = 5;
    int X = 10;
    int L = 50;
    int C = 100;
    int D = 500;
    int M = 1000;

    switch (s) {
      case "I" -> {
        return I;
      }
      case "V" -> {
        return V;
      }
      case "X" -> {
        return X;
      }
      case "L" -> {
        return L;
      }
      case "C" -> {
        return C;
      }
      case "D" -> {
        return D;
      }
      case "M" -> {
        return M;
      }
    } return 0;

  }
        /* Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/



}
