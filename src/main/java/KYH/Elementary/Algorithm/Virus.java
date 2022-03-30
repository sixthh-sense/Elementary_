package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://infodon.tistory.com/97
// https://www.acmicpc.net/problem/2606
public class Virus { // 링크가 있으면 그냥 걸리는 형태의 바이러스.
    // dfs 메소드(main메소드 별개) 용
    static boolean[] check;
    static int[][] arr;
    static int count = 0;

    static int node, line;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 컴퓨터의 수(100 이하)
        node = Integer.parseInt(br.readLine());
        // 연결 개수
        line = Integer.parseInt(br.readLine());

        // 연결이 되었는지 여부
        arr = new int[node+1][node+1];
        // 바이러스 걸린 상태 여부
        check = new boolean[node+1];

        // 연결(링크) 정보
        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            // 1 2나 2 1이나 연결됐다는 정보값은 같음. "연결된" 상태의 값을 1로 지정
            arr[a][b] = arr[b][a] =  1;
        }

        // "1번" 컴퓨터가 바이러스에 걸렸을 경우를 추정 -> 초기 입력값은 1
        dfs(1);
        // 반복문 구조상 마지막에 count 1개 더 높게 나옴
        bw.write(count - 1 + "");
        bw.flush();
        bw.close();
        br.close();

    }
    public static void dfs(int start) {
        check[start] = true; // 시작점(1번 컴퓨터) 바이러스 걸린 애임
        count++; // 걸린 컴퓨터 카운트 +1

        for(int i = 0 ; i <= node ; i++) { // 컴퓨터 개수의 경우의 수 만큼 고려
            // 시작점 -> 도착점 연결된 상태 && 링크가 있는데 바이러스 안 걸렸다고 나왔네? -> 걸렸다고 재정의
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }
    }
}