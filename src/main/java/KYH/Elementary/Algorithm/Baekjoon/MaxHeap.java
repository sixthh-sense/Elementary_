package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.PriorityQueue;

// https://dundung.tistory.com/108
// https://www.acmicpc.net/problem/11279
public class MaxHeap {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산 개수 N(1 이상 10만 이하)
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // Collections.reverseOrder()를 이용하면 -1 곱하는 번거로운 걸 할 필요 X

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    // 삭제된 값에 -1 곱해서 출력 -> 음수였던 걸 양수로
                    bw.write(queue.poll() * (-1) + "\n");
                }
            } else { // 음수 형태로 삽입 -> 최대값 우선순위가 제일 높게끔
                queue.add(x * (-1));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
