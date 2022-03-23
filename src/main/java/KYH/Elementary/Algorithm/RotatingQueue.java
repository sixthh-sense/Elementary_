package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/216, https://1-7171771.tistory.com/35
// https://www.acmicpc.net/problem/1021
public class RotatingQueue {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
        int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int[] line = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            // 둘째 줄 -> 찾을 값 배열의 각 원소
            line[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int index = 0;
                for (Integer integer : queue) {
                    // n번째 원소의 "인덱스" 값은 n-1번째이니 위쪽에서 break
                    if (integer.equals(line[i])) break;
                    index++;
                }
                if (index == 0) { // 인덱스가 0번째라는 것 = 이동할 필요 X -> pollFirst는 첫번째 원소 출력 & 없애기
                    queue.pollFirst();
                    break;
                    // 찾을 값이 뒤쪽에 있으면 뒤쪽 원소를 뽑아 앞 자리에 붙이기
                } else if (index > queue.size() / 2) {
                    queue.addFirst(queue.removeLast());
                    // 일치해서 pollFirst되기 전까지 count 1씩 증가
                    count++;
                    // 찾을 값이 앞쪽에 있으면 앞쪽 원소를 뽑아 뒷자리에 붙이기
                } else {
                    queue.addLast(queue.removeFirst());
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}