package KYH.Elementary.Algorithm.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// https://st-lab.tistory.com/115
// https://www.acmicpc.net/problem/15650
public class N_M2 {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ~ N 중에서 M개 고르기(중복 없음)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // 초기값
        dfs(1, 0);
        System.out.println(sb);

    }

    // at : 어디서부터 시작하는지, depth는 수열의 길이(가 될 값) 0부터 M까지 따짐
    public static void dfs(int at, int depth) {
        if (depth == M) {
            // 최대값일 땐 그냥 그 행렬 그대로 써주기
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        // 그게 아닐 땐?
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            // depth == M 될 때까지 재귀 GO (1 다음에는 2 탐색)
            dfs(i + 1, depth + 1);
        }
    }
}
