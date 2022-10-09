package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.PriorityQueue;

// http://www.tcpschool.com/java/java_collectionFramework_stackQueue, https://crazykim2.tistory.com/575
// https://ilmiodiario.tistory.com/126?category=914174
// https://www.acmicpc.net/problem/1927
public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 괄호 안에 아무것도 없으니 낮은 숫자 순으로 우선순위 결정
        // priority queue -> 들어간 순서와 관계없이 나올 순서는 설정한 오름/내림차순에 따름
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) { // x가 0일 때만 출력(bw.write)
                if (!queue.isEmpty()) { // 뭔가 있을 때는 최소값을 출력 & 제거 (poll은 맨앞 요소 대상)
                    bw.write(queue.poll() + "\n");
                } else { // 비어있을 땐 0 출력
                    bw.write(0 + "\n");
                }
                continue; // 0은 queue에 넣을 대상이 아니니 패스
            }
            queue.add(x); // 0이 아닐 땐 출력 없이 더해주기만 한다
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
