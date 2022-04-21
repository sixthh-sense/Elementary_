package KYH.Elementary.Algorithm;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10869
public class ArithmeticOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write((A + B) + "\n" + (A - B) + "\n" + (A * B) + "\n" + (A / B) + "\n" + (A % B));
        bw.flush();
        bw.close();
        br.close();
    }
}
