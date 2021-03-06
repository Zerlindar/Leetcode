package leetcode;

/**
 * Created by sunyongfeng on 2017/6/16.
 */
public class BullsandCows_299 {

    public String getHint(String secret, String guess) {
        int correct = 0;
        int unCorrect = 0;
        int[] secretCnt = new int[10];
        int[] guessCnt = new int[10];
        int len = secret.length();
        for(int i = 0 ; i < len ; ++i){
            if(secret.charAt(i) == guess.charAt(i)){
                ++correct;
            }else{
                ++secretCnt[secret.charAt(i) - '0'];
                ++guessCnt[guess.charAt(i) - '0'];
            }
        }

        for(int i = 0 ; i < 10 ; ++i){
            unCorrect += Math.min(secretCnt[i],guessCnt[i]);
        }

        return correct + "A" + unCorrect + "B";
    }

    public static void main(String[] args) {
        BullsandCows_299 bullsandCows_299 = new BullsandCows_299();
        String s1 = "1123";
        String s2 = "0111";
        System.out.println(bullsandCows_299.getHint(s1,s2));
    }


}

/*
You are playing the following Bulls and Cows game with your friend:
You write down a number and ask your friend to guess what the number is.
 Each time your friend makes a guess,
 you provide a hint that indicates how many digits in said guess match
 your secret number exactly in both digit and position (called "bulls") and
 how many digits match the secret number but locate in the wrong position (called "cows").
  Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess,
 use A to indicate the bulls and B to indicate the cows.
 In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.
 */
