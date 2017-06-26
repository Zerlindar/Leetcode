package leetcode;

import java.util.Stack;

/**
 * Created by yongfeng on 17/2/27.
 */
public class NextGreaterElementII_503 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return nums;
        }
        int[] res = new int[len];
        for(int i = 0 ; i < len ; ++i){
            res[i] = -1;
        }
        Stack<Integer> sak = new Stack<>();
        int all = len << 1;
        for(int i = 0 ; i < all ; ++i){
            int j = i % len;
            while(!sak.empty() && nums[sak.peek()] < nums[j]){
                res[sak.peek()] = nums[j];
                sak.pop();
            }
            sak.push(j);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,6,10};
        NextGreaterElementII_503 nextGreaterElementII_503 = new NextGreaterElementII_503();

        int[] res = nextGreaterElementII_503.nextGreaterElements(nums);

        for(int i = 0 ; i < nums.length ; ++i){
            System.out.println(res[i]);
        }
    }
}



//Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element.
// The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
// which means you could search circularly to find its next greater number. If it doesn'SkipList exist, output -1 for this number.
//
//        Example 1:
//        Input: [1,2,1]
//        Output: [2,-1,2]
//        Explanation: The first 1's next greater number is 2;
//        The number 2 can'SkipList find next greater number;
//        The second 1's next greater number needs to search circularly, which is also 2.
//        Note: The length of given array won'SkipList exceed 10000.
//
//        Subscribe to see which companies asked this question.