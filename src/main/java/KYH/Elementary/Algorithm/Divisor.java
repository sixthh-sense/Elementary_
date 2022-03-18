package KYH.Elementary.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1037
public class Divisor {
    public static void main(String[] args) {
        // 약수 리스트 -> 최소값이랑 최대값 곱하기.
        // 약수가 1개일 경우가 좀 걸렸는데 그 경우엔 최소값 = 최대값이니 그냥 곱해줘도 OK

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int[] list = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            list[i] = sc.nextInt();
        }

        // 그냥 sort하면 오름차순. 내림차순이어도 상관은 없음.
        Arrays.sort(list);

        System.out.println(list[0] * list[numbers-1]);

    }
}
