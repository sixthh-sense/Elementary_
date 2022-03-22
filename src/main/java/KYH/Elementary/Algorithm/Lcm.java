package KYH.Elementary.Algorithm;

//import java.util.Scanner;

import java.io.*;
import java.util.StringTokenizer;

// 참고 사이트(GCD 구하는 식이 훌륭): https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1934-%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98-JAVA
// 백준 사이트: https://www.acmicpc.net/problem/1934
public class Lcm {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            bw.write(LCM(first, second) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int LCM(int first, int second) {
        int big = Math.max(first, second); // 삼항연산자로도 구하기 가능능
        int small = Math.min(first, second);

        while (small != 0) {
            int r = big % small;
            big = small;
            small = r;
        }
        return first * second / big;
    }
}
