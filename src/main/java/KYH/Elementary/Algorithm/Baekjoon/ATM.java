package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/147, https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11399%EB%B2%88-ATM-%EC%9E%90%EB%B0%94Java
// https://www.acmicpc.net/problem/11399
// 단순 합만 구하는 게 아니라 각 인물이 기다리는 시간까지 포함 -> "최소값"을 출력해야 하니 제일 빨리 끝내는 사람부터.
public class ATM {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 대기자 인원수(1 이상 1000 이하)
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(P);

        int total = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            prev += P[i];
            total += prev;
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();



        /* (이해가 덜 된 풀이)
        // 각 인원의 일처리 시간
        int[] P = new int[1001];

        // 이런 걸 counting sort라고 하나? Arrays.sort하는 것보다 이게 더 빠르다고?
        while (N-- > 0) {
            P[Integer.parseInt(st.nextToken())]++;
            System.out.println(Arrays.toString(P));
        }

        // 이전 사람까지의 대기시간 누적합
        int prev = 0;
        // 대기시간 총합(최소값)
        int total = 0;

        for (int i = 0; i < 1001; i++) {
            while (P[i]-- > 0) {
                //System.out.println(Arrays.toString(P));

                // 총합 = 누적합 + 현 단계 걸리는 시간
                total += (prev + i);

                // 누적합이니 "현재 걸리는 시간" 계속해서 더해주기
                prev += i;
            }
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();*/

    }
}
