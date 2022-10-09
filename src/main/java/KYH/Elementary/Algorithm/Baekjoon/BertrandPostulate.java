package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
//import java.util.Scanner;

// https://www.acmicpc.net/problem/4948
public class BertrandPostulate {
    // n 최대값 123456, n은 자연수 & index 형태 고려해서 +1
    public static boolean[] list = new boolean[(2 * 123456) + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        get_prime();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;	// n 이 0 일경우 종료

            int count = 0;	// 소수 개수를 셀 변수

            for(int i = n + 1; i <= 2 * n; i++) {
                // false일 때 소수 -> count 증가
                if(!list[i]) count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    // 소수 구분 메소드 (boolean은 디폴트가 false -> 소수가 아닌 걸 골라 true로 설정해주기)
    public static void get_prime() {
        // '0'과 '1'은 소수가 아니니 true
        list[0] = list[1] = true;

        for(int i = 2; i <= Math.sqrt(list.length); i++) { // 제곱근부터 따지기

           if(list[i]) continue;

            for(int j = i * i; j < list.length; j += i) { // 무언가의 제곱이니까 소수 탈락 -> true -> 무언가의 배수인 것도 죄다 소수 탈락
                list[j] = true;
            }
        }
    }

//    // 전체 맵(2n 최대값 246912) 참고 사이트: https://st-lab.tistory.com/85 (이 문제는 개념부터 시작해서 모르는 게 많았음)
//    public static boolean[] prime = new boolean[246913];
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        get_prime();	// 소수를 얻는 메소드 실행
//
//        while(true) {
//            int n = in.nextInt();
//            if(n == 0) break;	// n 이 0 일경우 종료
//
//            int count = 0;	// 소수 개수를 셀 변수
//
//            for(int i = n + 1; i <= 2 * n; i++) {
//                // false일 때 소수 -> count 증가
//                if(!prime[i]) count++;
//            }
//            System.out.println(count);
//        }
//    }
//
//    // 소수를 얻는 메소드
//    public static void get_prime() {
//        // 0 과 1 은 소수가 아니므로 참
//        prime[0] = prime[1] = true;
//
//        for(int i = 2; i <= Math.sqrt(prime.length); i++) { // 제곱근부터 따지기
//           if(prime[i]) continue;
//            for(int j = i * i; j < prime.length; j += i) { // 무언가의 제곱이니까 소수 탈락 -> true -> 무언가의 배수인 것도 죄다 소수 탈락
//                prime[j] = true;
//            }
//        }
//    }
}
