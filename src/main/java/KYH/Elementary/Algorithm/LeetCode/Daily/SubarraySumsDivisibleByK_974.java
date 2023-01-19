package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.Arrays;

public class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int length = nums.length;
        int answer = 0, start = 0, arraySum = 0;
        while (start < length) {
            for (int i = start; i < length; i++) {
                arraySum += nums[i];
                if (arraySum % k == 0) {
                    answer += 1;
                }
            }
            arraySum = 0;
            start += 1;
        }
        return answer;
    }
}
