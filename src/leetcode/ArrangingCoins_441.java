package leetcode;

/**
 * Created by yongfeng on 16/11/2.
 */


//
//441. Arranging Coins   QuestionEditorial Solution  My Submissions
//
//        You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
//        Given n, find the total number of full staircase rows that can be formed.
//
//        n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
//        Example 1:
//
//        n = 5
//
//        The coins can form the following rows:
//        ¤
//        ¤ ¤
//        ¤ ¤
//
//        Because the 3rd row is incomplete, we return 2.
//        Example 2:
//
//        n = 8
//
//        The coins can form the following rows:
//        ¤
//        ¤ ¤
//        ¤ ¤ ¤
//        ¤ ¤
//
//        Because the 4th row is incomplete, we return 3.


public class ArrangingCoins_441 {

    public static  int arrangeCoins(int n) {
        int sum = 0;
        for(int i = 1;; ++i){
            if(n - sum < i){
                return i-1;
            }
            sum += i;
        }
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
    }
}
