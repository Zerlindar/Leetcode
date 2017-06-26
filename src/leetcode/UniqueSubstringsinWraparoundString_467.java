package leetcode;

/**
 * Created by yongfeng on 16/12/7.
 */



//Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
// so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
//
//        Now we have another string p.
// Your job is to find out how many unique non-empty substrings of p are present in s.
// In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
//
//        Note: p consists of only lowercase English letters and the size of p might be over 10000.
//
//        Example 1:
//        Input: "a"
//        Output: 1
//
//        Explanation: Only the substring "a" of string "a" is in the string s.
//        Example 2:
//        Input: "cac"
//        Output: 2
//        Explanation: There are two substrings "a", "c" of string "cac" in the string s.
//        Example 3:
//        Input: "zab"
//        Output: 6
//        Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
//        Subscribe to see which companies asked this question
//
//        Show Tags

public class UniqueSubstringsinWraparoundString_467 {

    public int findSubstringInWraproundString(String p) {

        int len = p.length();
        if(len == 0 || len ==1 ){
            return len;
        }

        int[] cnt = new int[26];
        int tmp = 1;
        int res = 0;
        for(int i =0 ; i  < len ; ++i){
            if(i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 || (p.charAt(i)== 'a' && p.charAt(i-1) == 'z'))){
                ++tmp;
            }else{
                tmp = 1;
            }
            if(tmp > cnt[p.charAt(i) - 'a']){
                res +=(tmp - cnt[p.charAt(i) - 'a']);
                cnt[p.charAt(i) - 'a'] = tmp;
            }
        }
        return res;

    }
}
