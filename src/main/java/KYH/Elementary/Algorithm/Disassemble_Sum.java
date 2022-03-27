package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2231
public class Disassemble_Sum {
    public static void main(String[] args) throws IOException {

        // Brute force
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 1; i <= N; i++) {
            int number = i; // 그냥 N번 연산을 한다 수준
            int sum = 0;	// 각 자릿수의 합

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기(일의 자리수부터)
                number /= 10; // 다음 자리수도 나머지로 구해야 하니 10으로 나누기
            }
            // 숫자 본인 + 각 자릿수 누적합이 같을 경우 (생성자)
            if(sum + i == N) {
                result = i; // i는 0부터 시작해서 점점 커짐. 제일 먼저 구한 값 = 최소값
                break;
            }
            // 생성자가 없는 경우는 어떻게?
        }

        System.out.println(result);
    }
}
