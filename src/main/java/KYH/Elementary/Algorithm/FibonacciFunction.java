package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://infodon.tistory.com/65
// https://www.acmicpc.net/problem/1003
public class FibonacciFunction {

    // 0 횟수 (n-1번째 피보나치 수열)
    static int zero_count = 0;
    // 1 횟수 (n번째 피보나치 수열)
    static int one_count = 0;
    // 테스트 케이스 개수
    static int T;
    // 답안 작성용
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            fibonacci(Integer.parseInt(br.readLine()));
            // 답안에 먼저 축적된 값을 적어준 다음에
            sb.append(zero_count).append(" ").append(one_count).append("\n");
            // 다음에 구할 차례를 위해 초기화(초기화된 0은 답안에 안 적힘)
            zero_count = 0;
            one_count = 0;
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        // 0 담당
        int temp1 = 0;
        // 1 담당
        int temp2 = 1;
        // 연산 매개 담당
        int temp;

        if (n == 0) {
            zero_count++;
        } else if (n == 1) {
            one_count++;
        } else { // 1부터 n까지(n개)
            for (int i = 1; i < n; i++) { // 일련의 과정을 n-1번 거치기
                // temp는 합
                temp = temp1 + temp2;
                // 0 담당은 1 값을 가져옴
                temp1 = temp2;
                // 1 담당은 합이 됨
                temp2 = temp;
            }
            zero_count = temp1;
            one_count = temp2;
        }
    }
}
