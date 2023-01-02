package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.nio.charset.StandardCharsets;

public class DetectCapital_520 {
    /*
    * Define the usage of capitals in a word to be right when one of the following cases holds:
    * All letters in this word are capitals (ex) USA
    * all letters in this word are not capitals (ex) leetcode
    * Only the first letter in this word is capital (ex) Google
    * 1 <= word.length <= 100
    * */

    /* unicode : java char
    * a - z : 97 - 122
    * A - Z : 65 - 90
    * */
    public static void main(String[] args) {
        String word = "usa"; // FlaG -> false
        long startTime = System.nanoTime();
        System.out.println(detectCapitalUse(word)); // should be true
        long estimate = System.nanoTime() - startTime;
        System.out.println(estimate);
    }

    public static boolean detectCapitalUse(String word) {

        if (word.length() == 0) {
            return false;
        } else if (word.length() == 1) {
            return true;
        } else {
            if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
                return true;
            } else { // 65 이상이라는 조건은 생략?
                byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);
                if (bytes[0] <= 90) {
                    for (int i = 1; i < word.length(); i++) {
                        if (bytes[i] <= 90) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
