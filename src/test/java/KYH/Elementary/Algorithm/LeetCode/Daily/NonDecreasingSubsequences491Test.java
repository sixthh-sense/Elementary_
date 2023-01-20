package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NonDecreasingSubsequences491Test {

    NonDecreasingSubsequences_491 nonDecreasingSubQ = new NonDecreasingSubsequences_491();

    @Test
    void case1() {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(Arrays.asList(4, 6), Arrays.asList(4, 6, 7), Arrays.asList(4, 6, 7, 7), Arrays.asList(4, 7), Arrays.asList(4, 7, 7), Arrays.asList(6, 7), Arrays.asList(6, 7, 7), Arrays.asList(7, 7))) ;
        List<List<Integer>> actual = nonDecreasingSubQ.findSubsequences(nums);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void case2() {
        int[] nums = {4, 4, 3, 2, 1};
        List<List<Integer>> expected = new ArrayList<>(List.of(Arrays.asList(4, 4))) ;
        List<List<Integer>> actual = nonDecreasingSubQ.findSubsequences(nums);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}