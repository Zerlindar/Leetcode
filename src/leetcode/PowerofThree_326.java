package leetcode;

/**
 * Created by sunyongfeng on 2017/6/29.
 */


public class PowerofThree_326 {

    private static final double epsilon = 10e-15;

    public boolean isPowerOfThree(int n) {
        if(0 == n)
            return false;
        double res = Math.log(n)/Math.log(3);
        return Math.abs(res - Math.round(res)) < epsilon;
    }

}


/**
 *
 *
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.

 */
