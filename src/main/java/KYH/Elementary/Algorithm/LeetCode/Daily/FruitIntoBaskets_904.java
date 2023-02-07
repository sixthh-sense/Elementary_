package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.*;

public class FruitIntoBaskets_904 {
    // output = sum of fruits from two types that have the largest amount
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitMap = new HashMap<>();
        int answer = 0;
        for (int fruit : fruits) {
            fruitMap.put(fruit, fruitMap.getOrDefault(fruit, 0) + 1);
        }
        ArrayList<Integer> answers = new ArrayList<>(fruitMap.values());
        answers.sort(Collections.reverseOrder());
        System.out.println(answers);
        answer = answers.get(0) + answers.get(1);
        return answer;
    }
}
