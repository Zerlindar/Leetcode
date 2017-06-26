package leetcode;

/**
 * Created by yongfeng on 17/4/24.
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        int res = 0;
        for(int i = 2 ; i < n ; ++i){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }
}


/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 */