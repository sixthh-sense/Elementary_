package KYH.Elementary.Algorithm;

import java.io.*;

// https://jackpot53.tistory.com/33(upper/lower bound)
// https://minhamina.tistory.com/127 (이진 탐색 설명)
// https://moonsbeen.tistory.com/233, https://st-lab.tistory.com/281 (lower bound를 써주는 이유까지 설명)
// https://www.acmicpc.net/problem/1300
public class KthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N은 10^5까지가 범위라서 다룰 배열의 범위가 제법 크다(long이 나오는 이유)
        int N = Integer.parseInt(br.readLine());
        // min(10^9, N^2)보다 작거나 같은 자연수
        int K = Integer.parseInt(br.readLine());

        // lower-bound 위주? (정확한 의미 이해X)
        int low = 1;
        int high = K;

        while (low < high) { // #1 lower bound 방식
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N); // i번째 열에서 mid이하인 숫자의 개수. N은 열의 크기라 N을 초과한 숫자의 개수는 있을 수 없음
            }
            if (K <= count) { // 이 부분의 등호를 빼니 백준에서 틀렸다고 나오네
                high = (int) mid;
            } else {
                low = (int) (mid + 1);
            }
        }
//        int answer = 0;
//        while (low <= high) { // #2
//            long mid = (low + high) / 2;
//            long count = 0;
//            for (int i = 1; i <= N; i++) {
//                count += Math.min(mid / i, N);
//            }
//            if (K <= count) {
//                high = (int) (mid - 1);
//                answer = (int) mid;
//            } else {
//                low = (int) (mid + 1);
//            }
//        }

        // #1
        bw.write(low + "");
        // #2
        //bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();

    }




    /* import java.util.Arrays;

    public static void main(String[] args) throws IOException { // 수가 적을 땐 이렇게 해도 되지만 이 문제에선 메모리가 초과됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] array = new int[N][N];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j<=N; j++) {
                array[i - 1][j - 1] = i * j;
            }
        }

        int[] result = new int[array.length * array[0].length];

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                result[(i * array[0].length) + j] = array[i][j];
//            }
//        }

        for (int i = 0; i < array.length; i++) { // 위의 식과 이 식이 같다니 너무 신기해
            System.arraycopy(array[i], 0, result, (i * array[0].length), array[0].length);
        }

        Arrays.sort(result);
        bw.write(result[K - 1] + "");
        bw.flush();
        bw.close();
        br.close();
    }*/
}
