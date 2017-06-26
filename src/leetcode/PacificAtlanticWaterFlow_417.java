package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongfeng on 16/10/14.
 */
public class PacificAtlanticWaterFlow_417 {


//    417. Pacific Atlantic Water Flow   QuestionEditorial Solution  My Submissions
//    Total Accepted: 1831
//    Total Submissions: 6173
//    Difficulty: Medium
//    Contributors: Admin
//    Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
//    the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
//    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
//    Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
//            Note:
//    The order of returned grid coordinates does not matter.
//    Both m and n are less than 150.
//    Example:
//
//    Given the following 5x5 matrix:
//
//    Pacific ~   ~   ~   ~   ~
//            ~  1   2   2   3  (5) *
//            ~  3   2   3  (4) (4) *
//            ~  2   4  (5)  3   1  *
//            ~ (6) (7)  1   4   5  *
//            ~ (5)  1   1   2   4  *
//            *   *   *   *   * Atlantic
//
//    Return:
//
//            [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).


    public static boolean checkPacific(int[][] matrix,int[][] cntOfPacific,int rows,int columns,int x,int y){


        if(cntOfPacific[x][y] == 1){
            return true;
        }
        if(x == 0 || y == 0){
            cntOfPacific[x][y] =1 ;
            return true;
        }
        cntOfPacific[x][y] = 2;

        if(x-1 >= 0 && cntOfPacific[x-1][y] != 2){
            if(matrix[x-1][y] <= matrix[x][y]){
               if(cntOfPacific[x-1][y] == 1){
                   cntOfPacific[x][y] = 1;
                   return true;
               }
               else{
                   if(checkPacific(matrix, cntOfPacific, rows, columns, x - 1, y)){
                       cntOfPacific[x][y] = 1;
                       return true;
                   }
               }
            }
        }
        if(x+1 < rows && cntOfPacific[x+1][y] != 2){
            if(matrix[x+1][y] <= matrix[x][y]){
                if(cntOfPacific[x+1][y] == 1){
                    cntOfPacific[x][y] = 1;
                    return true;
                }else{
                    if(checkPacific(matrix, cntOfPacific, rows, columns, x + 1, y)){
                        cntOfPacific[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        if(y-1 >= 0 && cntOfPacific[x][y-1] != 2){
            if(matrix[x][y-1] <= matrix[x][y]){
                if(cntOfPacific[x][y-1] == 1){
                    cntOfPacific[x][y] = 1;
                    return true;
                }else{
                    if(checkPacific(matrix, cntOfPacific, rows, columns, x, y - 1)){
                        cntOfPacific[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        if(y+1 < columns && cntOfPacific[x][y+1] != 2 ){
            if(matrix[x][y+1] <= matrix[x][y]){
                if(cntOfPacific[x][y+1] == 1){
                    cntOfPacific[x][y] = 1;
                    return true;
                }else{
                    if(checkPacific(matrix, cntOfPacific, rows, columns, x, y + 1)){
                        cntOfPacific[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        cntOfPacific[x][y] = 0;
        return false;
    }


    public static boolean checkAtlantic(int[][] matrix,int[][] cntOfAtlantic,int rows,int columns,int x,int y){

        if(cntOfAtlantic[x][y] == 1){
            return true;
        }

        if(x == rows-1 || y == columns -1){
            cntOfAtlantic[x][y] = 1;
            return true;
        }

        cntOfAtlantic[x][y] =2;

        if(x-1 >= 0 && cntOfAtlantic[x-1][y] != 2){
            if(matrix[x-1][y] <= matrix[x][y]){
                if(cntOfAtlantic[x-1][y] == 1){
                    cntOfAtlantic[x][y] = 1;
                    return true;
                }else{
                    if(checkAtlantic(matrix, cntOfAtlantic, rows, columns, x - 1, y)){
                        cntOfAtlantic[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        if(x+1 < rows && cntOfAtlantic[x+1][y] != 2){
            if(matrix[x+1][y] <= matrix[x][y]){
                if(cntOfAtlantic[x+1][y] == 1){
                    cntOfAtlantic[x][y] = 1;
                    return true;
                }else {
                    if(checkAtlantic(matrix, cntOfAtlantic, rows, columns, x + 1, y)){
                        cntOfAtlantic[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        if(y-1 >= 0 && cntOfAtlantic[x][y-1] != 2){
            if(matrix[x][y-1] <= matrix[x][y]){
                if(cntOfAtlantic[x][y-1] == 1){
                    cntOfAtlantic[x][y] = 1;
                    return true;
                }else {
                    if(checkAtlantic(matrix, cntOfAtlantic, rows, columns, x, y - 1)){
                        cntOfAtlantic[x][y] = 1;
                        return true;
                    }
                }
            }
        }
        if(y+1 < columns && cntOfAtlantic[x][y+1] != 2){
            if(matrix[x][y+1] <= matrix[x][y]){
                if(cntOfAtlantic[x][y+1] == 1){
                    cntOfAtlantic[x][y] = 1;
                    return true;
                }else{
                    if(checkAtlantic(matrix, cntOfAtlantic, rows, columns, x, y + 1)){
                        cntOfAtlantic[x][y] = 1;
                        return true;
                    }
                }
            }
        }

        cntOfAtlantic[x][y] = 0;
        return false;
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();

        int rows = matrix.length;
        if(rows == 0){
            return res;
        }
        int columns = matrix[0].length;
        int[][] cntOfPacific = new int[rows][columns];
        int[][] cntOfAtlantic = new int[rows][columns];
        for(int i = 0 ; i< rows; ++i){
            for(int j = 0 ; j < columns ; ++j){
                cntOfAtlantic[i][j] = 0;
                cntOfPacific[i][j] = 0;
            }
        }

        for(int i= 0 ; i< rows; ++i){
            for(int j = 0; j< columns ; ++j){
                checkPacific(matrix,cntOfPacific,rows,columns,i,j);
                checkAtlantic(matrix,cntOfAtlantic,rows,columns,i,j);
            }
        }

        for(int i= 0 ;i< rows; ++i){
            for(int j = 0; j < columns ; ++j){
                if(cntOfAtlantic[i][j] == 1 && cntOfPacific[i][j] == 1) {
                    res.add(new int[]{i, j});
                   // System.out.println(i + "  " + j);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int tmp[][]= {
                {7,1,17,13,9,10,5,14,0,3},{7,15,7,8,15,16,10,10,5,13},{18,9,15,8,19,16,7,5,5,10},{15,11,18,3,1,17,6,4,10,19},{3,16,19,12,12,19,2,14,5,9},{7,16,0,13,14,7,2,8,6,19},{5,10,1,10,2,12,19,1,0,19},{13,18,19,12,17,17,4,5,8,2},{2,1,17,13,14,12,14,2,16,10},{5,8,1,11,16,1,18,15,6,19},{3,8,14,14,5,0,2,7,5,1},{17,1,9,17,10,10,10,7,1,16},{14,18,5,11,17,15,8,8,14,13},{6,4,10,17,8,0,11,4,2,8},{16,11,17,9,3,2,11,0,6,5},{12,18,18,11,1,7,12,16,12,12},{2,14,12,0,2,8,5,10,7,0},{16,13,1,19,8,13,11,8,11,3},{11,2,8,19,6,14,14,6,16,12},{18,0,18,10,16,15,15,12,4,3},{8,15,9,13,8,2,6,11,17,6},{7,3,0,18,7,12,2,3,12,10},{7,9,13,0,11,16,9,9,12,13},{9,4,19,6,8,10,12,6,7,11},{5,9,18,0,4,9,6,4,0,1},{9,12,1,11,13,13,0,16,0,6},{7,15,4,8,15,17,17,19,15,1},{7,17,4,1,1,14,10,19,10,19},{10,5,12,5,8,8,14,14,6,0},{16,10,10,7,13,4,0,15,18,0},{11,2,10,6,5,13,4,5,3,1},{9,14,16,14,15,3,2,13,17,8},{19,2,10,1,2,15,12,10,2,5},{12,4,8,9,8,6,4,14,14,0},{11,17,17,4,16,13,6,15,5,7},{12,18,1,3,9,10,7,1,1,1},{18,6,10,8,12,14,9,12,10,3},{15,13,18,13,8,5,12,14,18,0},{15,4,8,9,19,18,6,19,12,0},{4,14,15,4,17,17,9,17,9,0},{6,17,16,10,3,8,8,18,15,9},{3,8,4,2,13,0,2,8,8,2},{14,12,13,12,17,4,16,9,8,7},{0,19,8,16,1,13,7,6,15,11},{1,13,16,14,10,4,11,19,9,13},{8,0,2,1,16,12,16,9,9,9},{5,2,10,4,8,12,17,0,2,15},{11,2,15,15,14,9,11,19,18,11},{4,4,1,5,13,19,9,17,17,17},{4,1,8,0,8,19,11,0,5,4},{8,16,14,18,12,2,0,19,0,13},{7,11,3,18,8,2,2,19,8,7},{3,13,6,1,12,16,4,13,0,5},{12,1,16,19,2,12,16,15,19,6},{1,7,12,15,3,3,13,17,16,12}};

        for(int i = 0;i < tmp.length; ++i){
            for(int j= 0; j < tmp[i].length; ++j){
                System.out.printf("%2d |" ,tmp[i][j]);
            }
            System.out.println("");
        }
       pacificAtlantic(tmp);
    }
}

//[[0,9],[1,9],[2,9],[3,9],[11,3],[53,0],[53,2],[53,3],[54,0],[54,1],[54,2],[54,3]]