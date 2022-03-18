package KYH.Elementary.Algorithm;

import java.util.Scanner;

// #2839 https://www.acmicpc.net/problem/2839
public class SugarDelivery {

    public static void main(String[] args) {
        // BufferedReader 로 하는 방법도 있으니 좀더 알아볼 것
        // 설탕 kg -> 5의 배수 우선, 3의 배수 나중 -> 둘 다 아닐 경우 -1

        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();

        int count = 0;

        while (kg > 2) { // 5의 배수 뭉텅이로 빼고 3씩 빼기 -> 3을 빼야 하니 2이하로 떨어지면 안 됨. 반복문 조건화
            if (kg % 5 == 0) { // 반복문 안에 있는 조건문이라 처음에 체크 -> 3씩 뺄 때마다 계속 체크
                count += kg / 5; // 5로 나누어떨어질 경우 그 몫을 가방에 더하기
                kg = 0; // 사실 없어도 되는 부분이지만 조건문 쓰기 쉽게 하려고 넣음
                break;
            } else {
                kg -= 3;
                count++;
            }
        }

        // 나누어떨어지면 count
        if (kg == 0) System.out.println(count);
        // 나머지가 남으면(즉 3, 5의 배수들의 합으로 커버가 안 되는) -1
        else System.out.println(-1);

//        if (kg < 3 && kg > 0) System.out.println(-1);
//        else System.out.println(count);
    }

    //출처: https://no-dev-nk.tistory.com/41 [좀 모자란 개발 블로그]
}
