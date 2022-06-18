package KYH.Elementary.Algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountingBrackets {
    public static void main(String[] args){
        int n = 2;
        CountingBrackets minDistance = new CountingBrackets();
        System.out.println("answer: " + minDistance.solution(n));

    }
    public int solution(int n) {
        // 앞쪽에서부터 차곡차곡 쌓이는 상태 상정
        // 숫자상으론 같은 (2, 1) -> (2, 2)더라도 (()에서 (())이 되냐 ()(에서 ()()이 되냐의 차이
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // {열린괄호, 닫힌괄호}
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            System.out.println(Arrays.toString(pair));
            int open = pair[0];
            int close = pair[1];
            if (open > n) continue; // 열린괄호 개수는 제한 넘는 것 불가능
            if (open < close) continue; // 열린괄호가 닫힌괄호보다 덜 있어도 탈락
            if (open + close == 2 * n) { // 개수가 맞을 때 답 + 1
                answer += 1;
                continue;
            }
            queue.offer(new int[]{open + 1, close}); // 열린괄호부터 더하고 닫힌괄호 나중에
            queue.offer(new int[]{open, close + 1});
            System.out.println("---");
        }
        return answer;
    }
}
