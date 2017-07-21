package leetcode;

/**
 * Created by sunyongfeng on 2017/7/21.
 */
public class NQueensII_52 {

    private int res = 0;

    public int totalNQueens(int n) {
        if(n <= 1){
            return n;
        }
        helper(n,0,new int[n]);
        return res;
    }
    private void helper(int n ,int row,int[] queensPos){
        if(row == n){
            ++res;
            return ;
        }
        for(int i = 0 ;i < n ; ++i){
            if(isVaild(n,row,i,queensPos)){
                queensPos[row] = i;
                helper(n ,row + 1,queensPos);
            }
        }
    }
    private boolean isVaild(int n ,int row,int column,int[] queensPos){
        for(int i = 0 ; i < row; ++i){
            int pos = queensPos[i];
            if(pos == column || pos + row - i  == column || pos - row + i == column){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII_52 nQueensII_52 = new NQueensII_52();
        System.out.println(nQueensII_52.totalNQueens(4));
    }


}

/**
 * Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.


 */
