package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/128
// https://www.acmicpc.net/problem/1149
public class RGBStreet {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] cost;
    static int[][] DP;


    // 사례는 연속성을 보여주는 것. n번째 집의 색은 n-1번째 집의 색과 같지 않다 -> 반복하면 자연히 i != i-1 && i != i+1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 각 집을 특정 색상으로 칠하는 데 드는 비용
        cost = new int[N][3];
        // n번째 집을 칠하는 최소값
        DP = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // RGB 순서대로 각 색상 칠하는 비용 값 입력
            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        // DP 초기값 입력
        DP[0][Red] = cost[0][Red];
        DP[0][Green] = cost[0][Green];
        DP[0][Blue] = cost[0][Blue];

        int result = Math.min(Paint(N- 1, Red), Math.min(Paint(N - 1, Green), Paint(N - 1, Blue)));

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int Paint(int N, int color) {

        if(DP[N][color] == 0) {
            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            if(color == Red) {
                DP[N][Red] = Math.min(Paint(N - 1, Green), Paint(N - 1, Blue)) + cost[N][Red];
            }
            else if(color == Green) {
                DP[N][Green] = Math.min(Paint(N - 1, Red), Paint(N - 1, Blue)) + cost[N][Green];
            }
            else {
                DP[N][Blue] = Math.min(Paint(N - 1, Red), Paint(N - 1, Green)) + cost[N][Blue];
            }
        }
        return DP[N][color];
    }
}
