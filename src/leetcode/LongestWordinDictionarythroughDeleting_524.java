package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongfeng on 17/4/7.
 */
public class LongestWordinDictionarythroughDeleting_524 {

    public String findLongestWord(String s, List<String> d) {
        int len = s.length();
        int i = 0 ;
        int j = 0;
        String res = "";
        for(String inner : d){
            int lenInner = inner.length();
            while(i < len && j < lenInner){
                if(inner.charAt(j) == s.charAt(i)){
                    ++j;
                }
                ++i;
            }
            if(j == lenInner && (lenInner > res.length() || (lenInner == res.length() && res.compareTo(inner) > 0))){
                res = inner;
            }
            i = 0 ;
            j = 0 ;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting_524 longestWordinDictionarythroughDeleting_524 = new LongestWordinDictionarythroughDeleting_524();
        String s = "foobarfoobar";
        List<String> d = new ArrayList<>();
        d.add("foo");
        d.add("bar");
        d.add("monkey");
        d.add("plea");


//        System.out.println("asd".compareTo("bds"));
//        System.out.println("bds".compareTo("asd"));

        System.out.println(longestWordinDictionarythroughDeleting_524.findLongestWord(s,d));
    }

}


/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won'SkipList exceed 1,000.
The length of all the strings in the input won'SkipList exceed 1,000.
Subscribe to see which companies asked this question.
 */