package leetcode;

/**
 * Created by yongfeng on 17/3/16.
 */
public class Searcha2DMatrixII_240 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int columns = matrix[0].length;
        int i = rows - 1;
        int j = 0;
        while(i >= 0 && j < columns){
            if(matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                ++j;
            }else{
                --i;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {}
        };

        Searcha2DMatrixII_240 searcha2DMatrixII_240 = new Searcha2DMatrixII_240();
        for(int i = 0 ; i < 31 ; ++i){
            System.out.println(i + "    " + searcha2DMatrixII_240.searchMatrix(matrix,i));
        }
    }

}



/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Subscribe to see which companies asked this question.

 */