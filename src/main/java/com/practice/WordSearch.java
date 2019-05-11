package com.practice;

/*
Tags: MatrixTag, BackTrackingTag
https://leetcode.com/problems/word-search/
Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

public class WordSearch {

  public static void main(String args[]) {
    WordSearch test = new WordSearch();
    System.out.println(
        test.exist(
            new char [][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
            "ABCCEE")
    );
  }

  /*
  Runtime: 3 ms
  Memory Usage: 38 MB
  https://leetcode.com/submissions/detail/228141116/
  */
  public boolean exist(char[][] board, String word) {
    if(board.length == 0 || board[0].length == 0 || word.length() == 0) {
      return false;
    }

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(search(board, word, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean search(char board[][], String word, int index,
      int curRow, int curCol) {
    if(curRow < 0 || curRow == board.length
        || curCol < 0 || curCol == board[0].length) {
      return false;
    }

    if(board[curRow][curCol]!= '0' && board[curRow][curCol] == word.charAt(index)) {
      if(index == word.length()-1) {
        return true;
      }
      char curChar = board[curRow][curCol];
      board[curRow][curCol] = '0';

      boolean exists = search(board, word, index+1, curRow-1, curCol)
          || search(board, word, index+1, curRow, curCol-1)
          || search(board, word, index+1, curRow+1, curCol)
          || search(board, word, index+1, curRow, curCol+1);

      board[curRow][curCol] = curChar;

      return exists;
    }

    return false;
  }
}
