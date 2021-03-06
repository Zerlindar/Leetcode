package leetcode;

/**
 * Created by yongfeng on 17/4/27.
 */
public class LongestPalindromicSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        if(null == s){
            return 0;
        }
        int len = s.length();
        if(len == 0 || len == 1){
            return len;
        }
        int[][] dp = new int[len][len];
        for(int i = len-1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else {
                    dp[i][j] = dp[i+1][j] > dp[i][j-1] ? dp[i+1][j] : dp[i][j-1];
                }
            }
        }
        return dp[0][len-1];
    }


}


/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 */