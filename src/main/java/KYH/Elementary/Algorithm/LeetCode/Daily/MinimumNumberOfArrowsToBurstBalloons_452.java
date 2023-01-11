package KYH.Elementary.Algorithm.LeetCode.Daily;

/* question link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1
* */

/* 20230105 내 힘으로 못푼 문제
* https://ifuwanna.tistory.com/326
* shortest runtime: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/871943653/
* */

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        if (length == 1) {
            return 1;
        }
        Arrays.sort(points, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        //System.out.println(Arrays.deepToString(points));
        int arrows = 1;
        int prev = points[0][1];
        for (int i = 1; i < length; i++) {
            if (points[i][0] <= prev) {
                continue;
            } else {
                arrows += 1;
                prev = points[i][1];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
/*
    public class Solution {
        public int findMinArrowShots(int[][] points) {
            int rows = points.length;
            if(rows == 0) return 0;
            quickS(0, rows - 1, points);
            int MAX = Integer.MAX_VALUE;
            for(int i = 0; i < rows - 1; i++){
                if(points[i + 1][0] <= points[i][1]){
                    points[i + 1][1] = min(points[i][1], points[i + 1][1]);
                    points[i][0] = MAX;
                }
            }
            int counter = 0;
            for(int i = 0; i < rows; i++){
                if(points[i][0] != MAX) counter++;
            }
            return counter;
        }
        public int min(int a, int b){
            return a < b ? a : b;
        }
        public void quickS(int L, int H, int[][] p){
            int mid = p[(L + H) / 2][0];
            int start = L, end = H;
            do{
                while(p[start][0] < mid) start++;
                while(p[end][0] > mid) end--;
                if(end >= start){
                    int temp = p[start][0];
                    p[start][0] = p[end][0];
                    p[end][0] = temp;
                    temp = p[start][1];
                    p[start][1] = p[end][1];
                    p[end][1] = temp;
                    end--;
                    start++;
                }
            }while(start <= end);
            if(L < end) quickS(L, end, p);
            if(start < H) quickS(start, H, p);
        }
    }*/
}
