package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Created by jaiprakash on 5/1/19
 */
public class CatalanNumber {
  private Long sol[] = new Long[101];

  private Long getCatalanNumber(Integer i) {
    sol[0] = sol[1] = 1L;

    IntStream.rangeClosed(2, i)
        .forEach(
            value -> {
              sol[value] = getCatalanNumberBottomUp(value);
            });

    return sol[i];
  }

  private Long getCatalanNumberBottomUp(Integer value) {
    return
        IntStream.range(0, value)
            .mapToLong(index -> sol[index] * sol[value-index-1])
            .sum();
  }

  public static void main (String[] args) throws Exception {
    CatalanNumber cn = new CatalanNumber();
    BufferedReader cin =
        new BufferedReader(
            new InputStreamReader(System.in)
        );

    int n = Integer.parseInt(cin.readLine());

    cin.lines()
        .limit(n)
        .map(x -> cn.getCatalanNumber(Integer.parseInt(x)))
        .forEach(System.out::println);
  }
}