package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongfeng on 17/4/2.
 */
public class CreateMaximumNumber_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer,List<Integer>> tmpMap1 = new HashMap<>();
        Map<Integer,List<Integer>> tmpMap2 = new HashMap<>();
        tmpMap1.put(0,new ArrayList<Integer>());
        tmpMap2.put(0, new ArrayList<Integer>());
        initMap(nums1, 0, len1 - 1, tmpMap1, 1,k);
        initMap(nums2, 0, len2 - 1, tmpMap2, 1,k);
        int[] res = null;
        for(int i = 0 ; i <= len1 && i <= k ; ++i){
            if(k - i > len2){
                continue;
            }
            int[] tmp = helper(tmpMap1.get(i),tmpMap2.get(k - i),nums1,nums2,i,k - i);
            if(null == res || !compare(res,tmp)){
                res = tmp;
            }
        }

        return res;

    }

    public int[] helper(List<Integer> posList1,List<Integer> posList2,int[] nums1,int[] nums2,int len1,int len2){
        int[] res = new int[len1+len2];
        int idx = 0;
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            if(nums1[posList1.get(i)] > nums2[posList2.get(j)]){
                res[idx++] = nums1[posList1.get(i++)];
            }else if(nums1[posList1.get(i)] < nums2[posList2.get(j)]){
                res[idx++] = nums2[posList2.get(j++)];
            }else{
                boolean useFirst = false;
                boolean isBreak = false;
                int ii = i + 1 , jj= j + 1;
                while (ii < len1 && jj < len2){
                    if(nums1[posList1.get(ii)] < nums2[posList2.get(jj)]){
                        useFirst = false;
                        isBreak = true;
                        break;
                    }
                    if(nums1[posList1.get(ii)] > nums2[posList2.get(jj)]){
                        useFirst = true;
                        isBreak = true;
                        break;
                    }
                    ++ii;
                    ++jj;
                }
                if(!isBreak){
                    useFirst = ii != len1;
                }
                if(useFirst){
                    res[idx++] = nums1[posList1.get(i)];
                    ++i;
                }else{
                    res[idx++] = nums2[posList2.get(j)];
                    ++j;
                }

            }
        }
        while(i < len1){
            res[idx++] = nums1[posList1.get(i++)];
        }
        while (j < len2){
            res[idx++] = nums2[posList2.get(j++)];
        }
        return res;
    }


    public boolean compare(int[] tmp1 ,int[] tmp2){
        int len = tmp1.length;
        for(int i = 0 ;i < len ; ++i){
            if(tmp2[i] > tmp1[i]){
                return false;
            }
            if(tmp2[i] < tmp1[i]){
                return  true;
            }
        }
        return true;
    }

    public void initMap(int[]nums,int start,int end,Map<Integer,List<Integer>> map,int key,int k){
        if(k < key){
            return;
        }
        if(start > end){
            return;
        }
        int pos = findMaxPos(nums,start,end);
        List<Integer> tmp = new ArrayList<>(map.get(key - 1));
        int len = tmp.size();
        if(len == 0 || tmp.get(len - 1) < pos){
            tmp.add(pos);
        }else{
            for(int i = 0 ; i < len ; ++i){
                if(pos < tmp.get(i)){
                    tmp.add(i,pos);
                    break;
                }
            }
        }
        map.put(key,tmp);
        initMap(nums,pos + 1,end,map,key + 1,k);
        initMap(nums,start,pos - 1,map,key + end - pos + 1,k);
    }

    public int findMaxPos(int[] nums,int start,int end){
        int max = nums[start];
        int pos = start;
        for(int i = start + 1 ; i <= end ; ++i){
            if(nums[i] > max){
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }




    public static void main(String[] args) {
        CreateMaximumNumber_321 createMaximumNumber_321 = new CreateMaximumNumber_321();
        int[] nums1 = {4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2};
        int[] nums2 = {9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3};

        System.out.println(createMaximumNumber_321.maxNumber(nums2,nums1,60));
    }
}



/*
Given two arrays of length m and n with digits 0-9 representing two numbers.
Create the maximum number of length k <= m + n from digits of the two.
The relative order of the digits from the same array must be preserved.
Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

[4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2]
[9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3]
60
 */
