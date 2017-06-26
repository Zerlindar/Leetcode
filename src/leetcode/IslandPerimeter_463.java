package leetcode;

/**
 * Created by yongfeng on 16/11/30.
 */


//You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
// Grid cells are connected horizontally/vertically (not diagonally).
// The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
// The island doesn'SkipList have "lakes" (water inside that isn'SkipList connected to the water around the island).
// One cell is a square with side length 1. The grid is rectangular, width and height don'SkipList exceed 100. Determine the perimeter of the island.
//
//        Example:
//
//        [[0,1,0,0],
//         [1,1,1,0],
//         [0,1,0,0],
//         [1,1,0,0]]
//
//        Answer: 16
//        Explanation: The perimeter is the 16 yellow stripes in the image below:
//
//        Subscribe to see which companies asked this question
public class IslandPerimeter_463 {
    public static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int columns = grid[0].length;

        int[][] cnt = new int[rows][columns];

        int all = 0;

        int allOfOne = 0;

        for(int i = 0; i < rows ; ++i){
            for(int j = 0; j < columns ; ++j){
                if(grid[i][j] == 1){
                    ++ allOfOne;
                    if(i-1 >=0 && grid[i-1][j] == 1 && cnt[i-1][j] == 1){
                        ++all;
                    }
                    if(i+1 < rows && grid[i+1][j] == 1 && cnt[i+1][j] == 1){
                        ++all;
                    }
                    if(j-1 >=0 && grid[i][j-1] ==1 && cnt[i][j-1] ==1){
                        ++all;
                    }
                    if(j+1 < columns && grid[i][j+1] == 1 && cnt[i][j+1] ==1){
                        ++all;
                    }
                    cnt[i][j] = 1;
                }
            }
        }
        return (allOfOne << 2) - (all << 1);
    }

    public static void main(String[] args) {
        int[][] grid =  {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(islandPerimeter(grid));
    }
}
