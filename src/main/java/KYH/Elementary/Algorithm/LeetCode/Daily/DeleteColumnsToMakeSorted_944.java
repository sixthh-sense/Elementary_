package KYH.Elementary.Algorithm.LeetCode.Daily;

/* link: https://leetcode.com/problems/delete-columns-to-make-sorted/
* array of n strings strs (all of same length)
* strs = ["abc", "bce", "cae"]
* arranged as
* abc
* bce
* cae
* -> delete columns not sorted lexicographically
* abc, cee ok bca -> delete
* return the number of columns that you will delete
*
* n == strs.length
* 1 <= n <= 100
* 1 <= strs[i].length <= 1000
* strs[i] consists of lowercase English letters
* */
public class DeleteColumnsToMakeSorted_944 {
    public static void main(String[] args) {
        String[] strings = {"abcd", "bcef", "caew", "wert"};
        System.out.println(minDeletionSize(strings));;
    }

    public static int minDeletionSize(String[] strings) {
        int length = strings.length;
        int cLength = strings[0].length();
        int count = 0;
        for (int c = 0; c < cLength; c++) { // 열
            //Arrays.sort(strings[i].toCharArray()); -> 다 모아서 재정렬하기보다는 for문 돌 때 바로 체크하기
            for (int r = 0; r < length - 1; r++) { // 행
                char prev = strings[r].charAt(c);
                char next = strings[r + 1].charAt(c);
                // System.out.println(prev + "->" + next);
                if (prev > next) {
                    count += 1;
                    break; // break "inner" loop
                }
            }
        }
        return count;
    }
}
