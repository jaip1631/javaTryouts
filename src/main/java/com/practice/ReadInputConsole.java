package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by jaiprakash on 19/1/19
 */

public class ReadInputConsole {
  public static void main(String args[]) {
    try (BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in))) {
      int size = Integer.parseInt(br.readLine());
      StringTokenizer st;
      while(size != 0) {
        int arrSize = Integer.parseInt(br.readLine());

        int arr[] = new int[arrSize];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrSize; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arrSize; i++) {
          System.out.println(arr[i]);
        }
        size--;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
