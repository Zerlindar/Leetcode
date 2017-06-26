package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yongfeng on 16/12/8.
 */
//利用贪心算法计算s1与s2对应字符的匹配位置，由于s1与s2的循环匹配呈现周期性规律，因此可以通过辅助数组dp进行记录
//
//        记l1, l2为s1, s2的长度；x1, x2为s1, s2的字符下标
//
//        令y1, y2 = x1 % l1, x2 % l2
//
//        当s1[y1] == s2[y2]时：
//
//        若dp[y1][y2]不存在，则令dp[y1][y2] = x1, x2
//
//        否则，记dx1, dx2 = dp[y1][y2]，循环节为s1[dx1 ... x1], s2[dx2 ... x2]

//class Solution(object):
//        def getMaxRepetitions(self, s1, n1, s2, n2):
//        """
//        :type s1: str
//        :type n1: int
//        :type s2: str
//        :type n2: int
//        :rtype: int
//        """
//        if not set(s2) <= set(s1):
//          return 0
//        l1, l2 = len(s1), len(s2)
//        dp = collections.defaultdict(dict)
//        x1 = x2 = 0
//        while x1 < l1 * n1:
//        while s1[x1 % l1] != s2[x2 % l2]:
//        x1 += 1
//        if x1 >= l1 * n1:
//        break
//        y1, y2 = x1 % l1, x2 % l2
//        if y2 not in dp[y1]:
//        dp[y1][y2] = x1, x2
//        else:
//        dx1, dx2 = dp[y1][y2]
//        round = (l1 * n1 - dx1) / (x1 - dx1)
//        x1 = dx1 + round * (x1 - dx1)
//        x2 = dx2 + round * (x2 - dx2)
//        if x1 < l1 * n1:
//        x1 += 1
//        x2 += 1
//        return x2 / (n2 * l2)

//
//Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
//
//        On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1.
// For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
//
//        You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106.
// Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
//
//        Example:
//
//        Input:
//        s1="acb", n1=4   -->S1 = acbacbacbacb
//        s2="ab", n2=2    -->S2 = abab         ----->
//
//        Return:
//        2
//        Subscribe to see which companies asked this question

public class CountTheRepetitions_466 {

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if(!isInclude(s1,s2)){
            return 0;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int sum1 = len1 * n1;
        int count = 0;

        for(int i = 0 , j = 0; i < sum1 ; ++i){
            int idx = i % len1;
            if(s1.charAt(idx) == s2.charAt(j)){
                ++ j;
            }
            if(j >= len2){
                ++count;
                j = 0;
            }
        }

        return count / n2;


    }

    public static Boolean isInclude(String s1,String s2){
        Set<Character> characterSet = new HashSet<>();
        int len2 = s2.length();
        int len1 = s1.length();
        for(int i = 0 ; i < len2 ; ++i){
            characterSet.add(s2.charAt(i));
        }

        for(int j = 0 ; j < len1; ++j){
            characterSet.remove(s1.charAt(j));
        }

        return characterSet.size() == 0;
    }


    public static void main(String[] args) {

        String s1 = "niconiconicoo";
        String s2 = "nico";

        System.out.println(getMaxRepetitions(s1, 2, s2, 1));
    }

    // nlhqgllunmelayl  nlhqgllunmelayl
    // lnl

}
