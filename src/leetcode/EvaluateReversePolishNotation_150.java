package leetcode;

import java.util.Stack;

/**
 * Created by yongfeng on 17/3/2.
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if(null == tokens || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for(int i = 0 ; i < len ; ++ i){
            if("+".equals(tokens[i]) || "-".equals(tokens[i]) || "/".equals(tokens[i]) || "*".equals(tokens[i])){
                stack.push(operate(tokens[i], stack.pop(), stack.pop()));
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private Integer operate(String s,Integer num2,Integer num1){
        if("+".equals(s)){
            return num1 + num2;
        }
        if("-".equals(s)){
            return num1 - num2;
        }
        if("*".equals(s)){
            return num1 * num2;
        }
        if("/".equals(s)){
            return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 evaluateReversePolishNotation_150 = new EvaluateReversePolishNotation_150();
        String[] strings = {"4", "13", "5", "/", "+"};
        System.out.println(evaluateReversePolishNotation_150.evalRPN(strings));
    }

}



//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//        Some examples:
//        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//        Subscribe to see which companies asked this question.
//
//        Show Tags
//        Show Similar Problems
