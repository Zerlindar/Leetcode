package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yongfeng on 17/4/4.
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(null == intervals || intervals.size() == 0 || intervals.size() == 1){
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }else{
                    return o1.start - o2.start;
                }
            }
        });

        int len = intervals.size();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1 ; i < len ; ++i){
            if(intervals.get(i).start > end){
                res.add(new Interval(start,end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }else{
                end = intervals.get(i).end > end ? intervals.get(i).end : end;
            }
            if(i == len -1){
                res.add(new Interval(start,end));
            }
        }
        return res ;
    }


    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        List<Interval> tmp = new ArrayList<>();
        tmp.add(new Interval(1,3));
        tmp.add(new Interval(2,6));
        tmp.add(new Interval(8,10));
        tmp.add(new Interval(15,18));
        MergeIntervals_56 mergeIntervals_56 = new MergeIntervals_56();
        mergeIntervals_56.merge(tmp);


    }
}



/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */