package leetcode;

/**
 * Created by yongfeng on 17/3/31.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(len == 0){
            return -1;
        }
        int start = 0;
        int amoutGas = 0;
        int needGas = 0;
        for(int i = 0 ; i < len ; ++i){
            amoutGas += (gas[i] - cost[i]);
            if(amoutGas < 0){
                needGas += amoutGas;
                start = i + 1 ;
                amoutGas = 0;
            }
        }
        return amoutGas + needGas >= 0 ? start : -1;
    }


    public static void main(String[] args) {
        GasStation_134 gasStation_134 = new GasStation_134();
        int[] gas = {99,98,97,100};
        int[] cost = {100,100,100,97};
        System.out.println(gasStation_134.canCompleteCircuit(gas,cost));
    }

}


/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).

You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


在环形路线上一共有N个加油站，每个加油站的存储容量为gas[i].你有一辆汽油无限存储的汽车，如果你从加油站i到下一站（i+1），你需要

消耗汽油cost[i]  你从某一个加油站开始你的旅程，但是你的汽车里没有任何的汽油。

如果你能沿着环形路线旅游一遍，返回你开始旅游的加油站的下标否则返回-1

注意：

解决方案唯一
 */
