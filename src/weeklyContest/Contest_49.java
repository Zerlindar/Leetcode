package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/9/10.
 */
public class Contest_49 {


    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < len ; ++i){
            cnt[i] = 1;
            map.put(i,1);
        }
        int max = 1 ;
        int res = len ;
        for(int i = 1; i < len ; ++i){
            for(int j = 0 ; j < i ; ++j){
                if(nums[i] > nums[j] && cnt[i] <= cnt[j] + 1){
                    cnt[i] = cnt[j] + 1;
                    if(cnt[i] > max){
                        max = cnt[i];
                        res = map.get(j);
                    }else if(cnt[i] == max){
                        res += map.get(j);
                    }
                }
            }
            map.put(i,res);
        }
        return res;
    }


    class MagicDictionary {

        private List<String> dictList;


        /** Initialize your data structure here. */
        public MagicDictionary() {
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            if(null == dict || dict.length == 0){
                dictList = null;
            }else{
                dictList = new ArrayList<>();
                for(String s : dict){
                    dictList.add(s);
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            if(null == dictList){
                return false;
            }
            for(String s : dictList){
                if(s.length() != word.length() || s.equals(word)){
                    continue;
                }else{
                    int cnt = 0;
                    int len = s.length();
                    for(int i = 0 ; i < len ; ++i){
                        if(s.charAt(i) == word.charAt(i)){
                            continue;
                        }else{
                            ++cnt;
                        }
                    }
                    if(cnt == 1){
                        return true;
                    }
                }
            }


            return false;
        }
    }



    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int res = 1 ;
        int max = 1;
        for(int i = 0 ; i + 1 < len ; ++i){
            if(nums[i] < nums[i+1]){
                ++res;
                max = Math.max(max,res);
            }else{
                res = 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Contest_49 contest_49 = new Contest_49();
        int res = contest_49.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2});
        System.out.println(res);

    }
}
