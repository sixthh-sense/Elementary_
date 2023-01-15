package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfGoodPaths2421Test {

    @Test
    void numberOfGoodPaths() {
        assertAll(
                () -> test(new int[] {1, 3, 2, 1, 3}, new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}}, 6) /*,
                () -> test(new int[] {1, 1, 2, 2, 3}, new int[][] {{0, 1}, {1, 2}, {2, 3}, {2, 4}}, 7),
                () -> test(new int[] {1}, new int[][] {{}}, 1)*/
        );
    }

    private void test(int[] vals, int[][] edges, int expected) {
        NumberOfGoodPaths_2421 number = new NumberOfGoodPaths_2421();
        int actual = number.numberOfGoodPaths(vals, edges);
        assertEquals(expected, actual);
    }
}