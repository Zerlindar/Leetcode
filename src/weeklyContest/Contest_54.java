package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/10/15.
 */
public class Contest_54 {

    public static void main(String[] args) {
        Contest_54 contest_54 = new Contest_54();
        int[] nums = {2,11,1,10,4,10,1,4,2};
        System.out.println(contest_54.canPartitionKSubsets(nums,3));
    }



    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int num : nums){
            sum += num;
            cnt.put(num,cnt.getOrDefault(num,0) + 1);
        }
        if(sum%k != 0){
            return false;
        }
        int target = sum/k;
        int ready = cnt.get(target) == null ? 0 : cnt.get(target);
        cnt.put(target,0);
        return helper(cnt,target,k,ready,target);
    }

    private boolean helper(Map<Integer,Integer> cnt ,int curTarget,int k,int ready,int oriTarget){
        if(ready == k){
            return true;
        }
        Set<Integer> keySet = cnt.keySet();
        for(Integer num : keySet){
            if(cnt.get(num) > 0){
                if(curTarget == num){
                    ++ready;
                    cnt.put(num,cnt.get(num) - 1);
                    return helper(cnt,oriTarget,k,ready,oriTarget);
                }else if(curTarget > num){
                    if(cnt.get(curTarget - num) != null && cnt.get(curTarget - num) > 0){
                        cnt.put(num,cnt.get(num) - 1);
                        cnt.put(curTarget- num,cnt.get(curTarget - num) - 1);
                        ++ready;
                        return helper(cnt,oriTarget,k,ready,oriTarget);
                    }
                    cnt.put(num,cnt.get(num) - 1);
                    if( helper(cnt,curTarget - num,k,ready,oriTarget)){
                        return true;
                    }
                    cnt.put(num,cnt.get(num) + 1);
                }else{
                    return false;
                }

            }
        }
        return false;
    }

    public int countBinarySubstrings(String s) {
        if(null == s || s.length() == 1){
            return 0;
        }
        int res = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 0 ; i < len ; ++i){
            int[] tmp= new int[2];
            int j = i;
            while(j < len && chars[i] == chars[j]){
                ++tmp[0];
                ++j;
            }
            while(j < len && chars[i] != chars[j]){
                ++tmp[1];
                ++j;
                if(tmp[1] == tmp[0]){
                    break;
                }
            }
            if(tmp[0] == tmp[1]){
                ++res;
            }
        }
        return res;
    }




    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> start = new HashMap<>();
        Map<Integer,Integer> end = new HashMap<>();
        int max = 1;
        int i = 0;
        for(int num : nums){
            int old = map.getOrDefault(num,0);
            map.put(num,old+ 1);
            if(old + 1 > max){
                max = old + 1;
            }
            if(start.get(num) == null){
                start.put(num,i);
            }else{
                end.put(num,i);
            }
            ++i;
        }
        if(max == 1){
            return 1;
        }
        int min = nums.length;
        for(int num : nums){
            if(map.get(num) == max && start.get(num) != null && end.get(num) != null){
                min = Math.min(min,(end.get(num) - start.get(num)));
            }
        }
        return min + 1;

    }


}
