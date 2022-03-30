package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀 출처: https://st-lab.tistory.com/127
// 반복문 출처: https://jainn.tistory.com/272 [Dogfootruler Kim]
// https://www.acmicpc.net/problem/9461
public class ClassWaveSequence {
    // 1 <= N <= 100
    public static Long[] dp = new Long[101];

    // 삼각형 변의 길이 n번째 삼각형 변의 길이 = n-2번째 + n-3번째
    // n-2, n-3이 나오는 이유는 "삼각형"이라 초기값 1, 1, 1에서 시작하기 때문?
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기값 세팅
        dp[0] = 0L; // 사실 얘까지 할 필요 있을까 싶다가도 null값 따지니 지정해줘야 할 듯(엄밀히는 소환될 새가 없는 문장?)
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(P(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static Long P(int N) {
        if(dp[N] == null) { // Long // 사실 초기값 빼곤 다 null인 상태
            dp[N] = P(N-2) + P(N-3);
        }
        return dp[N];
    }
}
