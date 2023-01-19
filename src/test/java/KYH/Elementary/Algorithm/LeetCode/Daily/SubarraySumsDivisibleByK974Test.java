package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumsDivisibleByK974Test {

    SubarraySumsDivisibleByK_974 subArrayDiv = new SubarraySumsDivisibleByK_974();

    @Test
    void case1() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expected = 7;

        int actual = subArrayDiv.subarraysDivByK(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int[] nums = {5};
        int k = 9;
        int expected = 0;

        int actual = subArrayDiv.subarraysDivByK(nums, k);
        assertEquals(expected, actual);
    }
}