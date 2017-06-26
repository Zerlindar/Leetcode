package leetcode;

/**
 * Created by sunyongfeng on 2017/6/9.
 */
public class ArrayNesting_565 {
    public int arrayNesting(int[] nums) {
        if(null == nums){
            return 0;
        }
        int len = nums.length;
        boolean[] cnt = new boolean[len];
        int res = 0;
        for(int i = 0 ; i < len ; ++i){
            if(cnt[i]){
                continue;
            }
            int tmp = 0;
            for(int j = i ; !cnt[j] ;){
                ++tmp;
                cnt[j] = true;
                j = nums[j];
            }
            res = Math.max(res,tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayNesting_565 arrayNesting_565 = new ArrayNesting_565();
        int[] nums = {0,1,2};
        System.out.println(arrayNesting_565.arrayNesting(nums));
    }
}


/**
 * A zero-indexed array A consisting of N different integers is given.
 * The array contains all integers in the range [0, N - 1].

 Sets S[K] for 0 <= K < N are defined as follows:

 S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

 Sets S[K] are finite for each K and should NOT contain duplicates.

 Write a function that given an array A consisting of N integers,
 return the size of the largest set S[K] for this array.

 Example 1:
 Input: A = [5,4,0,3,1,6,2]
 Output: 4
 Explanation:
 A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

 One of the longest S[K]:
 S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 Note:
 N is an integer within the range [1, 20,000].
 The elements of A are all distinct.
 Each element of array A is an integer within the range [0, N-1].
 */
