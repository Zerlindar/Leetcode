package weeklyContest;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/11/19.
 */
public class Contest_59 {

    public static void main(String[] args) {
        Contest_59 contest_59 = new Contest_59();

//        List<Integer> res = contest_59.selfDividingNumbers(10,22);

    }



//    public int countPalindromicSubsequences(String S) {
//        List<List<Integer>> tmp = new ArrayList<>();
//        for(int i = 0 ; i < 4 ; ++i){
//            tmp.add(new ArrayList<>());
//        }
//        char[] chars = S.toCharArray();
//        int len = chars.length;
//        for(int i = 0 ; i < len ; ++i){
//            tmp.get(chars[i] - 'a').add(i);
//        }
//        int all = 0;
//        for(int i = 0 ; i < 4 ; ++i){
//            all += tmp.get(i).size();
//        }
//
//    }




    static  class  MyCalendarTwo {
        private List<int[]> timers;


        public MyCalendarTwo() {
            timers = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            if(timers.size() == 0){
                int[] tmp = new int[2];
                tmp[0] = start;
                tmp[1] = end;
                timers.add(tmp);
                return true;
            }else{
                List<int[]> newInterval = new ArrayList<>();
                for(int[] timer : timers){
                    if(start <= timer[0] && end >= timer[1]){
                       int[] tmp = new int[2];
                       tmp[0] = timer[0];
                       tmp[1] = timer[1];
                       newInterval.add(tmp);
                    }else if(start <= timer[0] && end > timer[0]){
                        int[] tmp = new int[2];
                        tmp[0] = timer[0];
                        tmp[1] = end;
                        newInterval.add(tmp);
                    }else if(end >= timer[1] && start < timer[1]){
                        int[] tmp = new int[2];
                        tmp[0] = start;
                        tmp[1] = timer[1];
                        newInterval.add(tmp);
                    }else if(start >= timer[0] && end <= timer[1]){
                        int[] tmp = new int[2];
                        tmp[0] = start;
                        tmp[1] = timer[1];
                        newInterval.add(tmp);
                    }
                }
                if(newInterval.size() < 2){
                    int[] tmp = new int[2];
                    tmp[0] = start;
                    tmp[1] = end;
                    timers.add(tmp);
                    return true;
                }else{
                    if(helper(newInterval)){
                        int[] tmp = new int[2];
                        tmp[0] = start;
                        tmp[1] = end;
                        timers.add(tmp);
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }


        private boolean helper(List<int[]> list){
            int len = list.size();
            for(int i = 0 ; i < len ; ++i){
                int num = 0;
                int[] judge = list.get(i);
                for(int j = i + 1; j < len ; ++j){
                    int[] tmp = list.get(j);
                    if(tmp[1] <= judge[0] || tmp[0] >= judge[1]){
                        continue;
                    }else{
                        ++num;
                        if(num >= 1){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }




    static class MyCalendar {

        private List<int[]> timers;

        public MyCalendar() {
            timers = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            if(timers.size() == 0){
                int[] tmp = new int[2];
                tmp[0] = start;
                tmp[1] = end;
                timers.add(tmp);
                return true;
            }else{
                for(int[] timer : timers){
                    if(end <= timer[0] || start >= timer[1]){
                        continue;
                    }else{
                        return false;
                    }
                }
                int[] tmp = new int[2];
                tmp[0] = start;
                tmp[1] = end;
                timers.add(tmp);
                return true;
            }
        }
    }



    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left ; i <= right ; ++i){
            if(isSelef(i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean isSelef(int num){
        if(num == 0){
            return false;
        }
        if(num >= 1 && num <= 9){
            return true;
        }
        int tmp = num;
        while(tmp != 0){
            int devided = tmp%10;
            if(devided == 0 || num % devided != 0){
                return false;
            }
            tmp = tmp/10;
        }
        return true;
    }





}
