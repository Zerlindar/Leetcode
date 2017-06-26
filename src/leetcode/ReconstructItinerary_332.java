package leetcode;

import java.util.*;

/**
 * Created by yongfeng on 17/4/21.
 */
public class ReconstructItinerary_332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,List<String>> map = new HashMap<>();
        int len = tickets.length;
        if(0 == len){
            return new ArrayList<>();
        }
        for(int i = 0 ; i < len ; ++i){
            if(null == map.get(tickets[i][0])){
                List<String> tmp = new ArrayList<>();
                tmp.add(tickets[i][1]);
                map.put(tickets[i][0],tmp);
            }else {
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
        }

        List<String> res = new ArrayList<>();
        String startPoint = "JFK";
        Stack<String> stack = new Stack<>();
        stack.push(startPoint);
        while(!stack.isEmpty()){
            startPoint = stack.peek();
            if(null == map.get(startPoint) || 0 == map.get(startPoint).size()){
                res.add(startPoint);
                stack.pop();
            }else{
                stack.push(map.get(startPoint).get(0));
                map.get(startPoint).remove(0);
            }
        }
        Collections.reverse(res);
        return res;
    }



    public static void main(String[] args) {
        ReconstructItinerary_332 reconstructItinerary_332 = new ReconstructItinerary_332();
        String[][] strings = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        reconstructItinerary_332.findItinerary(strings);
    }
}


/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Subscribe to see which companies asked this question.
 */