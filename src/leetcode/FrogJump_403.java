package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yongfeng on 16/9/20.
 */
public class FrogJump_403 {



    public static boolean canCross(int[] stones) {
        int len = stones.length;
        if(len == 0 || len == 1){
            return true;
        }
        if(len == 2){
            if(stones[1] -stones[0] ==1){
                return true;
            }else{
                return false;
            }
        }

        Map<Integer,Set<Integer>> cnt = new HashMap<>();
        for(int i = 1; i< len ; ++i){
            Set<Integer> set = new HashSet<>();
            cnt.put(i,set);
        }

        cnt.get(1).add(1);
        cnt.get(1).add(2);

        for(int i = 1 ; i < len-1; ++i){
            Set<Integer> set = cnt.get(i);
            int tmp = 0;
            for(Integer step : set){
                for(int j = i + 1; j < len; ++ j){

                    if(stones[i] + step ==stones[len-1]){
                        return  true;
                    }
                    if(stones[i] + step == stones[j]){
                        cnt.get(j).add(step-1);
                        cnt.get(j).add(step);
                        cnt.get(j).add(step+1);
                        tmp = 1;
                    }
                    if(stones[i] + step < stones[j]){
                        break;
                    }
                }
            }
            if(tmp == 0){
                return false;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int[] stons ={0,1,3,4,5,7,9,10,12};
        System.out.println(canCross(stons));
    }



}

//
//A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
//        Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
//
//        If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
//
//        Note:
//
//        The number of stones is ≥ 2 and is < 1,100.
//        Each stone's position will be a non-negative integer < 231.
//        The first stone's position is always 0.




//
//Example 1:
//
//        [0,1,3,5,6,8,12,17]
//
//        There are a total of 8 stones.
//        The first stone at the 0th unit, second stone at the 1st unit,
//        third stone at the 3rd unit, and so on...
//        The last stone at the 17th unit.
//
//        Return true. The frog can jump to the last stone by jumping
//        1 unit to the 2nd stone, then 2 units to the 3rd stone, then
//        2 units to the 4th stone, then 3 units to the 6th stone,
//        4 units to the 7th stone, and 5 units to the 8th stone.
//        Example 2:
//
//        [0,1,2,3,4,8,9,11]
//
//        Return false. There is no way to jump to the last stone as
//        the gap between the 5th and 6th stone is too large.
