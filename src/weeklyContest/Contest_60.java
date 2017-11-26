package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/11/26.
 */
public class Contest_60 {

    public static void main(String[] args) {
        Contest_60 contest_60 = new Contest_60();
//        int[][] images = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        int[][] res = contest_60.floodFill(images,1,1,2);
//        System.out.println(res);

//        String[] words1 = new String[]{"great", "acting", "skills"};
//        String[] words2 = new String[]{"good", "drama", "talent"};
//        String[][] pairs = new String[][]{{"great", "fine"},{"acting","drama"},{"skills","talent"},{"great", "good"}};
//
//        boolean res = contest_60.areSentencesSimilar(words1,words2,pairs);
//        System.out.println(res);

        int[] asteroids = new int[]{-2,-2,1,-2};
        int[] res = contest_60.asteroidCollision(asteroids);

        System.out.println(res);


    }


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid < 0){
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.add(asteroid);
                }else{
                    boolean need = false;
                    while(!stack.isEmpty()){
                        int top = stack.peek();
                        if(top > 0 && top < -asteroid){
                            stack.pop();
                            need = true;
                        }else if(top > 0 && top == -asteroid){
                            need = false;
                            stack.pop();
                            break;
                        }else if(top > 0 && top > -asteroid){
                            need = false;
                            break;
                        }else{
                            need = true;
                            break;
                        }
                    }
                    if(need){
                        stack.add(asteroid);
                    }
                }
            }else if(asteroid > 0){
                stack.add(asteroid);
            }
        }
        Stack<Integer> tmp = new Stack<>();
        while(!stack.isEmpty()){
            tmp.add(stack.pop());
        }
        int[] resArr = new int[tmp.size()];
        int i = 0;
        while(!tmp.isEmpty()){
            resArr[i++] = tmp.pop();
        }

        return resArr;

    }


    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int len1 = words1.length;
        int len2 = words2.length;
        if(len1 != len2){
            return false;
        }
        Map<String,Set<String>> map = new HashMap<>();
        for(String[] strings : pairs){
            if(map.get(strings[0]) == null){
                map.put(strings[0],new HashSet<>());
            }
            if(map.get(strings[1]) == null){
                map.put(strings[1],new HashSet<>());
            }
            map.get(strings[0]).add(strings[1]);
            map.get(strings[1]).add(strings[0]);
        }

        for(int i = 0 ; i < len1 ; ++i){
            if(words1[i].equals(words2[i]) ||
                    (map.getOrDefault(words1[i],new HashSet<>()).contains(words2[i])
                            && map.getOrDefault(words2[i],new HashSet<>()).contains(words1[i])
                    )){
                continue;
            }else{
                return false;
            }
        }
        return true;

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        if(rows == 0){
            return image;
        }
        int columns = image[0].length;
        int[][] changed = new int[rows][columns];
        helper(image,sr,sc,newColor,changed,rows,columns,image[sr][sc]);
        return image;
    }


    private void helper(int[][] images,int sr,int sc,int newColor,int[][] used,int rows,int columns,int old){
        images[sr][sc] = newColor;
        used[sr][sc] = 1;
        int[][] tmp = new int[][]{{1,0,},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i < 4 ; ++i){
            int xx = sr + tmp[i][0];
            int yy = sc + tmp[i][1];
            if(xx >= 0 && xx < rows && yy >=0 && yy < columns && used[xx][yy] == 0 && images[xx][yy] == old){
                helper(images,xx,yy,newColor,used,rows,columns,old);
            }
        }
    }

}
