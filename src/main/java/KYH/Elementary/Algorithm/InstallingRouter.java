package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/277 -> 설명은 예쁜데 납득은 안 되는 부분이 몇몇 있음
// https://www.acmicpc.net/problem/2110
public class InstallingRouter {
    public static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 집의 개수
        int N = Integer.parseInt(st.nextToken());
        // 설치할 공유기의 수
        int M = Integer.parseInt(st.nextToken());
        // 집의 위치
        house = new int[N];
        for (int i = 0; i < N; i++) {
            // 집의 위치값 채워넣기
            house[i] = Integer.parseInt(br.readLine());
        }

        // 이분 탐색을 위한 집 위치 오름차순 정렬
        Arrays.sort(house);

        int low = 1; // 최소 거리(최소값)
        int high = house[N -1] - house[0]; // 최소 거리(최대값) -> 위치 정보라서 1을 더해줘야 함
        int answer = 0;

        while (low <= high) { // canInstall(mid) == M 이라고 해도 되지 않을까? ... 값이 다르게 나오네.
            // 평균값이지만 소수일 경우 자동버림 && mid는 반복문 안에서 계속 달라져야 할 값이라서 두 값의 평균이라는 식은 반복문 안에 위치해야 함
           int mid = (low + high) / 2;
            // 공유기 설치 가능 대수 구하는 함수
            if (canInstall(mid) < M) { // 간격: 전체 거리의 0.5로 안 되면 -> 0.25(공유기 수가 너무 적음) 혹은 0.75(공유기 수가 너무 많음) 식으로 계속 실험해가며 탐색
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = mid;
            }
        }

        bw.write(answer + ""); // mid를 적고 싶었으나 반복문 마지막 단계가 제대로 적용이 안 되는 듯해서 별도의 변수 생성해 입력. high + 1는 답이 아니지만 low - 1 는 답 ok. else 부분이 중요하네(?)
        bw.flush();
        bw.close();
        br.close();
    }

    public static int canInstall(int distance) {
        // 설치 가능 공유기 개수(초기화 상태)
        int count = 1;
        // 마지막 위치 정보(초기화 상태): 첫 번째 집 위치
        int lastLocation = house[0];

        for (int i = 1; i < house.length; i++) { // 0번째 다음은 1 -> 1번째 집이 "다음 위치"의 첫 번째
            // 0~1번째 || 1~2번째 || ... = distance
            int location = house[i];
            if (location >= distance + lastLocation) {
                // 다음 공유기의 위치가 현재 위치 + 간격보다 크거나 같을 때 공유기 설치 가능
                count++;
                // lastLocation을 그대로 두면 첫번째 점하고만 계속 비교를 할 테니 "다음" 점이라고 지정해줘서 인접한 각 지점들의 사이간격을 나타냄
                lastLocation = location;
            }
        }// 그렇게 "세는 게 가능한" 횟수 = 공유기 설치 가능 대수
        return count;
    }
}
