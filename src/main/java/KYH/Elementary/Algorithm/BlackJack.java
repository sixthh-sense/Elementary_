package KYH.Elementary.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/97
// https://www.acmicpc.net/problem/2798
public class BlackJack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 첫째 줄 카드의 개수(N) 카드의 최대 합(M)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 둘째 줄 카드 정보(각 카드에 적힌 수)
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }


    // 탐색
    static int search(int[] arr, int N, int M) {
        int result = 0;

        // Brute force 답게 for문 3개??
        // 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
        // j, k 존재 고려해서 < N을 < N -2로
        // j, k는 각각 i + 1, j + 1(즉 i + 2?) -> 중복된 인덱스 없음
        for (int i = 0; i < N - 2; i++) {
            // 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
            for (int j = i + 1; j < N - 1; j++) {
                // 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
                for (int k = j + 1; k < N; k++) {
                    // 3개 카드의 합 변수 temp
                    int temp = arr[i] + arr[j] + arr[k];

                    // M과 세 카드의 합이 같다면 temp return 및 종료
                    if (M == temp) {
                        return temp;
                    }

                    // "모든" 경우의 수에 적용하니 답(최대값)이 나옴
                    // 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
                    if(result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        // 모든 순회를 마치면 result 리턴
        return result;
    }
}
