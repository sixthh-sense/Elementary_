package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://iseunghan.tistory.com/186
// https://www.acmicpc.net/problem/1002
public class Turret {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // 좌표와 레이더 값 주어짐 -> 레이더가 교차하는 곳이 "류승환"이 있는 장소
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 피타고라스의 정리? (x1, y1)와 (x2, y2) 사이의 거리
            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (d == 0 && r1 == r2) { // 원이 겹치니 가능성 있는 데가 선(원 -> 무한대)이네?
                bw.write("-1");
                // 원 교차
            } else if (d > Math.abs(r2 - r1) && d < r1 + r2) { // Math.abs는 절대값
                bw.write("2");
            } else if (Math.abs(r2 - r1) == d || r2 + r1 == d) { // 접점
                bw.write("1");
            } else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) { // 원 안 만남 (d==0이 좀 위험하긴 한데 위의 if문에서 걸러짐?
                bw.write("0");
            }
            // for문 하나 돌 때마다 줄바꿈 한 번씩
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
