package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-1012%EB%B2%88-%EC%9C%A0%EA%B8%B0%EB%86%8D-%EB%B0%B0%EC%B6%94-DFS-%EC%9E%90%EB%B0%94Java
// https://www.acmicpc.net/problem/1012
public class OrganicNapaCabbage {
    // 밭 가로 길이(50 이하)
    static int M;
    // 밭 세로 길이(50 이하)
    static int N;
    // 배추 개수(배추 위치의 개수)
    static int K;
    // 상하좌우(세로로 보세요)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 배추밭
    static int[][] map;
    // 체크 여부
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 밭 가로 길이(50 이하)
            M = Integer.parseInt(st.nextToken());
            // 밭 세로 길이(50 이하)
            N = Integer.parseInt(st.nextToken());
            // 배추 개수(배추 위치의 개수)
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N]; // 배추밭 지도(좌표)
            check = new boolean[M][N]; // 체크 여부
            int location = 0; // 구역 개수

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                // 각 배추의 좌표
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1; // 입력된 값은 "배추가 있으니까" 1.
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !check[x][y]) {
                        dfs(x, y); // 여기에서 해당 지점뿐만 아니라 상하좌우로 연결된 모든 점을 죄다 체크해주기
                        location++;
                    }
                }
            }
            bw.write(location + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int x, int y) {
        check[x][y] = true; // 체크를 했으니 체크했다고 표시
        for (int i = 0; i < 4; i++) { // 배열에 인스가 0, 1, 2, 3이고 상하좌우니까 이런 식으로 지정
            int ix = x + dx[i];
            int iy = y + dy[i]; // 이 x, y좌표는 상하좌우로 연결된 곳(반복이 되니 더더욱)

            if (ix >= 0 && ix < M && iy >= 0 && iy < N) { // "범위 안" (0, 0) ~ (N-1, N-1) 사이의 범위라면(-1, -1 같은 마이너스도 가능)
                if (map[ix][iy] == 1 && !check[ix][iy]) { // 상하좌우로 연결이 됐고, 배추도 있는데 체크가 안 됐다? 체크하자!
                    dfs(ix, iy); // 새로운 지점에서 재탐색 -> 해당 메소드에 check 해주는 기능도 있으니 ok
                }
            }
        }
    }
}
