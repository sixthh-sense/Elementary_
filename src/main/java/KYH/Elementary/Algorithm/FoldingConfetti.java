package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/227
// https://www.acmicpc.net/problem/2630
public class FoldingConfetti {

    // 하얀 종이
    public static int white = 0;
    // 파란 종이
    public static int blue = 0;
    // 판(N x N)
    public static int[][] board;

    // 같은 색상이 아니면 4등분 분할
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(변의 길이 - 2의 1승부터 7승가지)
        int N = Integer.parseInt(br.readLine());
        // 판은 N x N
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                // for문 2개 돌려서 주어진 정보를 board에 채워넣기
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0, 0은 행&열의 초기값 N은 변의 길이
        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int row, int col, int size) {
        // 검사를 통과했음
        if (colorCheck(row, col, size)) {
            // 흰색
            if (board[row][col] == 0) {
                white++;
                // 흰색이 아니면 파란색이겠지
            } else {
                blue++;
            }
            // 메소드 진행 멈추고 빠져나오기(같은 색상으로 판단되면 이 이상 진행 X)
            return;
        }

        int newSize = size / 2; // 반분해야 하니 기존 사이즈 2로 나눔
        // size는 2의 승수니 소수가 될 걱정 X

        // 재귀 등장 (각 사분면 나누는 기준은 newSize 즉 size / 2)
        divide(row, col, newSize);						// 2사분면 (2 1 / 3 4)
        divide(row, col + newSize, newSize);				// 1사분면
        divide(row + newSize, col, newSize);				// 3사분면
        divide(row + newSize, col + newSize, newSize);	// 4사분면
    }

    public static boolean colorCheck(int row, int col, int size) {
        // row, col을 0으로 설정(partition -> 첫째 행의 첫째 열의 색깔을 기준으로 검사)
        int color = board[row][col];

        for (int i = row; i < row + size; i++) { // 0부터 N -1 까지, 즉 N개
            for (int j = col; j < col + size; j++) { // 마찬가지
                // 다른 색상 -> false
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사 모두 통과 -> 죄다 같다는 뜻 -> true(같은 색상)
        return true;
    }
}
