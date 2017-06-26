package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yongfeng on 17/4/11.
 */
public class L01Matrix_542 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if(null == matrix || matrix.size() == 0){
            return matrix;
        }
        int rows = matrix.size();
        int columns = matrix.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < rows ; ++i){
            for(int j = 0 ; j < columns ; ++j){
                if(matrix.get(i).get(j) == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix.get(i).set(j,Integer.MAX_VALUE);
                }
            }
        }
        bfs(queue,matrix,rows,columns);

        return matrix;
    }

    private void bfs(Queue<int[]> queue,List<List<Integer>> matrix,int rows,int columns){
        int[][] deriction = { {0 , 1 } , {0 , -1 }, {1 ,0 }, {-1 ,0 }};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0 ; i < 4; ++i){
                int x = cur[0] + deriction[i][0];
                int y = cur[1] + deriction[i][1];
                if(x < 0 || x >= rows || y < 0 || y >= columns || matrix.get(x).get(y) == 0){
                    continue;
                }
                int tmp = matrix.get(cur[0]).get(cur[1]);
                if(tmp < matrix.get(x).get(y)){
                    queue.offer(new int[]{x,y});
                    matrix.get(x).set(y,tmp + 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        L01Matrix_542 l01Matrix_542 = new L01Matrix_542();
        List<List<Integer>> tmp = new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(0);
        tmp1.add(0);
        tmp1.add(0);
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(0);
        tmp2.add(1);
        tmp2.add(0);
        List<Integer> tmp3 = new ArrayList<>();
        tmp3.add(1);
        tmp3.add(1);
        tmp3.add(1);
        tmp.add(tmp1);
        tmp.add(tmp2);
        tmp.add(tmp3);
        l01Matrix_542.updateMatrix(tmp);
    }

}


/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
Subscribe to see which companies asked this question.
 */