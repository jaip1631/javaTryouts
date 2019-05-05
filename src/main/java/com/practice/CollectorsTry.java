package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jaiprakash on 25/1/19
 */
public class CollectorsTry {
  public static void main(String args[]) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    list = list.stream()
              .map(integer -> integer*2)
              .collect(Collectors.toList());
    list.forEach(System.out::println);
  }
}
