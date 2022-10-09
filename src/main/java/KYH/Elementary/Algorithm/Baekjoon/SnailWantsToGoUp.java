package KYH.Elementary.Algorithm.Baekjoon;

import java.util.Scanner;

public class SnailWantsToGoUp {
    // A - B 씩 하루에 이동하지만 마지막에는 A만큼 올라감 -> V - A 미터를 A - B /일씩 올라가는 데 며칠 걸리나?
    // 백준 사이트에서는 BufferedReader로 해야 시간 초과에 안 걸림
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int night = sc.nextInt();
        int height = sc.nextInt();

        int time = (height - day) / (day - night);
        if ((height-day) % (day-night) != 0) {
            time += 1;
        }

        System.out.println(time + 1);
    }
}
