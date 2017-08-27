package weeklyContest;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/8/27.
 */
public class Contest_47 {


    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return true;
        }
        int cnt = 0 ;
        int max = nums[0];
        for(int i = 1 ; i  < len ; ++i){
            if(nums[i] < max){
                ++cnt;
            }
            max = nums[i];
        }
        return cnt < 2;

    }


}
