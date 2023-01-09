package KYH.Elementary.Algorithm.LeetCode.Daily;

import KYH.Elementary.Algorithm.LeetCode.util.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePreorderTraversal144Test {

    @Test
    void preorderTraversal() {
        assertAll(
                () -> test(new Integer[] {1, null, 2, 3}, new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                () -> test(new Integer[] {}, new ArrayList<Integer>()),
                () -> test(new Integer[] {1}, new ArrayList<Integer>(Arrays.asList(1)))
        );
    }

    private void test(Integer[] root, ArrayList<Integer> expected) {
        TreeNode treeNode = TreeNode.makeTree(root);
        BinaryTreePreorderTraversal_144 binaryTreePreorderTraversal_144 = new BinaryTreePreorderTraversal_144();
        List<Integer> actual = binaryTreePreorderTraversal_144.preorderTraversal(treeNode);
        assertEquals(expected, actual);
    }

}