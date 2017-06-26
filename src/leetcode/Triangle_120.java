package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/6/8.
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(null == triangle || triangle.size() == 0){
            return 0;
        }
        for(int i = triangle.size() - 2 ; i >= 0 ; --i) {
            for (int j = 0; j <= i; ++j) {
                triangle.get(i).set(j, (triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))));
            }
        }
        return triangle.get(0).get(0);

    }

    public static void main(String[] args) {
        Triangle_120 triangle_120 = new Triangle_120();
        List<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(2);
        List<Integer> tmp2 = new ArrayList<Integer>();
        tmp2.add(3);
        tmp2.add(4);
        List<Integer> tmp3 = new ArrayList<Integer>();
        tmp3.add(6);
        tmp3.add(5);
        tmp3.add(7);
        List<Integer> tmp4 = new ArrayList<Integer>();
        tmp4.add(4);
        tmp4.add(1);
        tmp4.add(8);
        tmp4.add(3);
        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(tmp1);
        tmp.add(tmp2);
        tmp.add(tmp3);
        tmp.add(tmp4);

        triangle_120.minimumTotal(tmp);

    }

}


/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.
 */
