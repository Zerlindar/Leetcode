package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongfeng on 17/7/19.
 */
public class PacificAtlanticWaterFlow_417 {

    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<int[]>();
        if(null == matrix){
            return res;
        }
        int m = matrix.length;
        if(m == 0){
            return res;
        }
        int n = matrix[0].length;
        boolean[][] toAtlantic = new boolean[m][n];
        boolean[][] toPacific = new boolean[m][n];

        for(int i = 0; i< m; i ++){
            toAtlantic[i][n-1] = true;
            toPacific[i][0] = true;
            helper(matrix,toAtlantic,i,n-1,m,n);
            helper(matrix,toPacific,i,0,m,n);
        }
        for(int i = 0; i < n; i ++){
            toAtlantic[m-1][i] = true;
            toPacific[0][i] = true;
            helper(matrix,toAtlantic,m-1,i,m,n);
            helper(matrix,toPacific,0,i,m,n);
        }

        for(int i = 0; i < m; i ++)
            for(int j = 0 ; j < n ; j ++){
                if(toAtlantic[i][j] && toPacific[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        return  res;
    }

    public void helper(int[][] matrix,boolean[][] flag,int x,int y,int m,int n){
        int[][] tmp = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0 ; i < 4 ; ++i){
            int tmp1 = x + tmp[i][0];
            int tmp2 = y + tmp[i][1];
            if(tmp1 >= 0 && tmp2 >= 0 && tmp1 < m && tmp2 < n && !flag[tmp1][tmp2] && matrix[tmp1][tmp2] >= matrix[x][y]){
                flag[tmp1][tmp2] = true;
                helper(matrix,flag,tmp1,tmp2,m,n);
            }
        }
    }



    public static void main(String[] args) {
        int tmp[][]= {{3,3,3,3},{3,0,3,3},{3,3,3,3}};

        for(int i = 0;i < tmp.length; ++i){
            for(int j= 0; j < tmp[i].length; ++j){
                System.out.printf("%2d |" ,tmp[i][j]);
            }
            System.out.println("");
        }
        PacificAtlanticWaterFlow_417 pacificAtlanticWaterFlow_417 = new PacificAtlanticWaterFlow_417();
        pacificAtlanticWaterFlow_417.pacificAtlantic(tmp);
    }
}

/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */