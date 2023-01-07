package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.io.*;
import java.util.StringTokenizer;

/* link: https://leetcode.com/problems/gas-station/
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
* */
public class GasStation_134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        int count = st.countTokens();
        int[] gas = new int[count];
        for (int i = 0; i < count; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
        int[] cost = new int[count];
        for (int i = 0; i < count; i++) {
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        bw.write("" + canCompleteCircuit(gas, cost));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasCount = gas.length;
        int curLoc = 0, toLoc = 0, answer = 0;
        for (int i = 0; i < gasCount; i++) {
            curLoc += (gas[i] - cost[i]);
            toLoc += (gas[i] - cost[i]);
            if (curLoc < 0) {
                curLoc = 0;
                answer += 1;
            }
        }
        return (toLoc < 0) ? -1 : answer;
    }
}
