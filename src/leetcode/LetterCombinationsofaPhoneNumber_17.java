package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunyongfeng on 2017/7/10.
 */
public class LetterCombinationsofaPhoneNumber_17 {


    private static Map<Character,char[]> map;

    static {
        map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(null == digits){
            return res;
        }
        int len = digits.length();
        if(0 == len ){
            return res;
        }
        char[] chars = map.get(digits.charAt(0));
        for(char c : chars){
            res.add(String.valueOf(c));
        }
        for(int i = 1 ; i < len ; ++i){
            chars = map.get(digits.charAt(i));
            List<String> tmp = new ArrayList<>();
            for(String s : res){
                for(char c : chars){
                    tmp.add(s + c);
                }
            }
            res = tmp;
        }
        return res;
    }


    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber_17 letterCombinationsofaPhoneNumber_17 = new LetterCombinationsofaPhoneNumber_17();
        letterCombinationsofaPhoneNumber_17.letterCombinations("234");
    }

}


/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */