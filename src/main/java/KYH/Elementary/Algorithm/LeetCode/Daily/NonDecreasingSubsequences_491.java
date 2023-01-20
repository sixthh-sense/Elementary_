package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences_491 {
    // 시작점과 종점 nC2 = n * (n - 1) / 2
    // Arrays.sort()를 한 결과물과 맞지 않으면 빼는 걸로 해도 될 것 같긴 한데 Time limit exceeded 될 것 같다
    // 다른 subsequence 문제와 헷갈릴 뻔했는데 여기서는 기존 숫자배열에서 고를 때 "연속되지 않아도 괜찮음"
    // call recursively 이 표현 주의

    private static void backtrack(int[] nums, int index, List<Integer> sequence, Set<List<Integer>> answer) {
        int length = nums.length;
        if (index == length) {
            if (sequence.size() >= 2) {
                answer.add(new ArrayList<>(sequence));
            }
            return;
        }
        if (sequence.isEmpty() || sequence.get(sequence.size() -1) <= nums[index]) {
            sequence.add(nums[index]);
            backtrack(nums, index + 1, sequence, answer);
            sequence.remove(sequence.get(sequence.size() - 1));
        }
        backtrack(nums, index + 1, sequence, answer);
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();
        backtrack(nums, 0, sequence, answer);
        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }
}