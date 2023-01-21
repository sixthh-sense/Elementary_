package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.ArrayList;
import java.util.List;

// 0은 단독으로 쓰이거나 단독이 아닐 경우 맨 앞자리에 올 수 없다
// 한 덩어리는 1 ~ 3 개 가능
// 구역은 4 구역 필수
public class RestoreIPAddresses_93 {
    private boolean valid(String s, int start, int length) {
        return length == 1 ||
                (s.charAt(start) != '0' &&
                        (length < 3 ||
                                s.substring(start, start + length).compareTo("255") <= 0));
    }

    private void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        final int remainingLength = s.length() - startIndex; //  Q. is the "final" part really that important?
        final int remainingNumberOfIntegers = 4 - dots.size();
        if (remainingLength > remainingNumberOfIntegers * 3 ||
                remainingLength < remainingNumberOfIntegers) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s, last, last + dot);
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }
        for (int curPos = 1; curPos <= 3 && curPos <= remainingLength; ++curPos) {
            // Append a dot at the current position.
            dots.add(curPos);
            // Try making all combinations with the remaining string.
            if (valid(s, startIndex, curPos)) {
                helper(s, startIndex + curPos, dots, ans);
            }
            // Backtrack, i.e. remove the dot to try placing it at the next position.
            dots.remove(dots.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    /*public List<String> restoreIpAddresses(String s) { // s는 1에서 20까지 가능하다는데, 12개를 넘으면 사실상 불가능 아님?
        List<String> answer = new ArrayList<>();
        int length = s.length();
        if (length > 12 || length < 4) {
            return answer;
        }
        if (length == 4) { // a-bcd
            StringBuilder sb = new StringBuilder(s);
            sb.insert(1, ".");
            sb.insert(3, ".");
            sb.insert(5, ".");
            answer.add(sb.toString());
            return answer;
        }
        if (length == 12) { // abc def ghi jkl
            char[] chArray = s.toCharArray();
            if (chArray[0] == '0' || chArray[3] == '0' || chArray[6] == '0' || chArray[9] == '0') {
                return answer;
            } else {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(4, ".");
                sb.insert(8, ".");
                sb.insert(12, ".");
                answer.add(sb.toString());
                return answer;
            }

        }
        return answer;

    }*/
}
