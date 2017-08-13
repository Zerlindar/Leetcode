package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/7/20.
 */
public class NQueens_51 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(new int[n], 0, n, res);
        return res;
    }
    private void helper(int[] queenPos, int row, int n, List<List<String>> res) {
        if(row == n) {
            res.add(getRes(queenPos,n));
        }
        for(int columns = 0; columns < n; columns++) {
            if (isValid(queenPos, row, columns)) {
                queenPos[row] = columns;
                helper(queenPos, row + 1, n, res);
            }
        }
    }
    private boolean isValid(int[] queenPos, int row, int columns) {
        for(int i = 0; i < row; i++) {
            int pos = queenPos[i];
            if (pos == columns || pos + row - i == columns || pos - row + i == columns) {
                return false;
            }
        }
        return true;
    }
    private List<String> getRes(int[] queenPos,int n){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i){
            StringBuilder stringBuilder= new StringBuilder();
            for(int j = 0 ; j < n ; ++j){
                if(queenPos[i] == j){
                    stringBuilder.append("Q");
                }else{
                    stringBuilder.append(".");
                }
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }


    public static void main(String[] args) {
        NQueens_51 nQueens_51 = new NQueens_51();
        System.out.println(nQueens_51.solveNQueens(4));
    }


}


/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */