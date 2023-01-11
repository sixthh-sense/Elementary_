package KYH.Elementary.Algorithm.Baekjoon;

import java.io.*;
import java.util.Arrays;
//import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1037
public class Divisor {
    public static void main(String[] args) throws IOException {
        // 약수 리스트 -> 최소값이랑 최대값 곱하기.
        // 약수가 1개일 경우가 좀 걸렸는데 그 경우엔 최소값 = 최대값이니 그냥 곱해줘도 OK

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(br.readLine());
        int[] list = new int[numbers];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numbers; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 그냥 sort하면 오름차순. 내림차순이어도 상관은 없음.
        // sort 말고도 min, max value 삼항연산자 등을 통해서 구할 수도 있음. 요지는 최소/최대값 구하기
        Arrays.sort(list);
        bw.write(list[0] * list[numbers-1] + "");
        bw.flush();
        bw.close();
        br.close();

        //System.out.println(list[0] * list[numbers-1]);

    }
}
