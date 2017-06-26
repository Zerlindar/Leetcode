package leetcode;

/**
 * Created by sunyongfeng on 2017/6/7.
 */
public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len < 2){
            return ;
        }
        k = k % len;
        reverseHelper(nums,0,len - k - 1);
        reverseHelper(nums,len-k , len - 1);
        reverseHelper(nums, 0 , len - 1 );
    }

    private void reverseHelper(int[] nums,int start ,int end){

        for(int i = start,j = end; i < j ; ++i , --j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        RotateArray_189 rotateArray_189 = new RotateArray_189();
        rotateArray_189.rotate(nums,3);
        System.out.println(nums);
    }


}


/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
 */