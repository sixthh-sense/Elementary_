package KYH.Elementary.Algorithm;

public class SelfNumber {

    public static void main(String[] args){

        // check length -> [], 문제에서 요구하는 index는 10000(ArrayIndexOutOfBoundsException피하려면 10000이상의 값 필요)
        boolean[] check = new boolean[10001];
        // boolean default -> false 상태

        for (int i = 1; i < 10001; i++){
            int n = cons(i); // i번째 수의 생성자 = 정수 n -> 생성자 있는 걸 true 처리

            if(n < 10001){	// 10000이 넘는 수는 고려 X (index 범위 맞추기 위한 if문)
                check[n] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {   //1부터 10000까지 돌려서 false만 출력 (초과 범위는 상정 X)
            if (!check[i]) {
                System.out.println(i); // 생성자 없는 걸 찾으랬으니 false 쪽을 출력
            }
        }

    }

    public static int cons(int number) {	// 생성자 구하는 함수(constructor의 약자)
        int sum = number;

        while (number >= 1) { // 대상(number)가 양의 정수일 때
            sum += (number % 10); // "일"의 자리수
            number = number / 10;	// 10을 나누어 "십"의 자리수를 "일"의 자리수로 바꿈
        }

        return sum;
    }
}
