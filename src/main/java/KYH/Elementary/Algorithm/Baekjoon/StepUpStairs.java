package KYH.Elementary.Algorithm.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 왜 ArrayIndexOutOfBounds가 나올까?
//https://sundries-in-myidea.tistory.com/22 [얇고 넓은 개발 블로그]
// https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2579-%EA%B3%84%EB%8B%A8-%EC%98%A4%EB%A5%B4%EA%B8%B0-JAVA%EC%9E%90%EB%B0%94
// https://www.acmicpc.net/problem/2579
public class StepUpStairs {
    // 도착 지점으로 가는 경우의 수 case 별로 따져서 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 계단의 개수
        int T = Integer.parseInt(br.readLine());
        // 각 계단에 적힌 점수
        int[] stairs = new int[T+1];

        // 각 계단에 점수 입력
        for(int i = 1; i<=T; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // n번째 계단 -> 최대값 배열 (T개니까 T+1 설정)
        int[] cache = new int[T+1];

        // 초기값 지정 : 연속된 "세 개의 계단"을 모두 밟아서는 안 됨 (n-3) -> (n-1) -> n이냐 (n-2) -> n이냐
        cache[1] = stairs[1];
        cache[2] = stairs[2] + stairs[1];
        cache[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        // 초기값 제외 ~ 끝항까지
        for(int i=4; i<=T; i++){
            // i번째 계단을 오르는 경우의 수 = 최대값 고르기 ((n-3) -> (n-1) -> n이냐 (n-2) -> n이냐)
            // i번째 계단은 기본적으로 얻고 i-2까지의 값이 더 크냐, i-3까지의 값에 i-1번째 계단 더한 값이 더 크냐
            cache[i] = Math.max(cache[i-3] + stairs[i-1], cache[i-2]) + stairs[i];
        }
        System.out.println(cache[T]);
    }
}

/* 왜 얘는 되는지 모르겠음. 다른 게 뭐임?
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = stairs[1];

        for (int i = 2; i <= n; i++) {
            if(i==2){
                dp[2] = stairs[1] + stairs[2];
            }else if(i==3){
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            }else{
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            }
        }

        System.out.println(dp[n]);
    }*/
