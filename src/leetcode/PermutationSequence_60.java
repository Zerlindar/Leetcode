package leetcode;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/7/11.
 */
public class PermutationSequence_60 {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Integer tmp = 1;
        for(int i = 1 ; i <= n ; ++i){
            list.add(i);
            tmp *= i;
            map.put(i,tmp);
        }
        return helper(list,map,k);
    }


    private String helper(List<Integer> list,Map<Integer,Integer> map,int k){
        if(0 == list.size() || 0 == k){
            return "";
        }
        if(1 == k){
            String res = "";
            for(Integer i : list){
                res += String.valueOf(i);
            }
            return res;
        }
        int sum = (map.get(list.size() -1));
        int tmp = (k - 1) / sum;
        String pre = String.valueOf(list.get(tmp));
        list.remove(tmp);
        return pre + helper(list,map,k - (tmp * sum));

    }


    public static void main(String[] args) {
        PermutationSequence_60 permutationSequence_60 = new PermutationSequence_60();
        for(int i = 1; i <= 24 ; ++i){
            System.out.println(permutationSequence_60.getPermutation(4,i));
        }
    }


}


/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */