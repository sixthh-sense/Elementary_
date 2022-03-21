package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.Stack;

// 참고 사이트: https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-9012%EB%B2%88-%EA%B4%84%ED%98%B8-%EC%9E%90%EB%B0%94
// https://www.acmicpc.net/problem/9012
public class Brackets {
    public static void main(String[] args) throws IOException {

        // Scanner보다 BufferedReader가 약 2배 정도 더 빠름
        // IOException은 필수로 throw해야 하던데 저거 정체가 뭔지;;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else { // else if와 else 밑에 if가 있는 거랑 다르겠지 아마...?
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
