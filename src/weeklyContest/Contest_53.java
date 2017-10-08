package weeklyContest;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/10/8.
 */
public class Contest_53 {

    public static void main(String[] args) {
        Contest_53 contest_53 = new Contest_53();
//        int[][] tmp = new int[][]{
//                {1,1,0,1,1},
//                {1,0,0,0,0},
//                {0,0,0,0,1},
//                {1,1,0,1,1},
//        };

        String[] tmp = new String[]{"with", "example", "science"};
        String target = "thehat";

        System.out.println(contest_53.minStickers(tmp,target));
    }

    private Map<Character,Integer> targetSet = new HashMap<>();
    private Map<String,Set<Character>> stringSetMap = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        for(Character character : target.toCharArray()){
            targetSet.put(character,targetSet.getOrDefault(character,0) + 1);
        }
        Set<Character> allChar = new HashSet<>();
        for(String s: stickers){
            Set<Character> tmp = new HashSet<>();
            for(Character character : s.toCharArray()){
                allChar.add(character);
                tmp.add(character);
            }
            stringSetMap.put(s,tmp);
        }
        if(!allChar.containsAll(targetSet.keySet())){
            return -1;
        }
        List<String> strikeList = Arrays.asList(stickers);
        return heler(strikeList,target,Integer.MIN_VALUE);
    }

    private int heler(List<String> strings,String target,int min){
        if(strings.size() == 0){
            return Integer.MAX_VALUE;
        }
        int res = heler(strings.subList(1,strings.size()),target,min);
        int num = 1;
        while(true){
            boolean canUse  = true;
            for(Character c : strings.get(0).toCharArray()){
                if(targetSet.containsKey(c)  ){
                    canUse = false;
                }
            }
            if(canUse){
                for(Character c : strings.get(0).toCharArray()){
                    if(targetSet.containsKey(c) ){
                        targetSet.put(c,targetSet.get(c) - 1);
                    }
                }
                res = Math.min(res,heler(strings,target,res) + num);
            }else{
                break;
            }
            ++num;
        }
        return res;
    }




    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visted = new int[rows][cols];
        List<List<int[]>> alllands = new ArrayList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (visted[i][j] == 1 || grid[i][j] == 0) {
                    continue;
                }
                List<int[]> tmp = new ArrayList<>();
                dfs(i,j,grid,visted,rows,cols,tmp);
                Collections.sort(tmp, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0] == o2[0]){
                            return o1[1]-o2[1];
                        }else{
                            return o1[0]-o2[0];
                        }
                    }
                });
                alllands.add(tmp);
            }
        }
        Collections.sort(alllands, new Comparator<List<int[]>>() {
            @Override
            public int compare(List<int[]> o1, List<int[]> o2) {
                return o1.size() - o2.size();
            }
        });

        int len = alllands.size();
        int[] del = new int[len];
        int res = 0;
        for(int i = 0 ; i < len ; ++i){
            if(del[i] == 1){
                continue;
            }
            for(int j = i + 1; j < len ; ++j){
                if(alllands.get(j).size() != alllands.get(i).size()){
                    break;
                }
                if(del[j] == 1){
                    continue;
                }
                if(equal(alllands.get(i),alllands.get(j))){
                    del[j] = 1;
                }
            }
            ++res;
        }
        return res;

    }

    private boolean equal(List<int[]> list1,List<int[]> list2){
        int len = list1.size();
        if(len == 0 || len == 1){
            return true;
        }
        int dist1 = list1.get(0)[0] - list2.get(0)[0];
        int dist2 = list1.get(0)[1] - list2.get(0)[1];
        for(int i = 1 ; i < len ; ++i){
            if(list1.get(i)[0] - list2.get(i)[0] != dist1 ||
                    list1.get(i)[1] - list2.get(i)[1] != dist2){
                return false;
            }
        }
        return true;
    }




    public void dfs(int x, int y, int[][] grid, int[][] visted, int rows, int cols,List<int[]> list) {
        visted[x][y] = 1;
        list.add(new int[]{x,y});
        if (x - 1 >= 0 && visted[x - 1][y] == 0 && grid[x - 1][y] == 1) {
            dfs(x - 1, y, grid, visted, rows, cols,list);
        }
        if (x + 1 < rows && visted[x + 1][y] == 0 && grid[x + 1][y] == 1) {
            dfs(x + 1, y, grid, visted, rows, cols,list);
        }
        if (y - 1 >= 0 && visted[x][y - 1] == 0 && grid[x][y - 1] == 1) {
            dfs(x, y - 1, grid, visted, rows, cols,list);
        }
        if (y + 1 < cols && visted[x][y + 1] == 0 && grid[x][y + 1] == 1) {
            dfs(x, y + 1, grid, visted, rows, cols,list);
        }

    }

//    public int maxAreaOfIsland(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[][] visted = new int[rows][cols];
//        int max = 0;
//        for (int i = 0; i < rows; ++i) {
//            for (int j = 0; j < cols; ++j) {
//                if (visted[i][j] == 1 || grid[i][j] == 0) {
//                    continue;
//                }
//                max = Math.max(dfs(i, j, grid, visted, rows, cols), max);
//            }
//        }
//        return max;
//    }

//    public int dfs(int x, int y, int[][] grid, int[][] visted, int rows, int cols) {
//        visted[x][y] = 1;
//        int res = 1;
//        if (x - 1 >= 0 && visted[x - 1][y] == 0 && grid[x - 1][y] == 1) {
//            res += dfs(x - 1, y, grid, visted, rows, cols);
//        }
//        if (x + 1 < rows && visted[x + 1][y] == 0 && grid[x + 1][y] == 1) {
//            res += dfs(x + 1, y, grid, visted, rows, cols);
//        }
//        if (y - 1 >= 0 && visted[x][y - 1] == 0 && grid[x][y - 1] == 1) {
//            res += dfs(x, y - 1, grid, visted, rows, cols);
//        }
//        if (y + 1 < cols && visted[x][y + 1] == 0 && grid[x][y + 1] == 1) {
//            res += dfs(x, y + 1, grid, visted, rows, cols);
//        }
//        return res;
//
//    }

    public boolean hasAlternatingBits(int n) {
        List<Integer> tmp = new ArrayList<>();
        while (n != 0) {
            tmp.add(n % 2);
            n = n / 2;
        }
        if (tmp.size() == 0 || tmp.size() == 1) {
            return true;
        }

        int num1 = tmp.get(0);
        int num2 = tmp.get(1);
        if (num1 == num2) {
            return false;
        }
        int len = tmp.size();

        for (int i = 2; i < len; ++i) {
            if (i % 2 == 0 && num1 != tmp.get(i)) {
                return false;
            }
            if (i % 2 == 1 && num2 != tmp.get(i)) {
                return false;
            }
        }
        return true;
    }
}
