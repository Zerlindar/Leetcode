package leetcode;

/**
 * Created by yongfeng on 16/12/13.
 */


//In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
//
//        For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
//
//        Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
//
//        Note:
//
//        The given numbers of 0s and 1s will both not exceed 100
//        The size of given string array won'SkipList exceed 600.
//
//        Example 1:
//
//        Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//        Output: 4
//
//        Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
//
//        Example 2:
//
//        Input: Array = {"10", "0", "1"}, m = 1, n = 1
//        Output: 2
//
//        Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
//
//        Subscribe to see which companies asked this question

public class OnesandZeroes_474 {



    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[m+1][n+1];
        for(int i = 0 ; i < len ; ++i){
            int[] tmp = helper(strs[i]);
            for(int j = m ; j >= tmp[0] ; --j){
                for(int k = n ; k >= tmp[1]; --k){
                    cnt[j][k]= cnt[j][k] > (1 + cnt[j - tmp[0]][k - tmp[1]]) ? cnt[j][k] : (1 + cnt[j - tmp[0]][k - tmp[1]]);
                }
            }
        }

        return cnt[m][n];
    }


    private static int[] helper(String s) {

        int[] res = new int[2];

        int len = s.length();
        for(int i = 0 ; i< len ; ++i){
            if(s.charAt(i) == '0'){
                ++res[0];
            }
            if(s.charAt(i) == '1'){
                ++res[1];
            }
        }

        return res;

    }




    public static void main(String[] args) {
        String[] arrs ={"10", "0", "1"};
        System.out.println(findMaxForm(arrs,1,1));
    }
}
