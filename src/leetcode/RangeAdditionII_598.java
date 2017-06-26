package leetcode;

/**
 * Created by sunyongfeng on 2017/6/26.
 */
public class RangeAdditionII_598 {

    public int maxCount(int m, int n, int[][] ops) {
        int rows = ops.length;
        if(rows == 0){
            return m * n;
        }
        for(int i = 0; i < rows; ++i){
            m = ops[i][0] > m ? m : ops[i][0];
            n = ops[i][1] > n ? n : ops[i][1];
        }
        return m * n;
    }


    public static void main(String[] args) {
        RangeAdditionII_598 rangeAdditionII_598 = new RangeAdditionII_598();
        int[][] ops ={{6,4},{8,28},{21,36},{18,16},{11,13}};

        System.out.println(rangeAdditionII_598.maxCount(25,39,ops));
    }

}


/*
Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input:
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation:
Initially, M =
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M =
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M =
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.
Note:
The range of m and n is [1,40000].
The range of a is [1,m], and the range of b is [1,n].
The range of operations size won'SkipList exceed 10,000.
 */