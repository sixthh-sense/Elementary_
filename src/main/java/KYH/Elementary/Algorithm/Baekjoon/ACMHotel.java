package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10250
public class ACMHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int H, W, N;
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            if (N % H == 0) {
                System.out.println((H * 100) + (N / H));
            } else {
                System.out.println(((N % H) * 100) + ((N / H) + 1));
            }
        }
    }
}
