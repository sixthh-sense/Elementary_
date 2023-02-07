package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.util.*;

public class FruitIntoBaskets_904 {
    // output = sum of fruits from two types that have the largest amount
    public int totalFruit(int[] fruits) {
        /* forgot about restraints :: will redo this code some other time(at least in one week, hopefully)
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
         */

        // below is the official solution ::
        // We use a hash map 'basket' to store the number of each type of fruit.
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxPicked = 0;

        // Add fruit from the right index (right) of the window.
        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If the current window has more than 2 types of fruit,
            // we remove fruit from the left index (left) of the window,
            // until the window has only 2 types of fruit.
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }

            // Update maxPicked.
            maxPicked = Math.max(maxPicked, right - left + 1);
        }

        // Return maxPicked as the maximum number of fruits we can collect.
        return maxPicked;
    }
}
