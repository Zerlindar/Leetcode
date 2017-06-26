package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yongfeng on 17/3/3.
 */
public class FindKPairswithSmallestSums_373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        List<int[]> res = new ArrayList<>();
        if(len1 == 0 || len2 == 0){
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(len1 * len2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for(int i = 0 ; i < len1; ++i){
            for(int j = 0 ; j < len2; ++j){
                int[] tmp = {nums1[i],nums2[j]};
                pq.add(tmp);
            }
        }
        int cnt = 0 ;
        while(cnt < k && cnt++ < len1 * len2){
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        FindKPairswithSmallestSums_373 findKPairswithSmallestSums_373 = new FindKPairswithSmallestSums_373();
        int nums1[] = {1,1,2};
        int nums2[] = {1,2,3};
        List<int[]> res = findKPairswithSmallestSums_373.kSmallestPairs(nums1,nums2,10);

        System.out.println(res);
    }

}


/**
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 *
 */