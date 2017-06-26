package leetcode;

/**
 * Created by yongfeng on 17/2/24.
 */
public class DecodeWays_91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        if(len == 1){
            return len;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len ; ++i){
            if(s.charAt(i-1) != '0' && (s.charAt(i-1)-'0') * 10 + s.charAt(i) - '0' <= 26 ){
                dp[i] += i - 2 >= 0 ? dp[i-2] : 1;
            }
            if(s.charAt(i) != '0'){
                dp[i] += dp[i-1];
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        DecodeWays_91 decodeWays_91 = new DecodeWays_91();
        String s = "17";

        System.out.println(decodeWays_91.numDecodings(s));
    }

}



/**
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */