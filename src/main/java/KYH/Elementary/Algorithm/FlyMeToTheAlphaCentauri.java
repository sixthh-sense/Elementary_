package KYH.Elementary.Algorithm;

import java.util.Scanner;

// #1011: https://www.acmicpc.net/problem/1011
public class FlyMeToTheAlphaCentauri {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();	// 테스트 케이스

        for(int i = 0; i < T; i++) {

            int X = in.nextInt();
            int Y = in.nextInt();

            int distance = Y - X;	// 거리

            int max = (int)Math.sqrt(distance);	// 정수형 정의 -> 자동 소수점 버림 (법칙은 직접 찾는 수밖에 없나?)

            if(distance == max * max) {
                System.out.println(max * 2 - 1);
            }
            else if(distance <= max * max + max) {
                System.out.println(max * 2);
            }
            else {
                System.out.println(max * 2 + 1);
            }

        }
    }
}
