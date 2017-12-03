package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/12/3.
 */
public class Contest_61 {

    public static void main(String[] args) {
        Contest_61 contest_61 = new Contest_61();


//        int[] tmp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
//
//        int[] res = contest_61.dailyTemperatures(tmp);
//
//        System.out.println(res);


//        int res = contest_61.monotoneIncreasingDigits(42156);
//
//        System.out.println(res);

        int[] nums = new int[]{7,8,8,9,10,10,11};
        int res = contest_61.deleteAndEarn(nums);
        System.out.println(res);
    }


    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(map.get(num) != null){
                map.put(num,map.get(num) + num);
            }else{
                list.add(num);
                map.put(num,num);
            }
        }
        Collections.sort(list);

        return heler(list,map,0,0);
    }

    private int heler(List<Integer> list,Map<Integer,Integer> map,int pos,int pre){

        if(pos >= list.size()){
            return pre;
        }
        int tmp = map.get(list.get(pos));
        int left = map.getOrDefault(list.get(pos) - 1,0);
        int sum = tmp + pre - left + map.getOrDefault(list.get(pos) - 2,0);
        return Math.max(heler(list,map,pos + 1,sum),heler(list,map,pos + 1,pre));
    }


    public int monotoneIncreasingDigits(int N) {
        List<Integer> list = new ArrayList<>();
        while(N != 0){
            list.add(N%10);
            N /=10;
        }
        int len = list.size();
        for(int i = 0 ; i + 1 < len ; ++i){
            if(i + 1 < len && list.get(i+1) <= list.get(i)){
                continue;
            }
            for(int j = 0 ; j <= i; ++j){
                list.set(j,9);
            }
            list.set(i+1,list.get(i+1) - 1);
        }
        int res = 0;
        for(int i = len - 1; i >= 0 ; --i){
            res = res * 10 + list.get(i);
        }
        return res;
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        if(len == 0){
            return res;
        }
        res[len - 1] = 0;
        for(int i = len - 2 ; i >= 0; --i){
            int tmp = 0;
            for(int j = i + 1;j < len ; ++j ){
                if(temperatures[j] > temperatures[i]){
                    tmp = j - i ;
                    break;
                }else{
                    continue;
                }
            }
            res[i] = tmp;
        }
        return res;
    }
}
