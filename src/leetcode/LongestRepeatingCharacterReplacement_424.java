package leetcode;

/**
 * Created by yongfeng on 16/10/18.
 */
public class LongestRepeatingCharacterReplacement_424 {
//
//    private static int cal(String s,int k){
//
//    }

    public static int characterReplacement(String s, int k) {
        if(s == null){
            return 0;
        }

        int len = s.length();
        if(len == 0){
            return 0;
        }


        int[] cnt = new int[26];
        int left = 0;
        int right = 0;
        int res = 0;
        for(;left < len ; ++ left){
            for(;right < len ; ++right){
                ++cnt[s.charAt(right) - 'A'];
                if(changeTimes(cnt) > k){
                   --cnt[s.charAt(right) - 'A'];
                    break;
                }
            }
            if(right - left > res){
                res = right - left;
            }
            --cnt[s.charAt(left)-'A'];
        }

        return res;
    }

    public static int changeTimes(int[] cnt){
        int sum = 0;
        int max = 0;
        for(int i = 0; i< 26; ++i){
            sum += cnt[i];
            if(cnt[i] > max){
                max = cnt[i];
            }
        }
        return sum - max;
    }

    public static void main(String[] args) {
        String s = "BAAAB";
        System.out.println(characterReplacement(s,2));
    }

//    "AABABBA"
//            1


}



//
//Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times.
// Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
//
//        Note:
//        Both the string's length and k will not exceed 104.
//
//        Example 1:
//
//        Input:
//        s = "ABAB", k = 2
//
//        Output:
//        4
//
//        Explanation:
//        Replace the two 'A's with two 'B's or vice versa.
//        Example 2:
//
//        Input:
//        s = "AABABBA", k = 1
//
//        Output:
//        4
//
//        Explanation:
//        Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//        The substring "BBBB" has the longest repeating letters, which is 4.