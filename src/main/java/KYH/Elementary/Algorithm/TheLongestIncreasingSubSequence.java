package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/137
// https://www.acmicpc.net/problem/11053
// LIS 개념(최장 증가 부분 수열)
public class TheLongestIncreasingSubSequence {
    static int[] seq; // 문제에서 주어진 값 입력용
    static int[] dp; // 각 수열의 길이 입력용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) { // 문제에서 주어진 값을 seq에 입력
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) { // 각 인덱스별 최장수열의 길이 구하기
            LIS(i);
        } // LIS(0) -> dp[0] = 1, ... LIS(3) -> dp[1] = 1 -> seq[2]/seq[1]/seq[0]이 seq[3]보다 작으면 dp[N]은 최대값 고르기

        /*
        * 다른 버전으로는
        for(int i = 0; i < N; i++) {
			dp[i] = 1;

			// 0 ~ i 이전 원소들 탐색
			for(int j = 0; j < i; j++) {

				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if(seq[j] < seq[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
        * */

        // 오름차순 정렬
        Arrays.sort(dp);

        // 맨 마지막 항목(최대값)
        bw.write(dp[N-1] + "");
//        bw.write(Arrays.toString(dp) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int LIS(int N) { // 각 인덱스별 "최장수열"의 길이 구하기
        if (dp[N] == 0) { // int[] 초기값은 0
            dp[N] = 1; // 각 인덱스별 "기본적인 길이"는 1이겠지. 일단 원소가 1개는 있으니까.
            for (int i = N - 1; i >= 0; i--) {
                if (seq[i] < seq[N]) { // 증가하는 형태가 나올 때마다 ( N - 1, N을 먼저 비교해야 하니까 N - 1부터 감소하는 형태 )
                    // N번째 인덱스의 최종 수열의 길이 = 최대값 구하기(dp[N], LIS(N-1) + 1)
                    dp[N] = Math.max(dp[N], LIS(i) + 1); // 비교군으로 LIS(i) + 1을 삼는 이유: LIS(i) 단계에서도 착실히 누적된 길이를 구해왔으니까, "다음 단계"에선 1만 더해주면 ok
                }
            }
        }
        return dp[N];
    }
}
