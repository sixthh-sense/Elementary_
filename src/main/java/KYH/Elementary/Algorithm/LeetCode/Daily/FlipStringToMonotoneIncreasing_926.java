package KYH.Elementary.Algorithm.LeetCode.Daily;

public class FlipStringToMonotoneIncreasing_926 {
    public static int minFlipsMonoIncr(String s) {
        int length = s.length();
        int answer = 0, oneCount = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i); // String 0 - int 48, String 1 - int 49
            if (c == 49) {
                oneCount += 1;
            } else if (c == 48) {
                answer = Math.min(oneCount, answer + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
