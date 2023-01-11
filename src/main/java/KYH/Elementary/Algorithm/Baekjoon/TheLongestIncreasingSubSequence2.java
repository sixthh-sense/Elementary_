package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 제일 마음에 드는 설명: https://velog.io/@goshk95/%EB%B0%B1%EC%A4%80-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B42-12015%EB%B2%88-Java
// https://honeywater97.tistory.com/164 좋아보이는데 lower bound 개념에서 헷갈림
// https://gre-eny.tistory.com/23
// https://dragon-h.tistory.com/2 -> >> 가 무슨 뜻인지 모르겠음
// https://www.acmicpc.net/problem/12015
public class TheLongestIncreasingSubSequence2 { // 1과 비교했을 때 수열 A의 크기 N이 증가한 상태
    // 자료 구조 형태가 정말로 상관이 없는 걸까? 삽입/삭제 쉬운 자료 구조 추천
    static Stack<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Ai = new int[N]; // 입력된 값

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        list = new Stack<>(); // 답안에 쓸 녀석
        list.add(0); // empty 피하기 위함 && "맨 처음" 비교할 대상이 필요
        for (int target : Ai) { // 이렇게 해도 초항부터 "순서대로" 탐색 가능
            if (list.peek() < target) list.add(target);
            // 완벽한 LIS 방식은 아님. 하지만 최장 수열의 개수만 구하는 문제이기에 이런 식으로 해도 상관은 없음
            else list.set(binarySearch(target, 0, list.size() - 1), target); // 0 10 20일 때 5가 있다 치면 0 5 20으로 바뀌는 식
        }

//        for (int target : list) {
//            System.out.println(target);
//        }

        bw.write((list.size() - 1) + ""); // 맨 앞자리에 0을 더해줘서 그 부분 뺌
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int target, int low, int high) {
        while (low < high) { // lower-bound
            int mid = (low + high) / 2;
            if (target <= list.get(mid))  {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
