package KYH.Elementary.Algorithm;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1929
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M, N;
        M = sc.nextInt();
        N = sc.nextInt();

        for (int i = M; i <= N; i++) {
            if (isItPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isItPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0)
                    return false;
            }
        }
        return true;
    }
}
