package KYH.Elementary.Algorithm.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 참고 사이트: https://st-lab.tistory.com/186
// https://www.acmicpc.net/problem/18258
// Objects.requireNonNullElse 를 쓰면 NoSuchElementException이 뜨는데 왜일까? -> null이 아닐 때 출력될 값 = null 여부 판단 대상일 때만 사용해야 함?
public class Queue2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer command;

        // for (int i = 0; i < N; i++) 와 동일?
        while(N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");	// 문자열 분리

            // switch & case 문 설명 : https://wikidocs.net/263
            switch(command.nextToken()) {
                case "push":
                    // offer는 큐의 맨 뒤에 요소를 추가한다.
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;
                case "pop" :
                    Integer item = q.poll();
                    sb.append(Objects.requireNonNullElse(item, -1)).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    // peek()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer ite = q.peek();
                    sb.append(Objects.requireNonNullElse(ite, -1)).append('\n');
                    break;
                case "back":
                    // peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer it = q.peekLast();
                    sb.append(Objects.requireNonNullElse(it, -1)).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
