package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
// import java.util.Scanner;

public class OverAverage { // https://st-lab.tistory.com/51
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr;

        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0 ; i < testcase ; i++) {

            st = new StringTokenizer(br.readLine()," "); // 학생 수 및 성적 입력


            int N = Integer.parseInt(st.nextToken());	//학생 수
            arr = new int[N];

            double sum = 0;	// 성적 누적 합 변수

            // 성적 입력부분
            for(int j = 0 ; j < N ; j++) {
                int val = Integer.parseInt(st.nextToken());	// 성적 저장
                arr[j] = val;
                sum += val;	// 성적 누적 합
            }

            double mean = (sum / N) ;
            double count = 0; // 평균 넘는 학생 수 변수

            // 평균 넘는 학생 비율 찾기
            for(int j = 0 ; j < N ; j++) {
                if(arr[j] > mean) {
                    count++;
                }
            }

            System.out.printf("%.3f%%\n",(count/N)*100);


        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int c = sc.nextInt();
//        int n, total, count;
//        double avg;
//        int scores[] = new int[1000];
//
//        for (int i = 0; i < c; ++i) {
//            n = sc.nextInt();
//            total = 0;
//            count = 0;
//            for (int j = 0; j < n; ++j) {
//                scores[j] = sc.nextInt();
//                total += scores[j];
//            }
//            avg = (double)total / n;
//
//            for (int j = 0; j < n; ++j) {
//                if (scores[j] > avg) {
//                    count++;
//                }
//            }
//            System.out.printf("%.3f", 100.0 * count / n);
//            System.out.println("%");
//        }
//        sc.close();
//    }
}
