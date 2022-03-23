package KYH.Elementary.Algorithm;

import java.io.*;

// 참고 사이트: https://st-lab.tistory.com/180
// https://www.acmicpc.net/problem/4949
public class BalancedWorld {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String sentence = br.readLine();
            if (sentence.equals(".")) {
                break;
            }
            bw.write(balance(sentence) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static String balance(String s) {

        char[] set = new char[s.length()];
        int size = 0;

        for (char letter : s.toCharArray()) {
            // 여는 괄호일 때 괄호를 마지막 인덱스에 넣어놓고 크기 1 증가
            if (letter == '(' || letter == '[') {
                set[size] = letter;
                size += 1;
                // 닫는 소괄호가 나올 때
            } else if (letter == ')') {
                // 아무것도 없거나 전 원소가 (이 아닐 때 -> ([)] 형태도 허용 X
               if (size == 0 || set[size-1] != '(') {
                    return "no";
                } else { // 사이즈를 줄여서 원소까지 없애버림?
                    size -= 1;
                }
                // 닫는 대괄호가 나올 때
            } else if (letter == ']') {
                if (size == 0 || set[size -1] != '[') {
                    return "no";
                } else {
                    size -= 1;
                }
            }
        }
        return size != 0 ? "no" : "yes";
    }
}
