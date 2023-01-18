package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumCircularSubarray918Test {

    MaximumSumCircularSubarray_918 maxSum = new MaximumSumCircularSubarray_918();

    @Test
    void case1() {
        int actual = maxSum.maxSubarraySumCircular(new int[] {1, -2, 3, -2});
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int actual = maxSum.maxSubarraySumCircular(new int[] {5, -3, 5});
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        int actual = maxSum.maxSubarraySumCircular(new int[] {-3, -2, -3});
        int expected = -2;
        assertEquals(expected, actual);
    }
}