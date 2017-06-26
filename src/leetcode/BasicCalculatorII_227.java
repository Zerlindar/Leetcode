package leetcode;

/**
 * Created by yongfeng on 17/2/22.
 */
public class BasicCalculatorII_227 {

    public int calculate(String s) {
        if(null == s){
            return 0;
        }
        int  len = s.length();
        if(len == 0){
            return 0;
        }
        s = s + "+";
        int num = 0;
        int res = 0;
        int preSign = '+';
        int preNum = 0;
        for(int i = 0 ; i < len + 1 ; ++i){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else{
                if(preSign == '+'){
                    res += num;
                    preNum = num;
                }
                if(preSign == '-'){
                    res -= num;
                    preNum = -num;
                }
                if(preSign == '*'){
                    res = res - preNum + (preNum * num);
                    preNum = preNum * num;
                }
                if(preSign == '/'){
                    res = res - preNum + (preNum / num);
                    preNum = preNum /num;
                }
                num = 0;
                preSign = c ;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        BasicCalculatorII_227 basicCalculatorII_227 = new BasicCalculatorII_227();


        String s = "1+2*3/3*2-1+4-1" ;

        System.out.println(basicCalculatorII_227.calculate(s));
    }
}


/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question.
 */


