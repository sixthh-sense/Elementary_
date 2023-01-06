package KYH.Elementary.Algorithm.LeetCode.Daily;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* question link: https://leetcode.com/problems/maximum-ice-cream-bars/
It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.

Return the maximum number of ice cream bars the boy can buy with coins coins.

Note: The boy can buy the ice cream bars in any order.

costs.length == n
1 <= n <= 105
1 <= costs[i] <= 105
1 <= coins <= 108
* */
public class MaximumIceCreamBars_1833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int count = st.countTokens();
        int[] costs = new int[count]; // {1, 3, 2, 4, 1}
        for (int i = 0; i < count; i++) {
            costs[i]= Integer.parseInt(st.nextToken());
        }
        StringTokenizer next = new StringTokenizer(br.readLine());
        int coins = Integer.parseInt(next.nextToken()); // 7

        bw.write("" + maxIceCream(costs, coins));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int answer = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                coins = coins - cost;
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}
