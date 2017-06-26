package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yongfeng on 17/2/28.
 */
public class SortCharactersByFrequency_451 {


    public String frequencySort(String s) {
        if(null == s || s.length() <= 1){
            return s;
        }

        int len = s.length();
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        PriorityQueue<String> pq = new PriorityQueue<>(len, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for(int i = 0 ; i < len ;){
            int j = i +1;
            while(j < len){
                if(tmp[j] != tmp[i]){
                    break;
                }
                ++j;
            }
            pq.add(charArr2String(tmp[i],j - i));
            i = j;
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return sb.toString();

    }

    private String charArr2String(char c, int sum){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < sum ; ++i){
            sb.append(c);
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        SortCharactersByFrequency_451 sortCharactersByFrequency_451 = new SortCharactersByFrequency_451();
        String s = "Aabb";

        System.out.println(sortCharactersByFrequency_451.frequencySort(s));
    }
}




//
//Given a string, sort it in decreasing order based on the frequency of characters.
//
//        Example 1:
//
//        Input:
//        "tree"
//
//        Output:
//        "eert"
//
//        Explanation:
//        'e' appears twice while 'r' and 'SkipList' both appear once.
//        So 'e' must appear before both 'r' and 'SkipList'. Therefore "eetr" is also a valid answer.
//        Example 2:
//
//        Input:
//        "cccaaa"
//
//        Output:
//        "cccaaa"
//
//        Explanation:
//        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//        Note that "cacaca" is incorrect, as the same characters must be together.
//        Example 3:
//
//        Input:
//        "Aabb"
//
//        Output:
//        "bbAa"
//
//        Explanation:
//        "bbaA" is also a valid answer, but "Aabb" is incorrect.
//        Note that 'A' and 'a' are treated as two different characters.
//        Subscribe to see which companies asked this question.
