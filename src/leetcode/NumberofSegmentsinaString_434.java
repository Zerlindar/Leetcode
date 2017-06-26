package leetcode;

/**
 * Created by yongfeng on 17/2/23.
 */
public class NumberofSegmentsinaString_434 {
    public int countSegments(String s) {
        if(s == null ){
            return 0;
        }
        int res = 0;
        int len = s.length();
        for(int i = 0 ; i < len ; ++i){
            if(s.charAt(i)!= ' ' && (i == 0 || s.charAt(i - 1) == ' ')){
                ++res;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        NumberofSegmentsinaString_434 numberofSegmentsinaString_434 = new NumberofSegmentsinaString_434();
        String s = "   Hello, my name is John";

        System.out.println(numberofSegmentsinaString_434.countSegments(s));
    }

}




//Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//        Please note that the string does not contain any non-printable characters.
//
//        Example:
//
//        Input: "Hello, my name is John"
//        Output: 5
//        Subscribe to see which companies asked this question.