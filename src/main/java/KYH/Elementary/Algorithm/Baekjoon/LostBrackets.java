package KYH.Elementary.Algorithm.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// - 뒤에 오는 수를 괄호 처리?
//참고 사이트: https://jainn.tistory.com/346 [Dogfootruler Kim]
// https://www.acmicpc.net/problem/1541
public class LostBrackets {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cal = br.readLine().split("-"); // 빼기를 기준으로 분리
        int res = 0;

        for (int i = 0; i < cal.length; i++) {
            int sum = 0;
            String[] cal2 = cal[i].split("\\+");
            for (String s : cal2) {
                sum += Integer.parseInt(s);
            }
            if (i == 0) {
                res += sum;
            } else {
                res -= sum;
            }
        }
        System.out.println(res);
    }
}
