package KYH.Elementary.Algorithm.LeetCode.Daily;

/*
* official solution link: https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/2868539/maximum-sum-circular-subarray/
* [!] 혼자서 못 품
* [!] 1번째 해설 이해 못 함
* [!!!] 많은 공부가 더 필요
* */
public class MaximumSumCircularSubarray_918 { // 얘는 문제  자체가 어렵다기보단 개념 이해가 너무 힘듬;;
    // 몇 번 더 읽고 나서야 문제 파악이 됨: circular 뜻은 nums array에 나온 원소들이 빙빙 돈다는 말
    // subarray는 원래라면 처음과 끄트머리가 닿을 수 없었겠지만 circular array안의 subarray라서 '이어진다'는 개념 하에 그게 가능
    // 15 ~ 30분 정도 고민하고 공식 해설 열람.
    // 공식 해설 #1 은 이해가 잘 안 됨, #2 해설은 이해가 됨
    // -> '최대값'을 부르는 시작점, 종점을 직접 지정하기보다 전체 요소 더한 값 - (최소값) 을 구하면 그게 곧 최대값
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, curMax = 0, curMin = 0, maxSum = nums[0], minSum = nums[0];
        for (int num : nums) {
            totalSum += num;
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(curMax, maxSum);

            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(curMin, minSum);
        }
        return (totalSum == minSum) ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}
