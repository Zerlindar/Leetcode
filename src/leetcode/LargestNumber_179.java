package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yongfeng on 17/4/5.
 */
public class LargestNumber_179 {

    public String largestNumber(int[] nums) {
        if(null == nums){
            return "";
        }
        int len = nums.length;
        if(0 == len ){
            return "";
        }
        String[] tmp = new String[len];
        for(int i = 0 ; i < len ; ++i){
            tmp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < len ; ++i){
            sb.append(tmp[i]);
        }
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.delete(0,1);
        }
        return sb.toString();
    }

    
}


/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question.
 */