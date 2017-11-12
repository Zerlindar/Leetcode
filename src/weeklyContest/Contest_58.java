package weeklyContest;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.annotation.Target;
import java.util.*;

/**
 * Created by sunyongfeng on 2017/11/12.
 */
public class Contest_58 {

    public static void main(String[] args) {
        Contest_58 contest_58 = new Contest_58();
        String s = "abcdebdde";
        String t = "bde";
        System.out.println(contest_58.minWindow(s,t));

    }



    public String minWindow(String S, String T) {
        Set<Character> target = new HashSet<>();
        for(char c : T.toCharArray()){
            target.add(c);
        }
        int len = S.length();
        Map<Character,Integer> exists = new HashMap<>();
        int start = 0 ;
        int end = 0;
        String res = "";
        while(end < len){
            Character c = S.charAt(end);
            if(target.contains(c)){
                exists.put(c,exists.getOrDefault(c,0) + 1);
            }
            if(target.size() == exists.keySet().size()){
                while(start < end){
                    Character del = S.charAt(start);
                    if(target.contains(del) ){
                        exists.put(del,exists.get(del) - 1);
                        if(exists.get(del) == 0){
                            if(res.length() == 0 || end + 1 - start < res.length()){
                                res = S.substring(start,end + 1);
                            }
                            exists.remove(del);
                            ++start;
                            break;
                        }
                    }
                    ++start;
                }
            }
            ++end;
        }
        return res;
    }


    public String countOfAtoms(String formula) {
        if(formula.contains("(")){
            int len = formula.length();
            int start = formula.lastIndexOf("(");
            int end = start + 1;
            while(end < len && formula.charAt(end) != ')'){
                ++end;
            }
            int num = 1;
            int tmp = end + 1;
            String s = "";
            while(tmp < len && formula.charAt(tmp) >= '0' && formula.charAt(tmp) <= '9'){
                s = s + formula.charAt(tmp++);
            }
            if(s.length() > 0){
                num = Integer.parseInt(s);
            }
            String left = "";
            String right = "";
            if(start > 0){
                left = formula.substring(0,start);
            }
            if(tmp < len){
                right = formula.substring(tmp,len);
            }
            return countOfAtoms(left + helper(formula.substring(start + 1,end),num) + right);
        }else{
           return helper(formula,1);
        }
    }


    private String helper(String formula, int num){
        Map<String,Integer> res = getMap(formula,num);
        String resStr  = "";
        for(String key : res.keySet()){
            resStr = resStr + key + (res.get(key) == 1 ? "" : res.get(key)) ;
        }
        return resStr;
    }

    private Map<String,Integer> getMap(String formula,int num){
        Map<String,Integer> res = new TreeMap<>();
        char[] chars = formula.toCharArray();
        int len = chars.length;
        int i = 0;
        while(i < len){
            String s = "";
            int tmp = 1;
            s = s + chars[i++];
            while(i < len && chars[i] >= 'a' && chars[i] <= 'z'){
                s = s + chars[i++];
            }
            String numsStr = "";
            while(i < len && chars[i] >= '0' && chars[i] <= '9'){
                numsStr = numsStr + chars[i++];
            }
            if(numsStr.length() > 0){
                tmp = Integer.parseInt(numsStr);
            }
            res.put(s,res.getOrDefault(s,0) + tmp * num);
        }
        return res;
    }





    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if(k == 1){
            res[0] = root;
            return res;
        }
        ListNode cur = root;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            ++len;
        }
        int num1 = len / k;
        int num2 = len % k;
        int start1 = 0;
        int start2 = 0;
        cur = root;
        int i = 0;
        for(; i < k && cur != null ; ++i){
            res[i] = cur;
            ListNode tail = cur;
            start1 = 0;
            while(start1 < num1){
                tail = cur;
                cur = cur.next;
                ++start1;
            }
            if(start2 < num2){
                tail = cur;
                cur = cur.next;
                ++start2;
            }
            tail.next = null;
        }
        while(i  < k){
            res[i++] = null;
        }
        return res;
    }



    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int[] tmp = new int[len + 1];
        tmp[0] = nums[0];
        for(int i = 1 ; i < len ; ++i){
            tmp[i] = tmp[i - 1] + nums[i];
        }
        if(len > 1 && tmp[len - 1] - tmp[0] == 0){
            return 0;
        }
        if(len >= 2 && tmp[len - 2] == 0){
            return len - 1;
        }

        for(int i = 1 ;i < len - 1; ++i){
            if(tmp[i - 1] == tmp[len - 1] - tmp[i]){
                return i ;
            }
        }
        return - 1;
    }
}
