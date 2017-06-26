package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yongfeng on 17/4/1.
 */
public class NonOverlappingIntervals_435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        int len = intervals.length;
        if(len == 0 || len == 1){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }else{
                    return o1.start - o2.start;
                }
            }
        });
        int end = intervals[0].end;
        int res = 0;
        for(int i = 1 ; i < len ; ++i){
            if(intervals[i].start < end){
                ++ res;
                if(intervals[i].end <= end){
                    end =intervals[i].end;
                }
            }else{
                end = intervals[i].end;
            }
        }
        return res;
    }





      static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }


    public static void main(String[] args) {
        NonOverlappingIntervals_435 nonOverlappingIntervals_435 = new NonOverlappingIntervals_435();
        NonOverlappingIntervals_435.Interval[] intervals ={
                new NonOverlappingIntervals_435.Interval(1,2),
                new NonOverlappingIntervals_435.Interval(2,3),
                new NonOverlappingIntervals_435.Interval(3,4),
                new NonOverlappingIntervals_435.Interval(4,5)
//                new NonOverlappingIntervals_435.Interval()
        };
        System.out.println(nonOverlappingIntervals_435.eraseOverlapIntervals(intervals));
    }

}



/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don'SkipList overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don'SkipList need to remove any of the intervals since they're already non-overlapping.

 */