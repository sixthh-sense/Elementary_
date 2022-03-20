package KYH.Elementary.Algorithm;

import java.util.Scanner;
import java.util.Stack;

// 참고 사이트: https://oper6210.tistory.com/66
// https://www.acmicpc.net/problem/10828
public class Stack_ {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> stack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int i=0; i<cnt; i++) {
            String input = sc.next();
            if(input.contains("push")) {
                int input2 = sc.nextInt();
                stack.push(input2);
            }else if(input.equals("pop")){
                System.out.println(stack.isEmpty()? -1 : stack.pop());
            }else if(input.equals("size")) {
                System.out.println(stack.size());
            }else if(input.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }else if(input.equals("top")) {
                System.out.println(stack.isEmpty()? -1 : stack.peek());
            }
        }
    }
}
