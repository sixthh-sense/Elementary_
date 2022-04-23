package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;
//import java.util.Scanner;

// https://www.acmicpc.net/problem/1929
public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

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
            for (int i = 2; i <= Math.sqrt(number); i++) { // 에라스토테네스의 체
                if (number % i == 0)
                    return false;
            }
        }
        return true;
    }
}
