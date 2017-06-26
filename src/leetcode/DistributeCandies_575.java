package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunyongfeng on 2017/6/12.
 */
public class DistributeCandies_575 {


    public int distributeCandies(int[] candies) {
        Set<Integer> tmp = new HashSet<>();
        for (int candy : candies) {
            tmp.add(candy);
        }
        return Math.min(candies.length / 2 , tmp.size());
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3};
        DistributeCandies_575 distributeCandies_575 = new DistributeCandies_575();
        System.out.println(distributeCandies_575.distributeCandies(nums));
    }
}

/*
Given an integer array with even length,
where different numbers in this array represent different kinds of candies.
Each number means one candy of the corresponding kind.
You need to distribute these candies equally in number to brother and sister.
Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
 */
