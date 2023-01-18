package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipStringToMonotoneIncreasing926Test {

    @Test
    void case1() {
        String s = "00110";
        int expected = 1;
        int actual = FlipStringToMonotoneIncreasing_926.minFlipsMonoIncr(s);
        assertEquals(actual, expected);
    }

    @Test
    void case2() {
        String s = "010110";
        int expected = 2;
        int actual = FlipStringToMonotoneIncreasing_926.minFlipsMonoIncr(s);
        assertEquals(actual, expected);
    }

    @Test
    void case3() {
        String s = "00011000";
        int expected = 2;
        int actual = FlipStringToMonotoneIncreasing_926.minFlipsMonoIncr(s);
        assertEquals(actual, expected);
    }
}