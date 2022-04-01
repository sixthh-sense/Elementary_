package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/141
// https://www.acmicpc.net/problem/12865
public class AnOrdinaryBackpack { // 어렵다... 특히 식으로 바꿀 때
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 물건 개수(Number)
        int K = Integer.parseInt(st.nextToken()); // 총 무게(Kilogram?)

        int[] W = new int[N];
        int[] V = new int[N];
        int[] dp = new int[K + 1]; // 담기로 결정한 가치

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken()); // 무게(Weight)
            V[i] = Integer.parseInt(st.nextToken()); // 가치(Value)
        }

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= W[i]; j--) { // 무게 제한은 W[i] 이상 K 미만, 빼면서 찾는다.
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]); // dp[j - W[i]] + V[i] -> 무게와 가치 tradeoff
            }
        }
        System.out.println(W[0]);
        bw.write(dp[K] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
