package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

// # 1110
public class SumCycle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        int cnt = 0;
        int copy = N;

        while (true) {
            copy = ((copy % 10) * 10) + (((copy / 10) + (copy % 10)) % 10);
            cnt++;

            if (copy == N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
