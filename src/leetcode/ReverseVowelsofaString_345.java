package leetcode;

/**
 * Created by yongfeng on 17/2/20.
 */

//
//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//        Given s = "hello", return "holle".
//
//        Example 2:
//        Given s = "leetcode", return "leotcede".
//
//        Note:
//        The vowels does not include the letter "y".
//
//        Subscribe to see which companies asked this question.



public class ReverseVowelsofaString_345 {

    public String reverseVowels(String s) {
        if(s == null){
            return s;
        }
        int len = s.length();
        if(len == 0){
            return  s;
        }
        char[] chars = s.toCharArray();

        int left = 0;
        int right = len - 1;

        while(left < right){
            while(left < right){
                if(isVowel(chars[left])){
                    break;
                }else{
                    ++left;
                }
            }
            while(right > left){
                if(isVowel(chars[right])){
                    break;
                }else{
                    --right;
                }
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;
        }


        return new String(chars);
    }



    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        ReverseVowelsofaString_345 reverseVowelsofaString_345 = new ReverseVowelsofaString_345();

        String s = "yoy";

        System.out.println(reverseVowelsofaString_345.reverseVowels(s));
    }
}
