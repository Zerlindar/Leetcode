package leetcode;

/**
 * Created by sunyongfeng on 2017/6/15.
 */
public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        if(s == null){
            return 0;
        }
        int len = s.length();
        int[] cnt = new int[128];
        for(int i = 0 ; i < len ; ++i){
            ++cnt[s.charAt(i)];
        }
        int res = 0 ;
        boolean hasMore = false;
        for(int num : cnt){
            if(num % 2 == 0){
                res += num;
            }else{
                hasMore = true;
                res += (num - 1);
            }
        }
        return hasMore? res + 1 : res;
    }
}


/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */