package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

public class GcdLcm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int big = Math.max(a, b);
        int small = Math.min(a, b);

        // 유클리드 호제법: big이 최대공약수가 될 때는 small이 0일 때
        while (small != 0) {
            int r = big % small;
            big = small;
            small = r;
        }

        // 반복문을 거친 big은 최대공약수
        System.out.println(big);
        // 최소공배수 = 두 수의 곱 / 최대공약수
        System.out.println(a * b / big);
    }
}
