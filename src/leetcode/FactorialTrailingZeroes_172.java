package leetcode;

/**
 * Created by yongfeng on 17/3/11.
 */
public class FactorialTrailingZeroes_172 {

    //递归
    public int trailingZeroes2(int n) {
        return n < 5 ? 0 : trailingZeroes(n / 5) + n /5;
    }

    //尾递归
    public int trailingZeroes(int n){
        return tailRescuvie(n,0);
    }

    public int tailRescuvie(int n ,int a){
        return n < 5 ? a : tailRescuvie(n/5,a + n/5);
    }

}



//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note: Your solution should be in logarithmic time complexity.
//
//        Credits:
//        Special thanks to @ts for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.