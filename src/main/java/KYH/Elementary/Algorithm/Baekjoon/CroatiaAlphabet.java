package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

// #2941
public class CroatiaAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 표에 변환된 값 그대로
        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String s = sc.nextLine();

        for (int i = 0; i < str.length; i++) {
            if (s.contains(str[i]))
                s = s.replace(str[i], "#");
            //s = s.replaceAll(str[i], "#");
        }

        System.out.println(s);

        System.out.println(s.length());
    }
}
