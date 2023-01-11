package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://steady-coding.tistory.com/21, https://st-lab.tistory.com/197
// https://www.acmicpc.net/problem/11866
public class JosephusSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // LinkedList와 Queue의 차이는 뭘까?
        LinkedList<Integer> q = new LinkedList<>();

        // 1~N까지 넣어주기
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        // 답지에 < 추가
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;

        // Queue의 사이즈가 1이 될 때까지 반복한다.
        while (N > 1) {
            index = (index + (K - 1)) % N;

            sb.append(q.remove(index)).append(", ");
            N--;
        }

        // 사이즈가 1일 때는 단순히 poll하면 된다.
        sb.append(q.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
