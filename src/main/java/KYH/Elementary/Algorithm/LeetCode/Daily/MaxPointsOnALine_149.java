package KYH.Elementary.Algorithm.LeetCode.Daily;

/* question link: https://leetcode.com/problems/max-points-on-a-line/
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
* */

/*
* 풀이 링크: https://hezhigang.github.io/2020/07/03/leetcode-algorithms-max-points-on-a-line/
* */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/* 풀이 방법 고민
- 직선에 있다는 걸 어떻게 인식시켜야 할까? 기울기로? 하지만 그 경우엔 수직/수평선의 경우는? 따로 계산?
- 경우의 수를 정렬하지 않고 일일이 구하는 게 맞을까 아니면 동일한 x좌표별로 구분하는 게 좋을까?
* */
public class MaxPointsOnALine_149 {
    public int maxPoints(int[][] points) {
        int answer = 0;
        int countPoints = points.length;
        for (int i = 0; i < countPoints; i++) {
            int max = maxLinearPoints(points, i);
            if (max > answer) {
                answer = max;
            }
        }
     return answer;
    }

    private int maxLinearPoints(int[][] points, int index) {
        Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
        int x0 = points[index][0];
        int y0 = points[index][1];

        int x = 0, y = 0;
        int duplicate = 1;
        int vertical = 0;
        int countPoints = points.length;
        for (int i = 0; i < countPoints; i++) {
            if (i != index) {
                x = points[i][0];
                y = points[i][1];
                if (x == x0) {
                    if (y == y0) {
                        duplicate += 1;
                    } else {
                        vertical += 1;
                    }
                } else {
                    BigDecimal deltaX = BigDecimal.valueOf(x - x0);
                    BigDecimal deltaY = BigDecimal.valueOf(y - y0);
                    BigDecimal slope = deltaY.divide(deltaX, 16, RoundingMode.HALF_EVEN); // It's okay with FLOOR and it's okay with HALV_EVEN also
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
        }
        int max = 0;
        for (Integer num : map.values()) {
            if (num + duplicate > max) {
                max = num + duplicate;
            }
        }
        if (vertical + duplicate > max) {
            max = vertical + duplicate;
        }
        return max;
    }
}
