package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1010
public class BridgeBuilding {
    // 동쪽 입지에서 서쪽 입지의 개수만큼 다리 놓을 데를 정하면 순서는 정해짐. n C r
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            double N = Integer.parseInt(st.nextToken());
            double M = Integer.parseInt(st.nextToken());

            double answer = factorial(M) / (factorial(N) * factorial(M - N));

            System.out.printf("%.0f\n", answer);
        }
        br.close();
    }

    public static double factorial(double number) {
        if (number == 0) return 1;

        double answer = 1;
        for (double i = 1; i < number + 1; i++) {
            answer *= i;
        }

        return answer;
    }
}
