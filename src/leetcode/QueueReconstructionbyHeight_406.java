package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yongfeng on 17/3/30.
 */
//
//Suppose you have a random list of people standing in a queue.
// Each person is described by a pair of integers (h, k),
// where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
// Write an algorithm to reconstruct the queue.
//
//        Note:
//        The number of people is less than 1,100.
//
//        Example
//
//        Input:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//        Output:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]..


public class QueueReconstructionbyHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        int rows = people.length;
        if(rows == 0){
            return new int[0][];
        }
        int columns = people[0].length;
        int[][] res = new int[rows][columns];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return  o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> tmp = new ArrayList<>();
        for(int i = 0 ; i < rows ; ++i){
            tmp.add(people[i][1],people[i]);
        }
        for(int i = 0 ; i < rows ; ++i){
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res ;
    }


    public static void main(String[] args) {
        int [][] people = {
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };

        QueueReconstructionbyHeight_406 queueReconstructionbyHeight_406 = new QueueReconstructionbyHeight_406();
        queueReconstructionbyHeight_406.reconstructQueue(people);
    }






//    public static int[][] reconstructQueue(int[][] people) {
//
//
//        int rows = people.length;
//        List<InnerPair> list1 = new ArrayList<>();
//        for(int i = 0; i< rows ;++i){
//            InnerPair innerPair = new InnerPair(people[i][0],people[i][1]);
//            list1.add(innerPair);
//        }
//
//
//        Collections.sort(list1, new Comparator<InnerPair>() {
//            @Override
//            public int compare(InnerPair o1, InnerPair o2) {
//                if(o1.getH() != o2.getH()){
//                    return o2.getH() - o1.getH();
//                }else{
//                    return o1.getK() -o2.getK();
//                }
//
//            }
//        });
//
//
//        int[][] res= new int[rows][2];
//        List<InnerPair> list2 = new LinkedList<>();
//        for(InnerPair innerPair : list1){
//            list2.add(innerPair.getK(),innerPair);
//        }
//
//
//
//        for(int i = 0; i < rows; ++i){
//            res[i][0] = list2.get(i).getH();
//            res[i][1] = list2.get(i).getK();
//        }
//
//        return res;
//    }
//
//
//
//
//    public static class InnerPair{
//        private int h;
//        private int k;
//
//        public InnerPair(int h, int k) {
//            this.h = h;
//            this.k = k;
//        }
//
//        public int getH() {
//            return h;
//        }
//
//        public void setH(int h) {
//            this.h = h;
//        }
//
//        public int getK() {
//            return k;
//        }
//
//        public void setK(int k) {
//            this.k = k;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] tmp ={
//                {7,0},
//                {8,10},
//        };
//        int[][] res = reconstructQueue(tmp);
//        int rows = res.length;
//        for(int i = 0 ; i < rows; ++i){
//            System.out.println(res[i][0] + " : " + res[i][1]);
//        }
//    }


}

