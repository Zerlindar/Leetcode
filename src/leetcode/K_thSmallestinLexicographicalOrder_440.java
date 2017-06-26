package leetcode;

/**
 * Created by yongfeng on 16/10/25.
 */

//Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
//
//        Note: 1 ≤ k ≤ n ≤ 109.
//
//        Example:
//
//        Input:
//        n: 13   k: 2
//
//        Output:
//        10
//
//        Explanation:
//        The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.


public class K_thSmallestinLexicographicalOrder_440 {





    public static int findKthNumber(int n, int k) {

        int res = 1;
        --k;
        while(k > 0){
            long sum = getSum(res, n);
            if(sum <= k){
                k -=sum;
                ++res;
            }else{
                res *= 10;
                --k;
            }
        }
        return res;

    }


    public static long getSum(long start,long n){
        long end = start + 1;
        long sum = 0;
        while(start <= n){
            sum += Math.max(0,(Math.min(n+1,end)-start));
            start *=10;
            end *= 10;
        }
        return sum ;
    }



    public static void main(String[] args) {
//        for(int i = 1 ; i <= 100; ++i){
//            System.out.println(findKthNumber(100,i));
//        }

        System.out.println(findKthNumber(100,3));
    }
}

