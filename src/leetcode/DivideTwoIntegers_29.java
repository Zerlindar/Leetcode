package leetcode;

/**
 * Created by sunyongfeng on 2017/7/7.
 */
public class DivideTwoIntegers_29 {

    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        long tmpDividend = (long)dividend;
        long tmpDivisor = (long)divisor;
        long res  = 0 ;
        long flag = 1;
        if((tmpDividend > 0 && tmpDivisor < 0) || (tmpDividend < 0 && tmpDivisor > 0)){
            flag = -1;
        }
        tmpDividend = Math.abs(tmpDividend);
        tmpDivisor = Math.abs(tmpDivisor);
        int cnt = 1;
        while(tmpDividend >= tmpDivisor){
            tmpDividend -= tmpDivisor;
            tmpDivisor <<= 1;
            res += cnt;
            cnt <<= 1;
        }
        tmpDivisor = Math.abs((long)divisor);
        while(tmpDividend >= tmpDivisor ){
            ++res;
            tmpDividend -= tmpDivisor;
        }
        if(flag == -1){
            res = -res;
        }

        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)res;

    }

    public static void main(String[] args) {
        DivideTwoIntegers_29 divideTwoIntegers_29 = new DivideTwoIntegers_29();
        System.out.println(divideTwoIntegers_29.divide(-10,3));
    }


}


/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.


 */
