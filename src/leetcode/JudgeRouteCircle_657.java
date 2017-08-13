package leetcode;

/**
 * Created by sunyongfeng on 2017/8/13.
 */
public class JudgeRouteCircle_657 {
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
}

/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
 */