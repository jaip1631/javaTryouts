package com.practice;

/*
https://leetcode.com/problems/integer-to-roman/
Integer to Roman

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

  public static void main(String args[]) {
    IntegerToRoman test = new IntegerToRoman();
    System.out.println(intToRoman(1994));
  }

  /*
  Runtime: 3 ms
  Memory Usage: 37.2 MB
  https://leetcode.com/submissions/detail/226871764/
  */
  public static final int value[]= {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
  public static final String roman[]={"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
  public static String intToRoman(int num) {
    StringBuilder builder=new StringBuilder();
    while(num!=0) {
      for(int i=value.length-1;i>=0;i--) {
        if(num/value[i]!=0) {
          builder.append(roman[i]);
          num=num-value[i];
          break;
        }
      }
    }
    return builder.toString();
  }



  /*
  Runtime: 10 ms
  Memory Usage: 37.8 MB
  https://leetcode.com/submissions/detail/223945552/
  */
  private Map<Integer, String> ITRMap = new HashMap<>();
  //private Integer arr[] = [1, 5, 10, 50, 100, 500, 1000];

  private void initMap() {
    ITRMap.put(1, "I");
    ITRMap.put(2, "II");
    ITRMap.put(3, "III");
    ITRMap.put(4, "IV");
    ITRMap.put(5, "V");
    ITRMap.put(6, "VI");
    ITRMap.put(7, "VII");
    ITRMap.put(8, "VIII");
    ITRMap.put(9, "IX");
    ITRMap.put(10, "X");
    ITRMap.put(20, "XX");
    ITRMap.put(30, "XXX");
    ITRMap.put(40, "XL");
    ITRMap.put(50, "L");
    ITRMap.put(60, "LX");
    ITRMap.put(70, "LXX");
    ITRMap.put(80, "LXXX");
    ITRMap.put(90, "XC");
    ITRMap.put(100, "C");
    ITRMap.put(200, "CC");
    ITRMap.put(300, "CCC");
    ITRMap.put(400, "CD");
    ITRMap.put(500, "D");
    ITRMap.put(600, "DC");
    ITRMap.put(700, "DCC");
    ITRMap.put(800, "DCCC");
    ITRMap.put(900, "CM");
    ITRMap.put(1000, "M");
    ITRMap.put(2000, "MM");
    ITRMap.put(3000, "MMM");
  }

  private String getITR(int n) {
    return ITRMap.get(n);
  }

  public String intToRoman_1(int num) {
    initMap();
    String ans = "";
    int tens = 10;
    int curNum = 0;
    while(num != 0) {
      curNum = num%tens;
      if(curNum != 0) {
        ans = getITR(curNum) + ans;
      }
      num = num - curNum;
      tens*=10;
    }
    return ans;
  }
}
