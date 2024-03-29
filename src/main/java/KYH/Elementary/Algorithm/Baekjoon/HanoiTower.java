package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

// 참고 사이트: https://brenden.tistory.com/31
// https://www.acmicpc.net/problem/11729
public class HanoiTower {
    // 1 <= N <= 20

    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

    // from에 꽂혀있는 num개의 원반을 by를 거쳐 to로 이동한다.
    public static void moveHanoiTower(int num, int from, int by, int to) {
        ++answer;
        // 이동할 원반의 수가 1개라면?
        if(num == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            // STEP 1 : num-1개를 A에서 B로 이동
            moveHanoiTower(num-1, from, to, by);
            // STEP 2 : 1개를 A에서 C로 이동
            sb.append(from + " " + to + "\n");
            // STEP 3 : num-1개를 B에서 C로 이동
            moveHanoiTower(num-1, by, from, to);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // num개를 A에서 C로 이동(자연스럽게 B 경유)
        moveHanoiTower(num, 1, 2, 3);
        sb.insert(0, answer + "\n");
        System.out.println(sb);
    }
}
