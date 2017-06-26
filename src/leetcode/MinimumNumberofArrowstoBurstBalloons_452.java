package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yongfeng on 16/11/15.
 */



//There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter.
// Since it's horizontal, y-coordinates don'SkipList matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end.
// There will be at most 104 balloons.
//
//        An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
// There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
// The problem is to find the minimum number of arrows that must be shot to burst all balloons.
//
//        Example:
//
//        Input:
//        {[10,16}, [2,8}, [1,6}, [7,12}]
//
//        Output:
//        2
//
//        Explanation:
//        One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons)

public class MinimumNumberofArrowstoBurstBalloons_452 {


    public static int findMinArrowShots(int[][] points) {


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = points.length;

        if(len == 0 || len == 1){
            return len;
        }

        int end = points[0][1];
        int res = 1;

        for(int i =1; i < len ; ++i){
            if(points[i][0] > end){
                ++ res;
                end = points[i][1];
            }else if(points[i][1] < end){
                end = points[i][1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] tmp = {
                {10,16}, {2,8}, {1,6}, {7,12}
        };

        System.out.println(findMinArrowShots(tmp));


    }


}
