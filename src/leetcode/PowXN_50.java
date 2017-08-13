package leetcode;

/**
 * Created by sunyongfeng on 2017/6/30.
 */
public class PowXN_50 {
    public double myPow(double x, int n) {
        if(n == 0 ){
            return 1d;
        }
        long tmp = (long)n;
        if(n < 0){
            return 1 / help(x, -tmp);
        }else{
            return help(x,tmp);
        }
    }

    private double help(double x ,long n){
        if(n == 1){
            return x;
        }
        double tmp = help(x,n / 2);
        if(n % 2 == 0){
            return tmp * tmp;
        }else{
            return tmp * tmp * x;
        }
    }


    public static void main(String[] args) {
        PowXN_50 powXN_50 = new PowXN_50();
        System.out.println(powXN_50.myPow(8.88023,3));
    }
}


/*
Implement pow(x, n).
 */