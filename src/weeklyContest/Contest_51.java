package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/9/24.
 */
public class Contest_51 {

    public static void main(String[] args) {
        Contest_51 contest_51 = new Contest_51();
        String s = "20:48";

        //System.out.println(contest_51.nextClosestTime(s));

        int[][] edges = {{1,2},{1,3},{2,3}};

        int[] res  = contest_51.findRedundantConnection(edges);
        System.out.println();
    }

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<flowers.length; i++){
            Integer next = set.higher(flowers[i]);
            Integer prev = set.lower(flowers[i]);

            if (next!=null && next-flowers[i]-1==k)
                return i+1;

            if (prev!=null && flowers[i]-prev-1==k)
                return i+1;

            set.add(flowers[i]);
        }

        return -1;
    }




    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[2010];
        for (int i=0; i<parent.length; i++)
            parent[i] = i;

        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if (find(x,parent) == find(y,parent))
                return edge;
            else
                parent[find(x,parent)] = find(y,parent);
        }

        return null;
    }

    private int find(int x,int[] parent){
        if (x!=parent[x]){
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }


    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        int len = time.length();
        String[] tmp = time.split(":");
        Integer hour = Integer.parseInt(tmp[0]);
        Integer min = Integer.parseInt(tmp[1]);
        for(int i = 0 ; i < len ; ++ i){
            if(time.charAt(i)!= ':'){
                set.add(time.charAt(i) - 48);
            }
        }
        Integer minRes = helper1(min,60,set,false);
        if(null != minRes){
            return getRes(hour,minRes);
        }
        Integer hourRes = helper1(hour,24,set,false);
        if(hourRes == null){
            hourRes = helper1(0,24,set,true);
        }
        minRes = helper1(0,60,set,true);

        if(null != hourRes && null != minRes){
            return getRes(hourRes,minRes);
        }else{
            return time;
        }


    }

    private String getRes(Integer hourRes ,Integer minRes){
        if(hourRes < 10 && minRes < 10){
            return "0" + hourRes + ":0" + minRes;
        }else if(hourRes < 10){
            return "0" + hourRes + ":" + minRes;
        }else if(minRes < 10){
            return hourRes + ":0" + minRes;
        }else{
            return hourRes + ":" + minRes;
        }
    }

    private Integer helper1(Integer input,Integer max ,Set<Integer> set,Boolean canUse){
        int i = input + 1;
        if(canUse){
            i =input;
        }
        for(; i < max ; ++i){
            if(i < 10){
                if(set.contains(0) && set.contains(i)){
                    return i;
                }
            }else{
                if(set.contains(i/10) && set.contains(i%10)){
                    return i;
                }
            }
        }
        return null;
    }



    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for(String op : ops){
            if(op.equals("C")){
                if(list.size() > 0){
                    list.remove(list.size() - 1);
                }
            }else if(op.equals("D")){
                if(list.size() > 0){
                    list.add(list.get(list.size()-1)*2);
                }
            }else if(op.equals("+")){
                if(list.size() == 1){
                    list.add(list.get(0));
                }else if(list.size() > 1){
                    list.add(list.get(list.size() - 1) + list.get(list.size() -2));
                }
            }else{
                list.add(Integer.valueOf(op));
            }
        }
        int res = 0;
        for(Integer num : list){
            res += num;
        }
        return res;
    }

}
