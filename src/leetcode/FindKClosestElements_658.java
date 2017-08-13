package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/8/13.
 */
public class FindKClosestElements_658 {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
//
        if(k == 0){
            return new ArrayList<>();
        }
        int pos = 0;
        for(; pos < arr.size() ; ++pos){
            if(arr.get(pos) >= x){
                break;
            }
        }
        if(pos == 0){
            return arr.subList(0,k);
        }else if(pos == arr.size()){
            return arr.subList(arr.size() - k,arr.size());
        }else{
            if(arr.get(pos) != x){
                pos = Math.abs(arr.get(pos) - x) > Math.abs(arr.get(pos - 1) - x) ? pos - 1 : pos;
            }
            List<Integer> leftList = new LinkedList<>();
            List<Integer> rightList = new ArrayList<>();
            leftList.add(arr.get(pos));
            int sum = 1;
            int left = pos - 1;
            int right = pos + 1;
            while(left >= 0 && right < arr.size() && sum < k){
                if(Math.abs(arr.get(left) - x) > Math.abs(arr.get(right) - x)){
                    rightList.add(arr.get(right++));
                    ++sum;
                }else {
                    leftList.add(0, arr.get(left--));
                    ++sum;
                }
            }
            if(sum < k){
                while(left >= 0 && sum < k){
                    leftList.add(0,arr.get(left--));
                    ++sum;
                }
                while(right < arr.size() && sum < k){
                    rightList.add(arr.get(right++));
                    ++sum;
                }
            }
            leftList.addAll(rightList);
            return leftList;
        }
    }
}

/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
 */