package KYH.Elementary.Algorithm;

public class SelfNumber {

    public static void main(String[] args){	// 메인

        // check length -> [], 문제에서 요구하는 index는 10000(ArrayIndexOutOfBoundsException피하려면 10000이상의 값 필요)
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++){
            int n = d(i);

            if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
                check[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {   //1부터 10000까지 돌려서 false만 출력
            if (!check[i]) {
                System.out.println(i);
            }
        }

    }

    public static int d(int number) {	// 함수
        int sum = number;

        while(number > 0){
            sum += (number % 10); // 첫 째 자리수
            number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
        }

        return sum;
    }
}
