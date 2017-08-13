package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunyongfeng on 2017/6/27.
 */
public class ValidSquare_593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> tmp = new HashSet<>();
        tmp.add(helper(p1,p2));
        tmp.add(helper(p1,p3));
        tmp.add(helper(p1,p4));
        tmp.add(helper(p2,p3));
        tmp.add(helper(p2,p4));
        tmp.add(helper(p3,p4));

        return !tmp.contains(0) && tmp.size() == 2;
    }

    private int helper(int[] p1,int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]) ;
    }

}


/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

 The coordinate (x,y) of a point is represented by an integer array with two integers.

 Example:
 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 Output: True
 Note:

 All the input integers are in the range [-10000, 10000].
 A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 Input points have no order.

 */
