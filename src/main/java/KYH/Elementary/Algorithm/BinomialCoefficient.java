package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// 참고 사이트: https://st-lab.tistory.com/159 여기서 설명하는 파스칼의 법칙 -> 재귀 이용해서 해보자
// https://www.acmicpc.net/problem/11050
public class BinomialCoefficient {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = factorial(N) / (factorial(K) * factorial(N - K));

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int factorial(int number) {
        if (number == 0) return 1;

        int answer = 1;
        for (int i = 1; i < number + 1; i++) {
            answer *= i;
        }

        return answer;
    }
}
