package KYH.Elementary.Algorithm.LeetCode.Tutorial;

public class NumberOfStepsToReduceANumberToZero_1342 {
    /*
    * Given an integer num
    * return the number of steps to reduce it to zero
    *
    * in one step, if the current number is even, divide it by 2
    * otherwise subtract 1 from it
    * */


    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps(int num) {
        int answer = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
                answer++;
            } else {
                num -= 1;
                answer++;
            }
            // 여기에 answer++;를 공통격으로 써도 ok
        }
        return answer;
    }

    /* bitmask approach
    public static int numberOfSteps(int num) {
        int answer = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }
            answer++;
        }
        return answer;
    }*/
}
