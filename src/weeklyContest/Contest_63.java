package weeklyContest;

import javax.activation.MailcapCommandMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunyongfeng on 2017/12/17.
 */
public class Contest_63 {

    public static void main(String[] args) {
        Contest_63 contest_63 = new Contest_63();
        int[] cost = {10, 200, 1};
//        System.out.println(contest_63.minCostClimbingStairs(cost));

        String s = "GrC8950";
        String[] words = {"measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"};
//        System.out.println(contest_63.shortestCompletingWord(s,words));

        int[][] grid =
                {
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,1,1,1},
                        {0,0,0,0}
                };

        System.out.println(contest_63.countCornerRectangles(grid));
    }


    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;
        if(cols == 0){
            return 0;
        }

        boolean[][] used = new boolean[rows][cols];
        int res = 0;
        for(int i = 0 ; i < rows ; ++i){
            for(int j = 0 ; j < cols; ++j){
                if(grid[i][j] == 1){
                    res += helper1(grid,i,j,rows,cols,used);
                }
            }
        }
        for(int i = 0 ; i < rows ; ++i){
            for(int j = 0 ; j < cols; ++j){
                if(grid[i][j] == 1 && !used[i][j]){
                    res += helper2(grid,i,j,rows,cols,used);
                }
            }
        }
        return res;
    }

    private int helper2(int[][] grid,int x,int y,int rows,int cols,boolean[][] used){
        int res = 0;
        for(int xx = 1 ; xx < rows ; ++xx){
            if(x+ xx + xx < rows && y + xx < cols && y - xx >= 0 &&
                    !used[x + xx] [y - xx] && !used[x+ xx][y + xx] && !used[x+xx+xx][y] &&
                    grid[x + xx][y - xx] == 1 && grid[x + xx][y + xx] == 1 && grid[x + xx + xx][y] == 1){
                ++res;
            }
        }
        return res;
    }


    private int helper1(int[][] grid,int x, int y,int rows ,int cols,boolean [][] used){
        int l = 2;
        int res = 0;

        for(int xx = 1 ; xx + x < rows ; ++xx){
            for(int yy = 1 ; yy + y < cols ; ++yy){
                if(grid[x + xx][y] ==1 && grid[x][y+ yy] ==1 && grid[x + xx][y + yy] == 1){
                    used[x + xx][y] = true;
                    used[x ][y + yy] = true;
                    used[x + xx][y + yy] = true;
                    ++res;
                }
            }
        }
        return res;
    }



    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        Map<Character,Integer> origin = new HashMap<>();
        for(char c : licensePlate.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                origin.put(c,origin.getOrDefault(c,0) + 1);
            }
        }
        String res = null;
        for(String s : words){
            char[] tmp = s.toLowerCase().toCharArray();
            int cnt = 0 ;
            Map<Character,Integer> target = new HashMap<>(origin);
            for(char c : tmp){
                if(target.containsKey(c)){
                    target.put(c,target.get(c) - 1);
                    if(target.get(c) == 0){
                        ++cnt;
                    }
                }
            }
            if( cnt == target.keySet().size()){
                if(res == null){
                    res = s;
                }else{
                    res = res.length() <= s.length() ? res : s;
                }
            }

        }
        return res ;


    }


    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] cnt = new int[len + 1];
        cnt[0] = 0;
        cnt[1] = 0;
        for(int i = 2 ; i <= len ; ++i){
            cnt[i] = Math.min(cnt[i - 1] + cost[i - 1] ,cnt[i - 2] + cost[ i - 2]);
        }
        return cnt[len];
    }

    private int helper(int[] cost,int start,int end){
        if(start == end || start == end - 1){
            return cost[start];
        }else if(start > end){
            return 0;
        }
        int tmp1 = cost[start] + helper(cost,start + 1,end );
        int tmp2 = cost[start] + helper(cost,start + 2, end);
        return Math.min(tmp1,tmp2);
    }
}
