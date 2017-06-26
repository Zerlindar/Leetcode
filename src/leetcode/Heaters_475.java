package leetcode;

import java.util.Arrays;

/**
 * Created by yongfeng on 17/3/13.
 */
public class Heaters_475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int lenOfHouseArr = houses.length;
        int lenOfHeatersArr = heaters.length;
        if(houses[0] >= heaters[lenOfHeatersArr - 1]){
            return houses[lenOfHouseArr - 1] - heaters[0];
        }
        if(houses[lenOfHouseArr - 1] <= heaters[0]){
            return heaters[0] - houses[0];
        }
        int res = 0 ;
        for(int i = 0, j = 0  ; i < lenOfHouseArr ; ++i){
            while( j < lenOfHeatersArr - 1 && (Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i]))){
                ++j;
            }
            res  = Math.max(res,Math.abs(heaters[j] - houses[i]));
        }
        return res;
    }

}




/*
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
Subscribe to see which companies asked this question.
 */