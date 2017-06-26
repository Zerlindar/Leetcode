package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongfeng on 17/4/14.
 */
public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        int rows = board.length;
        if(0 == rows){
            return ;
        }
        int columns = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < rows ; ++i){
            if(board[i][0] == 'O'){
                board[i][0] = '*';
                queue.offer(new int[]{i,0});
            }
            if(board[i][columns - 1] == 'O'){
                board[i][columns - 1] = '*';
                queue.offer(new int[]{i,columns -1});
            }
        }

        for(int i = 1 ; i < columns - 1; ++i){
            if(board[0][i] == 'O'){
                board[0][i] = '*';
                queue.offer(new int[]{0,i});
            }
            if(board[rows - 1][i] == 'O'){
                board[rows - 1][i] = '*';
                queue.offer(new int[]{rows -1 ,i});
            }
        }

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            helper(tmp[0],tmp[1],queue,rows,columns,board);
        }

        for(int i = 0 ; i < rows ; ++i){
            for(int j = 0 ; j < columns ; ++j){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
        return ;

    }

    private void helper(int i ,int j,Queue<int[]> queue,int rows,int columns,char[][] board){
        int[][] tmp = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; ++k){
            int x = i + tmp[k][0];
            int y = j + tmp[k][1];
            if( x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O'){
                board[x][y] = '*';
                queue.offer(new int[]{x,y});
            }
        }
    }


    private boolean isSurrounded(int i,int j,int rows,int columns,char[][] board){
        if(i == 0 || i == rows - 1 || j == 0 || j == columns - 1){
            return false;
        }
        int[][] tmp = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean res = true;
        for(int k = 0 ; k < 4 ; ++k){
            int x = i + tmp[k][0];
            int y = j + tmp[k][1];
            if( x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O'){
                board[i][j] = 'X';
                if(!isSurrounded(x,y,rows,columns,board)){
                    res = false;
                }else{
                    board[x][y] = 'X';
                }
                board[i][j] = 'O';
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SurroundedRegions_130 surroundedRegions_130 = new SurroundedRegions_130();
        char[][] board = {
                {'X','X','O','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','O','X'}
        };
        surroundedRegions_130.solve(board);
    }

}


/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X


 */