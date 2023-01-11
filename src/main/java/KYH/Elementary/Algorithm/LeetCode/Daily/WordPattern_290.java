package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
    /*
    * Given a pattern and a string s, find if s follows the same pattern
    * follow? full match
    * there is a bijection between a letter in "pattern"
    * and a non-empty word in s
    * */

    // LeetCode 0ms submission: https://leetcode.com/problems/word-pattern/submissions/869171719/

    public static String pattern = "abba"; // "aaaa"
    public static String s = "dog cat cat dog"; // "dog cat cat fish"

    public static boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");

        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();

        if (pattern.length() != array.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = array[i];
            if (charMap.get(c) == null) {
                if (strMap.containsKey(str)) {
                    return false;
                } else {
                    charMap.put(c, str);
                    strMap.put(str, c);
                }
            } else {
                if (!charMap.get(c).equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(wordPattern(pattern, s));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime); // 이것저것 덧붙이면 estimate이 너무 많이 달라짐? - 편차가 있으니 역시 JMeter로 검사하는 게 더 낫나
    }
}
