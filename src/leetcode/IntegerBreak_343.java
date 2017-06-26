package leetcode;

/**
 * Created by yongfeng on 16/12/28.
 */

//
//Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
//        For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
//
//        Note: You may assume that n is not less than 2 and not larger than 58.
//
//        Hint:
//
//        There is a simple O(n) solution to this problem.
//        You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
//        Credits:
//        Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question




public class IntegerBreak_343 {
    public static int integerBreak(int n) {
        int[] cnt = new int[n+1];
        cnt[0] = 0;
        cnt[1] = 1;
        for(int i = 2 ; i <= n ; ++i){
            for(int j = 1 ; j < i ; ++j){
                int tmp1 = cnt[i-j] * cnt[j];
                if(tmp1 > cnt[i]){
                    cnt[i] = tmp1 ;
                }
                int tmp2 = (i-j) * j;
                if(tmp2 > cnt[i]){
                    cnt[i] = tmp2 ;
                }
                int tmp3 = cnt[i-j] * j;
                if(tmp3 > cnt[i]){
                    cnt[i] = tmp3;
                }
                int tmp4 = (i-j) * cnt[j];
                if(tmp4 > cnt[i]){
                    cnt[i] = tmp4;
                }
            }
        }


        return cnt[n];
    }


    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }
}
