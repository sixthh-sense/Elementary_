package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeToCollectAllApplesInATree1443Test {

    @Test
    void minTime() {
        assertAll(
                () -> test(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, new ArrayList<Boolean>(Arrays.asList(false, false, true, false, true, true, false)), 8),
                () -> test(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, new ArrayList<Boolean>(Arrays.asList(false, false, true, false, false, true, false)), 6),
                () -> test(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, new ArrayList<Boolean>(Arrays.asList(false, false, false, false, false, false, false)), 0)
        );
    }

    private void test(int n, int[][] edges, List<Boolean> hasApple, int expected) {
        MinimumTimeToCollectAllApplesInATree_1443 minimumTimeToCollectAllApplesInATree_1443 = new MinimumTimeToCollectAllApplesInATree_1443();
        int actual = minimumTimeToCollectAllApplesInATree_1443.minTime(n, edges, hasApple);
        assertEquals(actual, expected);
    }
}