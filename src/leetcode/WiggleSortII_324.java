package leetcode;

/**
 * Created by yongfeng on 17/4/6.
 */
public class WiggleSortII_324 {

    public void wiggleSort(int[] nums) {
        if(null == nums){
            return;
        }
        int len = nums.length;
        if(0 == len || 1 == len){
            return ;
        }
        int idx ;
        int cnt = 0 ;
        int stop;
        int[] tmp = new int[len];
        if(len % 2 == 0){
            idx = getMidPos(nums, len / 2, 0, len - 1) ;
            getMidPos(nums, len / 2 + 1, len / 2, len - 1);
            stop = 0;
        }else{
            idx = getMidPos(nums,len/2 + 1 ,0 ,len - 1);
            tmp[len - 1] = nums[0];
            stop = 1;
        }

        while(idx >= stop){
            tmp[cnt++] = nums[idx];
            tmp[cnt++] = nums[idx + len /2];
            --idx;
        }

        for(int i = 0 ;i < len ; ++ i){
            nums[i] = tmp[i];
        }

        System.out.println(nums);
    }



    public int getMidPos(int[] nums,int n ,int start,int end){
        int idx = partition(nums,start,end);
        if(idx + 1 == n){
            return idx;
        }else if(idx + 1 < n){
            return getMidPos(nums, n, idx + 1, end);
        }else{
            return getMidPos(nums, n, start, idx - 1);
        }
    }


    public int partition(int[] nums,int start,int end){
        int tmp = nums[start];
        while(start < end){
            while(end > start && nums[end] >= tmp){
                --end;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] < tmp){
                ++start;
            }
            nums[end]  = nums[start];
        }
        nums[start] = tmp;

        return start;
    }


    public static void main(String[] args) {
        WiggleSortII_324 wiggleSortII_324 = new WiggleSortII_324();
        int[] nums = {1,1,1,6,6,7,8,6};
        wiggleSortII_324.wiggleSort(nums);

    }
}



/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Subscribe to see which companies asked this question.
 */
