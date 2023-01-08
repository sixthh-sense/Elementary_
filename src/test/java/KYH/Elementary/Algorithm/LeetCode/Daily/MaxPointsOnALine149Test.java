package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPointsOnALine149Test {

    @Test
    void maxPoints() {
        assertAll(
                () -> test(new int[][] {{1, 1}, {2, 2}, {3, 3}}, 3),
                () -> test(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}, 4)
        );
    }

    private void test(int[][] points, int expected) {
        MaxPointsOnALine_149 maxPointsOnALine149 = new MaxPointsOnALine_149();
        int actual = maxPointsOnALine149.maxPoints(points);
        assertEquals(expected, actual);
    }
}