package com.practice;

/*
https://leetcode.com/problems/string-to-integer-atoi/
String to Integer (atoi)

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

*/

public class StringToInt {

  public static void main(String args[]) {
    StringToInt test = new StringToInt();
    System.out.println(test.myAtoi("   -42.jai"));
  }

  /*
  Runtime: 2 ms
  Memory Usage: 37.3 MB
  https://leetcode.com/submissions/detail/223707764/
  */
  public int myAtoi(String str) {
    Character firstChar = null;
    int sign = 1;
    Long num = 0L;
    Long INT_MIN = -2147483648L;
    Long INT_MAX = 2147483647L;
    Character curChar = null;

    for(int i = 0; i < str.length(); i++) {
      if(firstChar == null && str.charAt(i) == ' ') {
        continue;
      } else if(firstChar == null && str.charAt(i) == '+') {
        firstChar = str.charAt(i);
        sign = 1;
      } else if(firstChar == null && str.charAt(i) == '-') {
        firstChar = str.charAt(i);
        sign = -1;
      } else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        if(firstChar == null) {
          firstChar = str.charAt(i);
        }
        num *= 10;
        num += str.charAt(i) - '0';
        if(num*sign > INT_MAX) {
          num = INT_MAX;
          break;
        }
        if(num*sign < INT_MIN) {
          num = INT_MIN;
          break;
        }
      } else {
        break;
      }
    }
    return num.intValue()*sign;
  }
}
