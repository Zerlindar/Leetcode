package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongfeng on 16/11/3.
 */


//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//        The order of output does not matter.
//
//        Example 1:
//
//        Input:
//        s: "cbaebabacd" p: "abc"
//
//        Output:
//        [0, 6]
//
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//        Example 2:
//
//        Input:
//        s: "abab" p: "ab"
//
//        Output:
//        [0, 1, 2]
//
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".

public class FindAllAnagramsInaString_438 {

    public static  List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenP = p.length();
        int lenS = s.length();
        int[] target = new int[26];
        int[] tmp = new int[26];
        for(int i = 0 ; i< lenP; ++i){
            ++target[p.charAt(i) - 'a'];
        }
        for(int i = 0 ; i< lenS; ++ i){
            ++ tmp[s.charAt(i) - 'a'];
            if(i >= lenP-1){
                if(judge(target,tmp)){
                    res.add(i - lenP + 1);
                }
                --tmp[s.charAt(i - lenP + 1) - 'a'];
            }
        }

        return res;
    }


    public static Boolean judge(int[] target,int[] tmp){
        for(int i = 0 ; i< 26; ++i){
            if(target[i]!= tmp[i]){
                return false;
            }
        }
        return true;
    }






    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}
