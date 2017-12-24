package weeklyContest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/12/24.
 */
public class Contest_64 {

    public static void main(String[] args) {
        Contest_64 contest_64 = new Contest_64();

        int[] nums = {1,2,3,4};
        System.out.println(contest_64.dominantIndex(nums));

    }


    public List<String> ipToCIDR(String ip, int range) {
        List<String> res = new ArrayList<>();
        String[] tmp = ip.split(".");
        int[] nums = new int[4];
        for(int i = 0 ; i < 4; ++i){
            nums[i] = Integer.parseInt(tmp[i]);
        }

        int[] cnt = new int[8];
        for(int i = 0; i < 8 ; ++i){
            if(i == 0){
                cnt[i] = 1;
            }else{
                cnt[i] = cnt[i]*2;
            }
        }
        int sum = 1;
        res.add(ip + "/32");
        if(range == 1){
            return res;
        }
        for(int i = 3; i >= 0 ; --i){
            int next = 0;
            int j = 0;
            for(; j < 8 ; ++j){
                if(nums[i] == 1){
                    next = 1;
                    break;
                }else if(j > 0 && nums[i] >= cnt[j - 1] && nums[i] < cnt[j]){
                    next = cnt[j];
                    break;
                }
            }
            int pause = 1;
            for(int k = 1 ; k < j ; ++k){
                pause *=2;
            }
        }
        return res;
    }


    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int max = nums[0];
        int idx = 0;
        for(int i = 1 ; i < len ; ++i){
            if(nums[i] > max){
                idx = i;
                max = nums[i];
            }
        }
        for(int i = 0 ; i < len ; ++i){
            if(idx != i){
                if(max >= nums[i] + nums[i]){
                    continue;
                }else{
                    return -1;
                }
            }
        }
        return idx;
    }
}
