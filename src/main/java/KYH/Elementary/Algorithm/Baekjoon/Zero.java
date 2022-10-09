package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;
import java.util.Stack;

// 참고 사이트: https://velog.io/@nan0na/%EB%B0%B1%EC%A4%80-10773%EB%B2%88-%EC%A0%9C%EB%A1%9C-Java
// https://www.acmicpc.net/problem/10773
public class Zero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        sc.close(); //-> 이건 필수로 써줘야 하나(?)

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        } // 아니면 그냥 for문 돌려서 stack 죄다 더할 수도.
        System.out.println(sum);

    }
}
