package leetcode;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/7/18.
 */
public class SmallestRange_632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        if(null == nums){
            return null;
        }
        int rows = nums.size();
        List<int[]> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < rows; ++i){
            for(Integer num : nums.get(i)){
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = num;
                list.add(tmp);
            }
            map.put(i,0);
        }
        list.sort((int[] tmp1 ,int[] tmp2) -> (tmp1[1] - tmp2[1]));
        int[] res = {-100001,100001};
        int cur = 0;
        int left = 0;
        int right = 0;
        int len = list.size();
        while (left < len && right < len){
            while(right < len){
                int[] arr = list.get(right);
                if(0 == map.get(arr[0]) ){
                    map.put(arr[0],1);
                    ++cur;
                }else{
                    map.put(arr[0],map.get(arr[0]) + 1);
                }
                if(cur >= rows){
                    break;
                }
                ++right;
            }
            while(cur >= rows){
                int[] arr = list.get(left);
                map.put(arr[0],map.get(arr[0]) - 1);
                if(0 == map.get(arr[0])){
                    --cur;
                    break;
                }
                ++left;
            }
            if(left < len && right < len && list.get(right)[1] - list.get(left)[1] < res[1] - res[0]){
                res[0] = list.get(left)[1];
                res[1] = list.get(right)[1];
            }
            ++left;
            ++right;
        }
        return res;
    }


    public static void main(String[] args) {
        SmallestRange_632 smallestRange_632 = new SmallestRange_632();
        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(Arrays.asList(4,10,15,24,26));
        tmp.add(Arrays.asList(0,9,12,20));
        tmp.add(Arrays.asList(5,18,22,30));

        System.out.println(smallestRange_632.smallestRange(tmp));
    }

}

/*
You have k lists of sorted integers in ascending order.
Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>.
 And after you reset the code template, you'll see this point.

 */
