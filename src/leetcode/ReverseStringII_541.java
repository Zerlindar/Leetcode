package leetcode;

/**
 * Created by yongfeng on 17/5/4.
 */
public class ReverseStringII_541 {

    public String reverseStr(String s, int k) {
        if(null == s || s.length() < 1 || k < 2){
            return s;
        }
        int len = s.length();
        if(len < k){
            return helper(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int start = 0 ; start < len ; start += (2 * k)){
            int end = (start + k ) < len ? (start + k) : len;
            stringBuilder.append(helper(s.substring(start, end)));
            if(end < len){
                stringBuilder.append(s.substring(end,(end + k ) < len ? (end + k) : len ));
            }
        }
        return stringBuilder.toString();
    }

    private String helper(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseStringII_541 reverseStringII_541 = new ReverseStringII_541();
        reverseStringII_541.reverseStr("abcdefg",2);
    }


}


/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */