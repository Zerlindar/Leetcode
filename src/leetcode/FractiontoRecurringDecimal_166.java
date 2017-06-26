package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongfeng on 17/3/10.
 */
public class FractiontoRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if((numerator < 0 && denominator > 0 ) || (numerator > 0 && denominator < 0)){
            sb.append("-");
        }
        Long num = Math.abs((long)numerator);
        Long den = Math.abs((long)denominator);
        Long  quotient = num / den;
        Long  remainder = num % den;
        sb.append(quotient);
        if(remainder != 0){
            sb.append(".");
        }
        List<Long> quotientList = new ArrayList<>();
        List<Long> remainderList = new ArrayList<>();
        remainderList.add(remainder);
        Boolean isRepeat = false;
        while(remainder != 0){
            remainder *= 10;
            quotient = remainder / den;
            remainder %= den;
            quotientList.add(quotient);
            if(remainderList.contains(remainder)){
                isRepeat = true;
                break;
            }
            remainderList.add(remainder);
        }

        int len = quotientList.size();
        for(int i = 0 ; i < len ; ++i){
            if(remainderList.get(i).equals(remainder) && isRepeat){
                sb.append("(");
            }
            sb.append(quotientList.get(i));
        }
        if(isRepeat){
            sb.append(")");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        FractiontoRecurringDecimal_166 fractiontoRecurringDecimal_166 = new FractiontoRecurringDecimal_166();
        System.out.println(fractiontoRecurringDecimal_166.fractionToDecimal(-1,-2147483648));
    }

}


//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//        If the fractional part is repeating, enclose the repeating part in parentheses.
//
//        For example,
//
//        Given numerator = 1, denominator = 2, return "0.5".
//        Given numerator = 2, denominator = 1, return "2".
//        Given numerator = 2, denominator = 3, return "0.(6)".
//        Hint:
//
//        No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
//        Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
//        Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
//        Credits:
//        Special thanks to @Shangrila for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.