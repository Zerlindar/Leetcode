package weeklyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/8/13.
 */
public class Contest_45 {

    public boolean judgeCircle(String moves) {
        if(null == moves || moves.length() == 0){
            return true;
        }
        char[] tmp = moves.toCharArray();
        int x = 0 ;
        int y = 0;
        for(char c : tmp){
            if(c == 'U'){
                ++x;
            }else if(c == 'D'){
                --x;
            }else if(c == 'L'){
                --y;
            }else if(c == 'R'){
                ++y;
            }
        }

        return x == 0 && y == 0;
    }

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
//        int left = 0;
//        int len = arr.size();
//        int right = len - 1;
//        int mid = 0;
//        while(left <= right){
//            mid = left + (right - left) / 2;
//            if(arr.get(mid) == x){
//                break;
//            }else if(arr.get(mid) < x){
//                left = mid + 1;
//            }else{
//                right = mid - 1;
//            }
//        }
//        if(arr.get(mid) != x){
//            mid = Math.abs(arr.get(mid) )
//        }
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


    public static void main(String[] args) {
        Contest_45 contest_45 = new Contest_45();
        contest_45.findClosestElements(Arrays.asList(new Integer[]{0,0,1,2,3,3,4,7,7,8}),3,5);
    }


}
