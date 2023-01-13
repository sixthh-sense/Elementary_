package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfNodesInTheSubTreeWithTheSameLabel1519Test {
    // object가 다르다고 test fail 나옴. 데이터 값 자체는 동일

    @Test
    void countSubTrees() {
        assertAll(
                () -> test(7, new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd", new int[] {2,1,1,1,1,1,1}),
                () -> test(4, new int[][] {{0, 1}, {1, 2}, {0, 3}}, "bbbb", new int[] {4, 2, 1, 1}),
                () -> test (5, new int[][] {{0, 1}, {0, 2}, {1, 3}, {0, 4}}, "aabab", new int[] {3, 2, 1, 1, 1})
        );
    }

    private void test(int n, int[][] edges, String labels, int[] expected) {
        NumberOfNodesInTheSubTreeWithTheSameLabel_1519 sameLabel = new NumberOfNodesInTheSubTreeWithTheSameLabel_1519();
        int[] actual = sameLabel.countSubTrees(n, edges, labels);
        assertEquals(expected, actual);
    }
}