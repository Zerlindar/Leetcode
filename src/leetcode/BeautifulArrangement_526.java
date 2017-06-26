package leetcode;

/**
 * Created by yongfeng on 17/2/21.
 */


/**
 * Suppose you have N integers from 1 to N.
 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

 The number at the ith position is divisible by i.
 i is divisible by the number at the ith position.
 Now given N, how many beautiful arrangements can you construct?

 Example 1:
 Input: 2
 Output: 2
 Explanation:

 The first beautiful arrangement is [1, 2]:

 Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

 The second beautiful arrangement is [2, 1]:

 Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 Note:
 N is a positive integer and will not exceed 15.
 Subscribe to see which companies asked this question.
 */


public class BeautifulArrangement_526 {


    public void helper(int[] cnt,int curNum,int N){
        if(curNum == 1){
            ++cnt[0] ;
            return ;
        }
        for(int i = 1; i <= N ; ++ i){
            if(cnt[i] == 0 && (curNum % i == 0 || i % curNum == 0)){
                cnt[i] = 1;
                helper(cnt,curNum - 1,N);
                cnt[i] = 0;
            }
        }
    }


    public int countArrangement(int N) {
        if(N == 0 || N == 1){
            return N;
        }

        int[] cnt = new int[N+1];
        for(int i = 0 ; i <= N ; ++i){
            cnt[i] = 0;
        }
        helper(cnt,N,N);
        return cnt[0];
    }


    public static void main(String[] args) {
        BeautifulArrangement_526 beautifulArrangement_526 = new BeautifulArrangement_526();
        System.out.println(beautifulArrangement_526.countArrangement(3));
    }

}
