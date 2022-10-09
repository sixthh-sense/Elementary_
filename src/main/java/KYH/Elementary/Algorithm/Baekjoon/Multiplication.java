package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;

// https://www.acmicpc.net/problem/2588
public class Multiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        // 일
        int one = B % 10;
        // 십
        int ten = (B % 100) / 10;
        // 백
        int hundred = B / 100;

        bw.write((A * one) + "\n" + (A * ten) + "\n" + (A * hundred) + "\n" + (A * B));
        bw.flush();
        bw.close();
        br.close();
    }
}
