package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.Arrays;

public class SubarraySumsDivisibleByK_974 {
    //prefix sum: 구간 합(앞쪽에서 더하는 건 prefix 뒤쪽은 suffix)
    // modulo: 나머지 연산
    // dividend: 피제수 (나눌 제)
    // divisor: 제수
    // quotinent: 몫
    // remainder: 나머지

    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k;
            System.out.println("prefixMod: " + prefixMod);
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod]; // 이전에 기록된 나눗셈 값과 "같을" 때(즉 나눠떨어짐) 유의미한 값(0이 아닌)이 더해진다
            System.out.println("result: " + result);
            modGroups[prefixMod]++;
            System.out.println("modGroups_update: " + Arrays.toString(modGroups));
            System.out.println("--------------------------------------------------------------------------");
        }

        System.out.println("modGroups_complete: " + Arrays.toString(modGroups));

        return result;

        /* Time limit exceeded
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
        return answer; */
    }
}
