package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.Stack;

// 참고 사이트: https://oper6210.tistory.com/66, https://fbtmdwhd33.tistory.com/172
// https://www.acmicpc.net/problem/10828
// Scanner로 하니 시간 초과 -> BufferedReader&BufferedWriter로
public class Stack_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Stack 객체 생성. 정수형 담는 구조니 Integer.
        Stack<Integer> stack = new Stack<>();

        // 동일.
        for(int i = 0; i < n; i++) {
            String cons = br.readLine();

            if(cons.contains("push")) {
                // String 집합 spt -> "push", "(정수형)" 꼴 (입력 시 띄어쓰기로 구분됨)
                String[] spt = cons.split(" ");
                // String(spt의 두번째 항목 -> index가 1)을 정수형으로 바꿔서 정수형 stack에 추가
                stack.push(Integer.parseInt(spt[1]));

            } else if (cons.contains("pop")) {
                // 여기서 나오는 \n은 줄바꿈 표시
                if (stack.empty()) bw.write(-1 + "\n"); // 별도의 empty() 체크가 필요하다.
                else bw.write(stack.pop() + "\n");

            } else if (cons.contains("size")) {
                bw.write(stack.size() + "\n");

            }else if (cons.contains("empty")) {
                if (stack.empty()) bw.write(1 + "\n"); // 별도의 empty() 체크가 필요하다.
                else bw.write(0 + "\n");

            } else if (cons.contains("top")) { // 동일.
                if(stack.empty()) bw.write(-1 + "\n");	// 별도의 empty() 체크가 필요하다.
                else bw.write(stack.peek() + "\n");
            }
        }

        // resource 반환
        bw.flush();
        bw.close();
        br.close();

    }
}
