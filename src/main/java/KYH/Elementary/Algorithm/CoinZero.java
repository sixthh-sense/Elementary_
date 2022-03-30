package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://fbtmdwhd33.tistory.com/168, https://st-lab.tistory.com/143
// https://www.acmicpc.net/problem/11047
public class CoinZero { // 밑의 단위부터 더하면 되겠군
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 동전의 종류
        int N = Integer.parseInt(st.nextToken());

        // 만들어야 하는 가치의 합
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        // 동전들의 가치
        int[] value = new int[N];
        for(int i = 0 ; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        // 가장 높은 가치의 동전부터 탐색
        for(int i = N - 1; i >= 0; i--) {
            // 해당 가치가 k보다 작을 경우, (큰 것부터 탐색하니 가능한 한 가장 큰 값)
            if(value[i] <= K) {
                // 몫이 해당 동전의 개수가 되고
                cnt += K / value[i];
                // 나머지를 다시 k로 대입하면 된다. (찾을 값 재탕)
                K %= value[i];
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
