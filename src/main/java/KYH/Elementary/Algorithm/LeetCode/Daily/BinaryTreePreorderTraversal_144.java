package KYH.Elementary.Algorithm.LeetCode.Daily;

import KYH.Elementary.Algorithm.LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/* link: https://leetcode.com/problems/binary-tree-preorder-traversal/
** 풀이: https://ifuwanna.tistory.com/373
Given the root of a binary tree, return the preorder traversal of its nodes' values.

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
* */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        } else {
            orderTraverse(root, answer);
        }
        return answer;
    }

    public void orderTraverse(TreeNode node, List<Integer> answer) {
        if (node == null) {
            return;
        }
        answer.add(node.val);
        orderTraverse(node.left, answer);
        orderTraverse(node.right, answer);
    }
}
