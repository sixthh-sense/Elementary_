package KYH.Elementary.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

// 참고 사이트: https://velog.io/@kimjy199/%EB%B0%B1%EC%A4%80-11651%EB%B2%88.-%EC%A2%8C%ED%91%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-2Java
// https://www.acmicpc.net/problem/11651
public class SortingCoordinates2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1줄마다 좌표 1개씩 옴 -> A B 식. A가 i번째 줄의 0번째 index, B가 i번째 줄의 1번째 index
        // 0, 1 포괄해야 하니 [][] 뒤쪽 사이즈는 2로. -> 길이가 2이고 높이가 N인 직사각형을 좌표 map화한다고 생각하면 쉬움
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // sort는 오름차순(default)
        Arrays.sort(arr, (o1, o2) -> {
            // y좌표가 같을 때만 x좌표 비교
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                // y좌표가 다르면 y좌표끼리 비교
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 그렇게 정렬된 array의 각 항목들을 출력합시다
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
