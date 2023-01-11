package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// https://zzang9ha.tistory.com/101, https://roomconerdeveloper.tistory.com/110
// https://www.acmicpc.net/problem/1932
public class IntegerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        int[][] maxPoint = new int[N][N];
        int result = Integer.MIN_VALUE;

        // triangle은 좌표에 위치한 값을 나타내줌(x좌표, y좌표)
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxPoint[0][0] = triangle[0][0];
        // n번째, n-1번째 비교해서 최대값 구하기
        for (int i = 1; i < N; i++) {
          for (int j = 0; j <= i; j++) {
              // 왼쪽
              if(j == 0)
                  maxPoint[i][j] = maxPoint[i-1][j] + triangle[i][j];
                  // 오른쪽
              else if(j == i)
                  maxPoint[i][j] = maxPoint[i-1][j-1] + triangle[i][j];
                  // 그 외(모서리 아님, 중간값)
              else
                  maxPoint[i][j] = Math.max(maxPoint[i-1][j-1], maxPoint[i-1][j]) + triangle[i][j];
          }
        }
        for (int i = 0; i < N; i++) {
            result = Math.max(result, maxPoint[N - 1][i]);
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
