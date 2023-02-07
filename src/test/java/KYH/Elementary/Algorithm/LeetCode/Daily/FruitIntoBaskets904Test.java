package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBaskets904Test {

    @Test
    void case1() {
        test(new int[]{1, 2, 1}, 3);
    }

    @Test
    void case2() {
        test(new int[]{0, 1, 2, 2}, 3);
    }

    @Test
    void case3() {
        test(new int[]{1, 2, 3, 2, 2}, 4);
    }

    private void test(int[] fruits, int expected) {
        FruitIntoBaskets_904 fruitBaskets = new FruitIntoBaskets_904();
        int actual = fruitBaskets.totalFruit(fruits);
        assertEquals(expected, actual);
    }
}