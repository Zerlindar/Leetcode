package leetcode;

/**
 * Created by yongfeng on 17/4/20.
 */
public class FriendCircles_547 {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        if(N == 0){
            return 0;
        }
        boolean[] used = new boolean[N];
        int res = 0;
        for(int i = 0 ; i < N ; ++i){
            if(!used[i]){
                ++res;
                used[i] = true;
                dfsHelper(M,N,i,used);
            }
        }
        return res;
    }
    private void dfsHelper(int[][] M,int N,int i,boolean[] used){
        for(int k = 0 ; k < N ; ++k){
            if(M[i][k] == 1 && !used[k]){
                used[k] = true;
                dfsHelper(M,N,k,used);
            }
        }

    }

    public static void main(String[] args) {
        int[][] tmp = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        FriendCircles_547 friendCircles_547 = new FriendCircles_547();
        friendCircles_547.findCircleNum(tmp);
    }
}


/*
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems


 */