package leetcode;

/**
 * Created by sunyongfeng on 2017/7/12.
 */
public class ComplexNumberMultiplication_537 {
    public String complexNumberMultiply(String a, String b) {
        int a1 ,b1,a2,b2;
        int tmp = a.indexOf("+");
        a1 = Integer.valueOf(a.substring(0,tmp));
        b1 = Integer.valueOf(a.substring(tmp + 1,a.length() - 1));
        tmp = b.indexOf("+");
        a2 = Integer.valueOf(b.substring(0,tmp));
        b2 = Integer.valueOf(b.substring(tmp + 1,b.length() - 1));
        int a3 = a1 * a2 - b1 * b2;
        int b3 = a1 * b2 + a2 * b1;
        return String.valueOf(a3) + "+" +  String.valueOf(b3) + "i";
    }

    public static void main(String[] args) {
        ComplexNumberMultiplication_537 complexNumberMultiplication_537 = new ComplexNumberMultiplication_537();
        System.out.println(complexNumberMultiplication_537.complexNumberMultiply("1+-1i","0+0i"));
    }
}

/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

 */