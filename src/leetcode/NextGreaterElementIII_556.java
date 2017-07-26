package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/7/26.
 */
public class NextGreaterElementIII_556 {

    public int nextGreaterElement(int n) {
        List<Integer> tmp = new ArrayList<>();
        long max = -1;
        while(n != 0){
            int m = n % 10 ;
            n = n / 10;
            if(m < max){
                long min = max + 1;
                int len = tmp.size();
                int pos = 0;
                for(int i = len - 1 ; i >= 0 ; --i){
                    if(tmp.get(i) > m && tmp.get(i) <= min){
                        pos = i;
                        min = tmp.get(i);
                    }
                }
                long res = n * 10 + tmp.get(pos);
                tmp.set(pos,m);
                tmp.sort((a,b) -> (a - b));
                for(Integer num : tmp){
                    res = res * 10 + num;
                }
                return res > Integer.MAX_VALUE ? -1 : (int)res;
            }else{
                max = m ;
                tmp.add(m);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        NextGreaterElementIII_556 nextGreaterElementIII_556 = new NextGreaterElementIII_556();
        System.out.println(nextGreaterElementIII_556.nextGreaterElement(1999999999));
    }

}


/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21
Example 2:
Input: 21
Output: -1
 */