package weeklyContest;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/9/17.
 */
public class Contest_50 {


    public static void main(String[] args) {
        String s = "(())((())()()()(()(())())())()()((()())((()))(**";
        Contest_50 contest_50 = new Contest_50();
        System.out.println(contest_50.judgePoint24(new int[]{4,1,8,7}));
    }

    public boolean judgePoint24(int[] nums){
        return false;
    }




    public boolean helper(int[] nums) {
        Map<String,Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < 4 ; ++i){
            Set<Integer> tmp = new HashSet<>();
            tmp.add(nums[i]);
            map.put(getKey(i,i),tmp);
        }
        for(int i = 1 ; i < 4 ; ++i){
            for(int start = 0; start + i < 4 ; ++ start){
                int end = start + i;
                String key = getKey(start,end);
                Set<Integer> tmp = new HashSet<>();
                for(int k = start; k < end; ++k){
                    String leftKey = getKey(start,k);
                    String rifhtKey = getKey(k + 1 ,end);
                    Set<Integer> lftV = map.get(leftKey);
                    Set<Integer> rightV = map.get(rifhtKey);
                    for(Integer num1 : lftV){
                        for(Integer num2 : rightV){
                            tmp.addAll(getRes(num1,num2));
                        }
                    }
                }
                map.put(key,tmp);
            }
        }
        return map.get("0-3").contains(24);
    }

    private Set<Integer> getRes(Integer num1 ,Integer num2){
        Set<Integer> res = new HashSet<>();
        res.add(num1 + num2);
        res.add(num1 - num2);
        if(num2 != 0){
            res.add(num1 / num2);
        }
        res.add(num1 * num2);
        return res;

    }
    private String getKey(Integer start,Integer end){
        return start + "-" + end;
    }



    public boolean checkValidString(String s) {
        return helper(s,new Stack<Integer>());
    }

    private boolean helper(String s,Stack<Integer> stack){
        if(s == null && stack.isEmpty()){
            return true;
        }
        int len = s.length();
        Stack<Integer> starPos = new Stack<>();
        for(int i = 0 ; i < len ;++ i){
            Character c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == '*'){
                starPos.push(i);
            }else{
                if(stack.isEmpty()){
                    if(starPos.size() <= 0){
                        return false;
                    }else{
                        starPos.pop();
                    }
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            if(stack.size() > starPos.size()){
                return false;
            }
            while(!stack.isEmpty() && !starPos.isEmpty()){
                if(stack.pop() < starPos.pop()){
                    continue;
                }else{
                    return false;
                }
            }
            return stack.size() <= starPos.size();
        }

    }

    private void copyStack(Stack<Character> origin,Stack<Character> target){
        if(origin.isEmpty()){
            target = new Stack<>();
        }
        target.clear();
        Stack<Character> tmp = new Stack<>();
        while(!origin.isEmpty()){
            tmp.push(origin.pop());
        }
        while(!tmp.isEmpty()){
            origin.push(tmp.peek());
            target.push(tmp.pop());
        }
    }




    class MapSum {

        private Map<String,Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int sum = 0;
            Set<String> keySet = map.keySet();
            for(String s : keySet){
                if(s.startsWith(prefix)){
                    sum += map.get(s);
                }
            }
            return sum;
        }
    }

    public boolean validPalindrome(String s) {
        if(s == null){
            return true;
        }
        int len = s.length();
        if(len == 1){
            return true;
        }
        int left = 0 ;
        int rifht = len - 1;
        while(left  < rifht){
            if(s.charAt(left) == s.charAt(rifht)){
                ++left;
                --rifht;
            }else{
                return helper(s.substring(left,rifht)) || helper(s.substring(left + 1,rifht + 1));
            }
        }
        return true;

    }


    private boolean helper(String s){
        if(s == null){
            return true;
        }
        int len = s.length();
        if(len == 1){
            return true;
        }
        int left = 0 ;
        int right = len - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                ++left;
                --right;
            }else{
                return false;
            }
        }
        return true;
    }

}
