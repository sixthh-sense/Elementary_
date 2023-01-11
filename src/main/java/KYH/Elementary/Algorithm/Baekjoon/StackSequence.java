package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;

// 참고 사이트: https://st-lab.tistory.com/182, https://kwoncorin.tistory.com/90
// https://www.acmicpc.net/problem/1874
// BufferedWriter -> 출력초과 (문자열 하나로 답 만든 후 한번에 출력해야 함?)
public class StackSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] set = new int[N];

        int index = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int j = start + 1; j <= value; j++) {
                    set[index++] = j;
                    //bw.write("+" + "\n");
                    sb.append("+\n");
                }
                start = value; // 다음 오름차순 유지용
            }
            if (set[index -1] == value) {
                index -= 1;
                //bw.write("-" + "\n");
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
//        bw.flush();
//        bw.close();
        br.close();
    }
}