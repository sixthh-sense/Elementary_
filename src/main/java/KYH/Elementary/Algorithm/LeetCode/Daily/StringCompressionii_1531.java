package KYH.Elementary.Algorithm.LeetCode.Daily;

// couldn't solve it by myself: have to swallow it
// link: https://leetcode.com/problems/string-compression-ii/discuss/757363/Java-Easy-and-fast-DP-solution-with-comments-50ms-Space-O(n2)
// s is 1<=s<=100 and k is equal or smaller than s(not minus)
public class StringCompressionii_1531 {
    public static void main(String[] args) {
        String s = "aabbaa";
        int k = 2;
        System.out.println(getLengthOfOptimalCompression(s, k));
    }
    public static int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k] -> minimum length of s.substring(0, i + 1) with k deletion(max)
        int len = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j] = 9999;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0, del = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if (j - del >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                    }
                }
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[len][k];
    }
}
