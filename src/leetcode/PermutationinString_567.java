package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunyongfeng on 2017/7/13.
 */
public class PermutationinString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if(null == s1 || null == s2){
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2 < len1){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0 ;i < len1 ; ++i){
            if(null == map.get(s1.charAt(i))){
                ++cnt;
                map.put(s1.charAt(i),1);
            }else{
                map.put(s1.charAt(i),map.get(s1.charAt(i)) + 1);
            }
        }

        for(int i = 0 ; i < len2 ; ++i){
            if(i < len1){
                if(map.containsKey(s2.charAt(i)) ){
                    map.put(s2.charAt(i),map.get(s2.charAt(i)) - 1);
                    if(0 == map.get(s2.charAt(i))){
                        --cnt;
                    }
                }
            }else{
                if(map.containsKey(s2.charAt(i - len1))){
                    map.put(s2.charAt(i - len1),map.get(s2.charAt(i - len1)) + 1);
                    if(map.get(s2.charAt(i - len1)) == 1){
                        ++cnt;
                    }

                }
                if(map.containsKey(s2.charAt(i))){
                    map.put(s2.charAt(i),map.get(s2.charAt(i)) - 1);
                    if(0 == map.get(s2.charAt(i))){
                        --cnt;
                    }
                }
            }
            if(cnt == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationinString_567 permutationinString_567 = new PermutationinString_567();
        System.out.println(permutationinString_567.checkInclusion("adc","dcda"));
    }
}


/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

 */
