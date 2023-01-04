package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.HashMap;

/* link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
* You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
*
* 1 <= tasks.length <= 105
* 1 <= tasks[i] <= 109
* */
public class MinimumRoundsToCompleteAllTasks_2244 {
    public static void main(String[] args) { // HashMap이 나을까 int[][]이 나을까?
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4}; // {2, 3, 3};
        System.out.println(minimumRounds(tasks));
    }

    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> record = new HashMap<>();
        int answer = 0;
        for (int task : tasks) {
            if (!record.containsKey(task)) {
                record.put(task, 1);
            } else {
                record.put(task, record.get(task) + 1);
            }
        }

        for (Integer value : record.values()) {
            if (value == 1) {
                return -1;
            } else if ((value % 3) == 0) {
                answer += (value / 3);
            } else {
                answer += (value / 3) + 1;
            }
        }
        return answer;
    }
}

/* runtime 9ms leetcode 풀이
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        for (int i = 0; i < tasks.length;) {
            int j = i + 1;
            while (j < tasks.length && tasks[j] == tasks[i]) j++;
            if (j == i + 1) return -1;
            res += compute(j - i);
            i = j;
        }
        return res;
    }

    private int compute(int i) {
        if (i % 3 == 0) return i / 3;
        if (i % 3 == 2) return (i - 2) / 3 + 1;
        return (i - 4) / 3 + 2;
    }
* */