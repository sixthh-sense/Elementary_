package KYH.Elementary.Algorithm.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/190, https://codemasterkimc.tistory.com/244
// https://www.acmicpc.net/problem/9184
public class ExcitingFunctionExecution {

    // dp는 w(a, b, c)에 대한 것. 최대값이 w(20, 20, 20)이라 죄다 20 이하. 0~20이니 사이즈 21
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) { // 각 줄마다 뽑아야 하니까 반복문
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // "입력의 마지막" 확실히 지정( -1 -1 -1 ) -> 마지막이 아니면 없다는 문장까지 추가
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            // w(a, b, c)를 연산하기 위한 함수 따로 분리
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a ,b ,c)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    static int w(int a, int b, int c) {
        // 문제 나와있는 것 복붙. dp[a][b][c]
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            // 여기서 dp[a][b][c]하면 안 됨... 범위가 20까지라니까? [22]는 있을 수 없으니 [20] 지정
            return dp[20][20][20] = w(20, 20, 20);
        }
        // 메모이제이션 -> 용량 줄이기(이미 계산된 건 반환하자)
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    /* inRange 안 해도 != 0 조건만으로 순서 잘 맞추면 OK?
     *  배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가
     *  나올 수 있기 때문에 이를 체크를 해주기 위한 함수다.
     */
//    static boolean inRange(int a, int b, int c) {
//        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
//    }
}
