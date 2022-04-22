package KYH.Elementary.Algorithm;

import java.io.*;
//import java.util.Scanner;

// #1316
public class GroupWordCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String sentence = br.readLine();
            boolean[] check = new boolean[26]; // 알파벳 개수(사용 내역 체크용)
            boolean isGroup = true; // 그룹 단어인지 여부

            for (int j = 0; j < sentence.length(); j++) {
                int index = sentence.charAt(j) - 'a'; // 알파벳 소문자 only
                if (check[index]) { // 이전에 사용한적이 있는 문자라면
                    if (sentence.charAt(j) != sentence.charAt(j - 1)) { // 이전 문자와 연속되지 않는다면
                        isGroup = false; // 그룹 단어가 아님
                        break;
                    }
                } else { // 이전에 사용한적이 없는 문자라면
                    check[index] = true; // 문자 사용 체크
                }
            }
            if (isGroup) count++;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int cnt = 0; // 그룹 단어 개수
//
//        for (int i = 0; i < N; i++) {
//            String S = sc.next();
//            boolean[] check = new boolean[26]; // 알파벳 사용 내역
//            boolean tmp = true; // 그룹 단어 인지
//
//            for (int j = 0; j < S.length(); j++) {
//                // a 대신 A를 하면 ArrayIndexOutOfBoundsException
//                int index = S.charAt(j) - 'a';
//                if (check[index]) { // 이전에 사용한적이 있는 문자라면
//                    if (S.charAt(j) != S.charAt(j - 1)) { // 이전 문자와 연속되지 않는다면
//                        tmp = false; // 그룹 단어가 아님
//                        break;
//                    }
//                } else { // 이전에 사용한적이 없는 문자라면
//                    check[index] = true; // 문자 사용 체크
//                }
//            }
//            // true일 때마다 count 올라가기
//            if (tmp) cnt++;
//        }
//
//        System.out.println(cnt);
//    }
}
