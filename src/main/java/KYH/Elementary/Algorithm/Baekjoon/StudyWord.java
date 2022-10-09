package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// #1157
public class StudyWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) -'A' ;
            System.out.println(str.charAt(i));
            System.out.println(num);
            count[num]++;
            System.out.println(Arrays.toString(count));
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if(max < count[i]){
                max = count[i];
                answer = (char)(i+'A');
            } else if (max == count[i]){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
