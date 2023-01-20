package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NonDecreasingSubsequences491Test {

    @Test
    void case1() { // 순서가 다르다고 틀리게 처리됨;; 보완 방법 생각하기
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(Arrays.asList(4, 6), Arrays.asList(4, 6, 7), Arrays.asList(4, 6, 7, 7), Arrays.asList(4, 7), Arrays.asList(4, 7, 7), Arrays.asList(6, 7), Arrays.asList(6, 7, 7), Arrays.asList(7, 7))) ;
        List<List<Integer>> actual = NonDecreasingSubsequences_491.findSubsequences(nums);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void case2() {
        int[] nums = {4, 4, 3, 2, 1};
        List<List<Integer>> expected = new ArrayList<>(List.of(Arrays.asList(4, 4))) ;
        List<List<Integer>> actual = NonDecreasingSubsequences_491.findSubsequences(nums);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}