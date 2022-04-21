package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2884
// https://st-lab.tistory.com/24
public class AlarmClock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M < 45) { // (분) 60분에서 45와의 차이를 빼야 함
            if (H == 0) { // (시) 0시에서 하나를 빼면 23시 + (45분 미만일 경우에만 H가 줄어듬)
                H = 23;
            } else { // (시) 그 이외의 경우 그냥 속 편하게 1 빼면 됨
                H -= 1;
            } // (분) - (예) 25분일 경우 60분에서 20분 빼기 등. 실질적으로는 15분 더해주는 꼴?
            //M = 60 - ( 45 - M );
            M = M + 15;
        } else { // (분) 그러지 않고 그냥 속편하게 45 빼면 됨 (시) 변화 없음
            M = M - 45;
        }
        bw.write(H + " " + M);
        bw.flush();
        bw.close();
        br.close();
    }
}
